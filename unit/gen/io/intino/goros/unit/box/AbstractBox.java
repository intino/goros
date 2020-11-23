package io.intino.goros.unit.box;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import java.util.HashMap;
import java.util.Map;

import io.intino.alexandria.logger.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import io.intino.alexandria.ui.services.push.PushService;
import io.intino.alexandria.ui.Soul;

public abstract class AbstractBox extends io.intino.alexandria.ui.AlexandriaUiBox {
	protected UnitConfiguration configuration;
    protected Map<String, Soul> uiSouls = new java.util.HashMap<>();
    private java.util.List<io.intino.alexandria.ui.AlexandriaUiBox.SoulsClosed> soulsClosedListeners = new java.util.ArrayList<>();
	private io.intino.alexandria.ui.services.AuthService authService;
	private PushService pushService;

	public AbstractBox(String[] args) {
		this(new UnitConfiguration(args));
	}

	public AbstractBox(UnitConfiguration configuration) {
		this.configuration = configuration;
		initJavaLogger();
	}

	public UnitConfiguration configuration() {
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
		if (owner != null) owner.start();
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
		if (owner != null) owner.afterStart();
		afterStart();
		return this;
	}

	public abstract void afterStart();

	public abstract void beforeStop();

	public void stop() {
		if (owner != null) owner.beforeStop();
		beforeStop();
		if (owner != null) owner.stop();
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().stop();
		if (owner != null) owner.afterStop();
		afterStop();
	}

	public abstract void afterStop();

	public PushService pushService() {
	    return pushService;
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

	public void setupUi() {
		if(configuration().get("port") == null || configuration().get("port").isEmpty()) return;
		this.authService = null;
		io.intino.alexandria.http.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		io.intino.alexandria.http.AlexandriaSparkBuilder.setUI(true);
		io.intino.alexandria.http.AlexandriaSparkBuilder.addParameters(this.authService);
		this.pushService = new io.intino.alexandria.ui.services.push.PushService();
		io.intino.alexandria.ui.UISpark sparkInstance = (io.intino.alexandria.ui.UISpark) io.intino.alexandria.http.AlexandriaSparkBuilder.instance();
		io.intino.goros.unit.box.ui.UnitElementsService.init(sparkInstance, (UnitBox) this, pushService,  new io.intino.goros.unit.box.ui.displays.RouteDispatcher());
		io.intino.alexandria.ui.UiElementsService.initDisplays(sparkInstance, pushService);
	}

	private void initRestServices() {
		if(configuration().get("port") == null || configuration().get("port").isEmpty()) return;
		io.intino.alexandria.http.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		FmsserviceService.setup(io.intino.alexandria.http.AlexandriaSparkBuilder.instance(), (UnitBox) this);
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().start();
		Logger.info("Rest service fmsservice: started at port " + configuration().get("port") + "!");
		if(configuration().get("port") == null || configuration().get("port").isEmpty()) return;
		io.intino.alexandria.http.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		FrontserviceService.setup(io.intino.alexandria.http.AlexandriaSparkBuilder.instance(), (UnitBox) this);
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().start();
		Logger.info("Rest service frontservice: started at port " + configuration().get("port") + "!");
		if(configuration().get("port") == null || configuration().get("port").isEmpty()) return;
		io.intino.alexandria.http.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		BackserviceService.setup(io.intino.alexandria.http.AlexandriaSparkBuilder.instance(), (UnitBox) this);
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().start();
		Logger.info("Rest service backservice: started at port " + configuration().get("port") + "!");
		if(configuration().get("port") == null || configuration().get("port").isEmpty()) return;
		io.intino.alexandria.http.AlexandriaSparkBuilder.setup(Integer.parseInt(configuration().get("port")), "www/");
		SetupserviceService.setup(io.intino.alexandria.http.AlexandriaSparkBuilder.instance(), (UnitBox) this);
		io.intino.alexandria.http.AlexandriaSparkBuilder.instance().start();
		Logger.info("Rest service setupservice: started at port " + configuration().get("port") + "!");
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
		setupUi();
		this.initTranslatorService();
		io.intino.alexandria.ui.UISpark sparkInstance = (io.intino.alexandria.ui.UISpark) io.intino.alexandria.http.AlexandriaSparkBuilder.instance();
		sparkInstance.start();
		Logger.info("UI UnitElements: started at port " + configuration().get("port") + "!");
	}

	private void initTranslatorService() {
	    translatorService = new io.intino.alexandria.ui.services.TranslatorService();

	    translatorService.addAll(io.intino.goros.unit.box.I18n.dictionaries());
	    translatorService.addAll(io.intino.alexandria.I18n.dictionaries());
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