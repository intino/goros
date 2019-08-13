package org.siani.goros.box;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.monet.space.kernel.configuration.ConfigurationMap;
import org.monet.space.kernel.configuration.DatabaseConfiguration;
import org.siani.goros.graph.BusinessUnit;
import org.monet.space.kernel.Kernel;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Goros {

	public static void start(BusinessUnit unit) {
		DatabaseConfiguration databaseConfiguration = DatabaseConfiguration.fromXml(Goros.class.getResource("/monet.config").getFile());
		ConfigurationMap configuration = ConfigurationMap.fromXml(Goros.class.getResource("/monet.config").getFile());
		Kernel.getInstance().run(configuration, databaseConfiguration);
	}

}
