package io.intino.goros.documents.box.configuration;

import java.util.Map;

public class DatabaseConfiguration {

    private static DatabaseConfiguration instance;
    private Map<String, String> map;

    private static final String JDBC_TYPE = "jdbc-type";
    private static final String JDBC_DATASOURCE = "jdbc-datasource";
    private static final String DATABASE_URL = "jdbc-url";
    private static final String DATABASE_USER = "jdbc-user";
    private static final String DATABASE_PASSWORD = "jdbc-password";

    public static DatabaseConfiguration getInstance() {
        return instance;
    }

    public DatabaseConfiguration(Map<String, String> map) {
        this.map = map;
        instance = this;
    }

    public String url() {
        return map.get(DATABASE_URL);
    }

    public String user() {
        return map.get(DATABASE_USER);
    }

    public String password() {
        return map.get(DATABASE_PASSWORD);
    }

    public String datasource() {
        return map.get(JDBC_DATASOURCE);
    }

    public DatabaseType type() {
        String value = map.get(JDBC_TYPE);
        for (DatabaseType type : DatabaseType.values()) {
            if (value.toLowerCase().contains(type.name().toLowerCase())) return type;
        }
        return DatabaseType.MYSQL;
    }

    public enum DatabaseType {
        MYSQL, ORACLE
    }

    public static DatabaseConfiguration fromMap(Map<String, String> map) {
    	return new DatabaseConfiguration(map);
	}

}