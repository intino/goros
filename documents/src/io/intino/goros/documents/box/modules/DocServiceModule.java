package io.intino.goros.documents.box.modules;

import com.google.inject.AbstractModule;
import io.intino.goros.documents.box.configuration.ConfigurationImpl;
import io.intino.goros.documents.box.configuration.DatabaseConfiguration;
import io.intino.goros.documents.box.configuration.DatabaseLoader;
import io.intino.goros.documents.box.configuration.ServerConfiguratorImpl;
import org.monet.docservice.docprocessor.configuration.Configuration;
import org.monet.docservice.docprocessor.configuration.ServerConfigurator;
import org.monet.docservice.guice.modules.MainModule;

import java.util.Map;

public class DocServiceModule extends AbstractModule {
	private Configuration configuration;
	private final DatabaseConfiguration databaseConfiguration;
	private final ServerConfiguratorImpl serverConfigurator;

	public DocServiceModule(Map<String, String> parameters) {
		this.databaseConfiguration = DatabaseConfiguration.fromMap(parameters);
		this.configuration = new ConfigurationImpl(parameters);
		this.serverConfigurator = new ServerConfiguratorImpl(parameters);
	}

	@Override
	protected void configure() {
		DatabaseLoader.load(databaseConfiguration);
		install(new MainModule());
		bind(ServerConfigurator.class).toInstance(serverConfigurator);
		bind(Configuration.class).toInstance(configuration);
	}

}