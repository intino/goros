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
    private static final String DATABASE_MAX_ACTIVE_CONNECTIONS = "jdbc-max-active-connections";
    private static final String DATABASE_MAX_IDLE_CONNECTIONS = "jdbc-max-idle-connections";
    private static final String DATABASE_REMOVE_ABANDONED_TIMEOUT = "jdbc-remove-abandoned-timeout";

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

    public int maxActiveConnections() {
        return map.containsKey(DATABASE_MAX_ACTIVE_CONNECTIONS) ? Integer.parseInt(map.get(DATABASE_MAX_ACTIVE_CONNECTIONS)) : 15;
    }

    public int maxIdleConnections() {
        return map.containsKey(DATABASE_MAX_IDLE_CONNECTIONS) ? Integer.parseInt(map.get(DATABASE_MAX_IDLE_CONNECTIONS)) : 2;
    }

    public int removeAbandonedTimeout() {
        return map.containsKey(DATABASE_REMOVE_ABANDONED_TIMEOUT) ? Integer.parseInt(map.get(DATABASE_REMOVE_ABANDONED_TIMEOUT)) : 300;
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