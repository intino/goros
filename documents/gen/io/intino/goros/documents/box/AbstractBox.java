package io.intino.goros.documents.box;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import io.intino.alexandria.logger.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public abstract class AbstractBox extends io.intino.alexandria.core.Box {
	protected DocumentsConfiguration configuration;

	public AbstractBox(String[] args) {
		this(new DocumentsConfiguration(args));
	}

	public AbstractBox(DocumentsConfiguration configuration) {
		this.configuration = configuration;
		initJavaLogger();
	}

	public DocumentsConfiguration configuration() {
		return configuration;
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		return this;
	}

	public abstract void beforeStart();

	public io.intino.alexandria.core.Box start() {
		if (owner != null) owner.beforeStart();
		beforeStart();
		if (owner != null) owner.startServices();
		startServices();
		if (owner != null) owner.afterStart();
		afterStart();
		return this;
	}

	public abstract void afterStart();

	public abstract void beforeStop();

	public void stop() {
		if (owner != null) owner.beforeStop();
		beforeStop();
		if (owner != null) owner.stopServices();
		stopServices();
		if (owner != null) owner.afterStop();
		afterStop();
	}

    @Override
	public void stopServices() {
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().stop();
	}

	public abstract void afterStop();

    @Override
	public void startServices() {
		initUI();
		initConnector();
		initRestServices();
		initSoapServices();
		initJmxServices();
		initDatalake();
		initTerminal();
		initMessagingServices();
		initSentinels();
		initSlackBots();
		initWorkflow();
	}



	private void initRestServices() {
		if(configuration().get("port") == null || configuration().get("port").isEmpty()) return;
		io.intino.alexandria.http.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		DocserviceService.setup(io.intino.alexandria.http.AlexandriaSparkBuilder.instance(), (DocumentsBox) this);
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().start();
		Logger.info("Rest service docservice: started at port " + configuration().get("port") + "!");
	}

	private void initSoapServices() {

	}

	private void initMessagingServices() {

	}

	private void initJmxServices() {

	}

	private void initSlackBots() {

	}

	private void initUI() {

	}

	private void initDatalake() {
	}

	private void initConnector() {
	}

	private void initTerminal() {
	}

	private void initSentinels() {
	}

	private void initWorkflow() {
	}

	private void initJavaLogger() {
		final java.util.logging.Logger Logger = java.util.logging.Logger.getGlobal();
		final ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.INFO);
		handler.setFormatter(new io.intino.alexandria.logger.Formatter());
		Logger.setUseParentHandlers(false);
		Logger.addHandler(handler);
	}

	protected java.net.URL url(String url) {
		try {
			return new java.net.URL(url);
		} catch (java.net.MalformedURLException e) {
			return null;
		}
	}
}