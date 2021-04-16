package io.intino.goros.shared.install;


import io.intino.alexandria.logger.Logger;
import oracle.jdbc.pool.OracleDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
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
        Class.forName("com.mysql.cj.jdbc.Driver");
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

  public void executeScript(Reader reader) throws SQLException, IOException {
    if (dbType.equals("oracle")) {
      OracleDataSource ods = new OracleDataSource();
      ods.setUser(user);
      ods.setPassword(password);
      ods.setURL(url);
      Connection connection = ods.getConnection();

      try {
        ScriptRunner scriptRunner = new ScriptRunner(connection, true, false);
        scriptRunner.runScript(reader);
      } finally {
        connection.close();
      }
    } else {
      if (dbType.equals("mysql")) {
        File tempFile = File.createTempFile("script", ".sql");
        String fileName = tempFile.getAbsolutePath();
        tempFile.deleteOnExit();

        int intValueOfChar;
        StringBuilder buffer = new StringBuilder();
        while ((intValueOfChar = reader.read()) != -1) {
          buffer.append((char) intValueOfChar);
        }
        Writer targetFileWriter = new FileWriter(tempFile);
        targetFileWriter.write(buffer.toString());
        targetFileWriter.close();

        String command = "";
        String passwordText = "";
        if (!password.equals(""))
          passwordText = " --password=\"" + password + "\" ";

        Logger.info("Deploy mysql file: " + fileName);

        command = "mysql --default-character-set=utf8 --host=" + host + " --port=" + port + " --database=" + dbname + " --user=" + user + passwordText + " < " + fileName + "";
        Logger.info(command);

        Shell shell = new Shell();
        if (shell.executeCommand(command, new File(new File(fileName).getParent())) > 0) {
          throw new RuntimeException("Error exec database script. Info: " + shell.lastInfo());
        }
      }
    }
  }

  public String executeSentence(String sentence) throws SQLException, IOException {
    String result = "";
    if (dbType.equals("oracle")) {
      OracleDataSource ods = new OracleDataSource();
      ods.setUser(user);
      ods.setPassword(password);
      ods.setURL(url);
      Connection connection = ods.getConnection();
      sentence = sentence.replaceAll("`", "").replaceAll("\"", "'");

      ResultSet rs = null;
      try {
        rs = connection.createStatement().executeQuery(sentence);

        String sentence_op = sentence.split(" ")[0];
        if ((!sentence_op.equals("INSERT")) && (!sentence_op.equals("DELETE"))) {
          try {
            rs.next();
            Object value = rs.getObject(1);
            result = value.toString();
          } catch (Exception e) {
            Logger.warn("SQL: " + sentence + ". SQLException: " + e.getMessage());
          }
        }
      } finally {
        if (rs != null)
          rs.close();
        connection.close();
      }
    } else {
      if (dbType.equals("mysql")) {
        String command = "";
        String passwordText = "";
        if (!password.equals(""))
          passwordText = " --password=\"" + password + "\" ";

        sentence = "\"" + sentence + "\"";
        command = "mysql --default-character-set=utf8 --silent --host=" + host + " --port=" + port + " --database=" + dbname + " --user=" + user + passwordText + " --execute=" + sentence;

        Shell shell = new Shell();
        result = shell.executeCommandWithResponse(command, new File(getPath()));

      }
    }
    return result.replaceAll("\n", "");
  }

  public String getDbname() { return getDbNameFromUrl(url); }
  public String getDbType() { return getDbTypeFromUrl(url); }

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
  private String getPath() {
    String path = "";
    try {
      path = new java.io.File(".").getCanonicalPath();
    } catch (Exception exception) {
      Logger.error("Unable to read current path.");
    }
    return path;
  }

}
