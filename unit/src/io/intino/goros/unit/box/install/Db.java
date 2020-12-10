package io.intino.goros.unit.box.install;


import io.intino.alexandria.logger.Logger;
import oracle.jdbc.pool.OracleDataSource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Db {
  private String url = "";
  private String user = "";
  private String password = "";
  private String dbname = "";
  private String host = "";
  private String port = "";
  private String dbType = "";

  public Db(String url, String user, String password) {
    this.url = url;
    this.dbname = getDbNameFromUrl(url);
    this.user = user.replaceAll("#dbname#", this.dbname);
    this.password = password.replaceAll("#dbname#", this.dbname);
    dbType = getDbTypeFromUrl(url);
    String pattern_string = "Not database compatible.";

    if (dbType.equals("mysql")) {
      try {
        Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

      pattern_string = ".*:.*://(.*):(.*)/.*";
      Pattern pattern = Pattern.compile(pattern_string);
      Matcher matcher = pattern.matcher(url);

      if (matcher.find()) {
        host = matcher.group(1);
        if (host.equals("localhost"))
          host = "127.0.0.1";
        port = matcher.group(2);
      }

      if (host.equals("") || port.equals("")) {
        pattern_string = ".*:.*://(.*)/.*";
        pattern = Pattern.compile(pattern_string);
        matcher = pattern.matcher(url);

        port = "3306";
        if (matcher.find()) {
          host = matcher.group(1);
          if (host.equals("localhost"))
            host = "127.0.0.1";
        }
      }
    } else {
      if (dbType.equals("oracle")) {
        pattern_string = ".*:.*:.*:.*/.*@(.*):(.*):.*";
        Pattern pattern = Pattern.compile(pattern_string);
        Matcher matcher = pattern.matcher(url);

        if (matcher.find()) {
          host = matcher.group(1);
          port = matcher.group(2);
        }
      }
    }
  }

  public void executeScript(String fileName) throws SQLException, IOException {
    if (dbType.equals("oracle")) {
      OracleDataSource ods = new OracleDataSource();
      ods.setUser(user);
      ods.setPassword(password);
      ods.setURL(url);
      Connection connection = ods.getConnection();

      try {
        ScriptRunner scriptRunner = new ScriptRunner(connection, true, false);

        Reader reader = new FileReader(fileName);
        scriptRunner.runScript(reader);
      } finally {
        connection.close();
      }
    } else {
      if (dbType.equals("mysql")) {
        String command = "";
        String passwordText = "";
        if (!password.equals(""))
          passwordText = " --password=\"" + password + "\" ";

        Logger.info("Deploy mysql file: " + fileName);

        command = "mysql --default-character-set=utf8 --host=" + host + " --port=" + port + " --database=" + dbname + " --user=" + user + passwordText + " < " + fileName + " 2>&1";
        Logger.info(command);

        Shell shell = new Shell();
        if (shell.executeCommand(command, new File(new File(fileName).getParent())) > 0) {
          throw new RuntimeException("Error exec database script. Info: " + shell.lastInfo());
        }
      }
    }
  }

  private String getDbTypeFromUrl(String url) {
    return url.toLowerCase().split(":")[1];
  }
  private String getDbNameFromUrl(String url) {
    Pattern pattern = Pattern.compile(".*:.*://.*/(.*)\\?.*");
    if (getDbTypeFromUrl(url).equals("oracle"))
      pattern = Pattern.compile(".*:.*:.*:(.*)/.*");

    Matcher matcher = pattern.matcher(url);

    String dbName = "";
    if (matcher.find()) {
      dbName = matcher.group(1);
    }

    return dbName;
  }
}
