package io.intino.goros.unit.box;

import io.intino.goros.unit.box.install.Install;
import org.monet.space.kernel.Kernel;
import org.monet.space.kernel.configuration.ConfigurationMap;
import org.monet.space.kernel.configuration.DatabaseConfiguration;

import java.util.Map;

public class GorosUnit {

	public static void open(Map<String, String> parameters) {
		install(parameters);
		openUnit(parameters);
	}

	private static void install(Map<String, String> parameters) {
		Install install = new Install(parameters);
		install.initWorkspace();
		install.processDB();
		install.processLogs();
		install.processCertificates();
	}

	private static void openUnit(Map<String, String> parameters) {
		DatabaseConfiguration databaseConfiguration = DatabaseConfiguration.fromMap(parameters);
		ConfigurationMap configuration = ConfigurationMap.fromMap(parameters);
		Kernel.getInstance().run(configuration, databaseConfiguration);
	}

}