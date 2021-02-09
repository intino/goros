package io.intino.goros.documents.box.install;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.shared.install.Db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Map;

public class Install {
  private Db db;
  public Install(Map<String, String> parameters) {

    String DbUrl = parameters.get("Jdbc.Url");
    String DbUser = parameters.get("Jdbc.User");
    String DbPassword = parameters.get("Jdbc.Password");
    // Oracle local: https://www.databasestar.com/oracle-mac/
    db = new Db(DbUrl, DbUser, DbPassword);
  }

  public void processDB() {
    if (!installedDb()) {
      Logger.info("Install database...");

      String sqlScript = "/kernel/database/mysql.sql";
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

  private boolean installedDb() {
    try {
      String count = db.executeSentence("SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = '" + db.getDbname() + "'");
      return (Integer.parseInt(count) > 0);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return true;
  }

}
