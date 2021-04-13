package io.intino.goros.documents.box.install;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.shared.install.Db;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Install {
  private Db db;
  private String workspace;

  public Install(Map<String, String> parameters) {

    String DbUrl = parameters.get("jdbc-url");
    String DbUser = parameters.get("jdbc-user");
    String DbPassword = parameters.get("jdbc-password");
    // Oracle local: https://www.databasestar.com/oracle-mac/
    db = new Db(DbUrl, DbUser, DbPassword);

    workspace = parameters.get("workspace");
  }

  public void initWorkspace() {
    File f = new File(workspace);
    if(! f.exists()) {
      f.mkdirs();
    }
  }
  public void processDB() {
    if (!installedDb()) {
      Logger.info("Install database...");

      String sqlScript = "/database/mysql.sql";
      InputStream in = Install.class.getResourceAsStream(sqlScript);
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));

      try {
        db.executeScript(reader);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void processFonts() {
    if (! installedFonts()) {
      String folderFonts = workspace + "/fonts";
      File f = new File(folderFonts);
      f.mkdirs();

      ArrayList<String> files = null;
      try {
        files = listFilesJar(this.getClass().getResource("/WEB-INF/user_data/fonts").getPath());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }

      for (String filefont: files) {
        String filename = "/WEB-INF/user_data/fonts/" + filefont;
        InputStream in = Install.class.getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
          io.intino.goros.shared.install.Files.saveReaderFile(reader, new File(workspace + "/fonts/" + filefont));
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private boolean installedDb() {
    try {
      String count = db.executeSentence("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + db.getDbname() + "' and table_name = 'ds\\$documents'");
      return (!count.isEmpty() && Integer.parseInt(count) > 0);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

  private boolean installedFonts() {
    File f = new File(workspace + "/fonts");
    if(f.exists() && f.isDirectory()) {
      return true;
    }
    return false;
  }

  private ArrayList<String> listFilesJar(String dirname) throws IOException, URISyntaxException {
    String jarFile = "jar:"+ dirname.substring(0, (dirname.indexOf("jar!") + "jar".length()));
    String pathRelative = dirname.substring(dirname.indexOf("jar!") + "jar!".length());
    URI uri = new URI(jarFile);

    FileSystem fileSystem;
    try {
      fileSystem = FileSystems.getFileSystem(uri);
    } catch (Exception e) {
      fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
    }

    final ArrayList<String> result = new ArrayList<>();
    java.nio.file.Files.walkFileTree(fileSystem.getPath(pathRelative), new SimpleFileVisitor<Path>(){
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        print(file);
        return FileVisitResult.CONTINUE;
      }

      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        print(dir);
        return FileVisitResult.CONTINUE;
      }

      /**
       * prints out details about the specified path
       * such as size and modification time
       * @param file
       * @throws IOException
       */
      private void print(Path file) throws IOException{
        if (! Files.isDirectory(file))
          result.add(file.getFileName().toString());
      }
    });

    return result;
  }
}
