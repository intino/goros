package io.intino.goros.documents.box.configuration;

import org.monet.docservice.docprocessor.configuration.ServerConfigurator;

import java.util.Map;

public class ServerConfiguratorImpl implements ServerConfigurator {
  private Map<String, String> parameters;

  public ServerConfiguratorImpl(Map<String, String> parameters) {
    this.parameters = parameters;
  }

  @Override
  public String getUserPath() {
    return parameters.get("workspace");
  }
}
