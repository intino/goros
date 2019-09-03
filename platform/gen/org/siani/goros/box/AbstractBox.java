package org.siani.goros.box;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import java.util.HashMap;
import java.util.Map;

import io.intino.alexandria.logger.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import io.intino.alexandria.ui.Soul;

public abstract class AbstractBox extends io.intino.alexandria.ui.AlexandriaUiBox {
	protected GorosConfiguration configuration;
    protected Map<String, Soul> uiSouls = new java.util.HashMap<>();
    private java.util.List<io.intino.alexandria.ui.AlexandriaUiBox.SoulsClosed> soulsClosedListeners = new java.util.ArrayList<>();
	private io.intino.alexandria.ui.services.AuthService authService;

	public AbstractBox(String[] args) {
		this(new GorosConfiguration(args));
	}

	public AbstractBox(GorosConfiguration configuration) {
		this.configuration = configuration;
		initJavaLogger();
		io.intino.alexandria.rest.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		io.intino.alexandria.rest.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		io.intino.alexandria.rest.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		io.intino.alexandria.rest.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		this.authService = null;
		if(configuration().get("port") != null && !configuration().get("port").isEmpty())io.intino.alexandria.rest.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		io.intino.alexandria.rest.AlexandriaSparkBuilder.setUI(true);
		io.intino.alexandria.rest.AlexandriaSparkBuilder.addParameters(this.authService);
	}

	public GorosConfiguration configuration() {
		return configuration;
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		return this;
	}

	public io.intino.alexandria.core.Box open() {
		if (owner != null) owner.open();
		initUI();
		initRESTServices();
		initJMXServices();
		initDatalake();
		initMessageHub();
		initMessagingServices();
		initSentinels();
		initSlackBots();
		initWorkflow();
		return this;
	}

	public void close() {
		if (owner != null) owner.close();
		io.intino.alexandria.rest.AlexandriaSparkBuilder.instance().stop();
	}

	public java.util.List<Soul> souls() {
		return new java.util.ArrayList<>(uiSouls.values());
	}

		public java.util.Optional<Soul> soul(String clientId) {
			return java.util.Optional.ofNullable(uiSouls.get(clientId));
		}

		public void registerSoul(String clientId, Soul soul) {
			uiSouls.put(clientId, soul);
		}

		public void unRegisterSoul(String clientId) {
			uiSouls.remove(clientId);
			if (uiSouls.size() <= 0) notifySoulsClosed();
		}

		public void onSoulsClosed(io.intino.alexandria.ui.AlexandriaUiBox.SoulsClosed listener) {
			this.soulsClosedListeners.add(listener);
		}

		private void notifySoulsClosed() {
			soulsClosedListeners.forEach(l -> l.accept());
		}

	protected abstract io.intino.alexandria.ui.services.AuthService authService(java.net.URL authServiceUrl);

	private void initRESTServices() {
		BackserviceService.setup(io.intino.alexandria.rest.AlexandriaSparkBuilder.instance(), (GorosBox) this).start();
		Logger.info("REST service backservice: started!");
		FrontserviceService.setup(io.intino.alexandria.rest.AlexandriaSparkBuilder.instance(), (GorosBox) this).start();
		Logger.info("REST service frontservice: started!");
		FmsserviceService.setup(io.intino.alexandria.rest.AlexandriaSparkBuilder.instance(), (GorosBox) this).start();
		Logger.info("REST service fmsservice: started!");
		FmsserviceService.setup(io.intino.alexandria.rest.AlexandriaSparkBuilder.instance(), (GorosBox) this).start();
		Logger.info("REST service fmsservice: started!");
	}

	private void initMessagingServices() {

	}

	private void initJMXServices() {

	}

	private void initSlackBots() {

	}

	private void initUI() {
		if (configuration().get("port") == null || !io.intino.alexandria.rest.AlexandriaSparkBuilder.isUI()) return;
		io.intino.alexandria.ui.UISpark sparkInstance = (io.intino.alexandria.ui.UISpark) io.intino.alexandria.rest.AlexandriaSparkBuilder.instance();
		io.intino.alexandria.ui.services.push.PushService pushService = new io.intino.alexandria.ui.services.push.PushService();
		org.siani.goros.box.ui.PlatformUiService.init(sparkInstance, (GorosBox) this, pushService);
		io.intino.alexandria.ui.UiElementsService.initDisplays(sparkInstance, pushService);

		sparkInstance.start();
		Logger.info("UI PlatformUi: started!");
	}

	private void initDatalake() {
	}

	private void initMessageHub() {
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

	private java.net.URL url(String url) {
		try {
			return new java.net.URL(url);
		} catch (java.net.MalformedURLException e) {
			return null;
		}
	}
}