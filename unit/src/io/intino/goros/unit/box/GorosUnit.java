package io.intino.goros.unit.box;

import org.monet.space.kernel.Kernel;
import org.monet.space.kernel.configuration.ConfigurationMap;
import org.monet.space.kernel.configuration.DatabaseConfiguration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class GorosUnit {

	public static void open(Map<String, String> parameters) {
		install(parameters);
		openUnit(parameters);
	}

	private static void install(Map<String, String> parameters) {
		// TODO RL
		System.out.println("test");


		InputStream in = GorosUnit.class.getResourceAsStream("/kernel/database/mysql.sql");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));




	}

	private static void openUnit(Map<String, String> parameters) {
		DatabaseConfiguration databaseConfiguration = DatabaseConfiguration.fromMap(parameters);
		ConfigurationMap configuration = ConfigurationMap.fromMap(parameters);
		Kernel.getInstance().run(configuration, databaseConfiguration);
	}

}