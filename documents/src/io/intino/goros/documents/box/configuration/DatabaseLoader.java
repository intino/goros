package io.intino.goros.documents.box.configuration;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import io.intino.alexandria.logger.Logger;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import java.sql.SQLException;

public class DatabaseLoader {

    public static void load(DatabaseConfiguration configuration) {
        try {
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");

            InitialContext initialContext = new InitialContext();
            initialContext.createSubcontext("java:");
            initialContext.createSubcontext("java:comp");
            initialContext.createSubcontext("java:comp/env");
            initialContext.createSubcontext("java:comp/env/jdbc");
            initialContext.bind("java:comp/env/" + configuration.datasource(), dataSource(configuration));
        } catch (NamingException | SQLException e) {
            Logger.error(e);
        }
    }

    private static ConnectionPoolDataSource dataSource(DatabaseConfiguration configuration) throws SQLException {
        switch (configuration.type()) {
            case MYSQL:
                return mysqlDataSource(configuration);
            case ORACLE:
                return oracleDataSource(configuration);
            default:
                return null;
        }
    }

    private static ConnectionPoolDataSource mysqlDataSource(DatabaseConfiguration database) {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setURL(database.url());
        dataSource.setUser(database.user());
        dataSource.setPassword(database.password());
        return dataSource;
    }

    private static ConnectionPoolDataSource oracleDataSource(DatabaseConfiguration database) throws SQLException {
        OracleConnectionPoolDataSource dataSource = new OracleConnectionPoolDataSource();
        dataSource.setURL(database.url());
        dataSource.setUser(database.user());
        dataSource.setPassword(database.password());
        return dataSource;
    }
}
