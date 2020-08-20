package io.intino.goros.box;

import org.monet.space.kernel.Kernel;
import org.monet.space.kernel.configuration.ConfigurationMap;
import org.monet.space.kernel.configuration.DatabaseConfiguration;

import java.util.Map;

public class Goros {

	public static void open(Map<String, String> parameters) {
		DatabaseConfiguration databaseConfiguration = DatabaseConfiguration.fromMap(parameters);
		ConfigurationMap configuration = ConfigurationMap.fromMap(parameters);
		Kernel.getInstance().run(configuration, databaseConfiguration);
	}

}
