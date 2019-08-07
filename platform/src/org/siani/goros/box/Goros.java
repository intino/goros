package org.siani.goros.box;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.siani.goros.graph.BusinessUnit;
import org.monet.space.kernel.Kernel;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Goros {

	public static void start(BusinessUnit unit) {
		org.monet.space.kernel.model.Context.getInstance().setFrameworkName("monet-3.2");
		injectContext();
		Kernel.getInstance().run();
	}

	private static void injectContext() {
		try {
			// Use Apache Tomcat's Directory
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
			// Standard hook
			InitialContext initialContext = new InitialContext();
			// Create binding
			initialContext.createSubcontext("java:");
			initialContext.createSubcontext("java:comp");
			initialContext.createSubcontext("java:comp/env");
			initialContext.createSubcontext("java:comp/env/jdbc");
			// Construct DataSource
			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setRetainStatementAfterResultSetClose(true);
			dataSource.setURL("jdbc:mysql://localhost:3306/monet-3.2?autoReconnect=true");
			dataSource.setUser("root");
			dataSource.setPassword("");

			initialContext.bind("java:comp/env/jdbc/MonetDatabaseSource", dataSource);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
