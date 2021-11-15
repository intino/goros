package io.intino.goros.documents.box.configuration;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import io.intino.alexandria.logger.Logger;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import javax.naming.Context;
import javax.naming.InitialContext;
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
        } catch (Throwable e) {
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

    private static ConnectionPoolDataSource mysqlDataSource(DatabaseConfiguration configuration) {
        return dataSource(configuration, "com.mysql.jdbc.Driver");
    }

    private static ConnectionPoolDataSource oracleDataSource(DatabaseConfiguration configuration) {
        return dataSource(configuration, "oracle.jdbc.OracleDriver");
    }

    private static ConnectionPoolDataSource dataSource(DatabaseConfiguration configuration, String driver) {
        DataSource datasource = new DataSource();
        datasource.setPoolProperties(poolProperties(configuration, driver));
        return datasource;
    }

    private static PoolProperties poolProperties(DatabaseConfiguration configuration, String driver) {
        PoolProperties p = new PoolProperties();
        p.setUrl(configuration.url());
        p.setUsername(configuration.user());
        p.setPassword(configuration.password());
        p.setDriverClassName(driver);
        p.setMaxActive(15);
        p.setMaxIdle(2);
        p.setMaxWait(30000);
        p.setRemoveAbandoned(true);
        p.setRemoveAbandonedTimeout(300); // 5 min
        p.setLogAbandoned(true);
        p.setAccessToUnderlyingConnectionAllowed(true);
        p.setValidationQuery("SELECT 1");
        p.setValidationQueryTimeout(10);
        p.setValidationInterval(10000);
        p.setTestOnBorrow(true);
        p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        return p;
    }

}
