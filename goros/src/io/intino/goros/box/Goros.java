package io.intino.goros.box;

import org.monet.space.kernel.Kernel;
import org.monet.space.kernel.configuration.ConfigurationMap;
import org.monet.space.kernel.configuration.DatabaseConfiguration;
import io.intino.goros.graph.BusinessUnit;

public class Goros {

	public static void open(BusinessUnit unit) {
		DatabaseConfiguration databaseConfiguration = DatabaseConfiguration.fromXml(Goros.class.getResource("/monet.config").getFile());
		ConfigurationMap configuration = ConfigurationMap.fromXml(Goros.class.getResource("/monet.config").getFile());
		Kernel.getInstance().run(configuration, databaseConfiguration);
	}

}
