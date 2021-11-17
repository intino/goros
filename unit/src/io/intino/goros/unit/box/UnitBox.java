package io.intino.goros.unit.box;

import io.intino.alexandria.ui.services.AuthService;
import io.intino.alexandria.ui.services.push.UISession;
import io.intino.goros.unit.box.listeners.GorosUnitNotifier;
import io.intino.goros.unit.box.listeners.ListenerGoros;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.space.kernel.agents.AgentNotifier;
import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.Context;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import static java.util.stream.Collectors.toMap;

public class UnitBox extends AbstractBox {
	private GorosUnitNotifier notifier;

	public UnitBox(String[] args) {
		super(args);
	}

	public UnitBox(UnitConfiguration configuration) {
		super(configuration);
	}

	public GorosUnitNotifier notifier() {
		return notifier;
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	@Override
	public void beforeStart() {
		this.notifier = new GorosUnitNotifier();
		listenMonet();
	}

	@Override
	public void afterStart() {
		pushService().onLinkToThread((client, session) -> linkSession(session));
		GorosUnit.open(normalize(configuration.args()));
	}

	@Override
	public void beforeStop() {
	}

	@Override
	public void afterStop() {
	}

	public void initSession(UISession session) {
		Context.getInstance().setApplication(Thread.currentThread().getId(), hostOf(session.browser().homeUrl()), configuration.name(), "UI");
		Context.getInstance().setUserServerConfig(Thread.currentThread().getId(), hostOf(session.browser().baseUrl()), session.browser().basePath(), Integer.parseInt(configuration.port()));
		AgentSession.getInstance().add(session.id());
		linkSession(session);
		if (session.token() == null) return;
		org.scribe.model.Token token = new org.scribe.model.Token(session.token().id(), session.token().secret());
		LayerHelper.federationLayer(session).injectAccessToken(token);
	}

	public void linkSession(UISession session) {
		Context.getInstance().setSessionId(Thread.currentThread().getId(), session.id());
	}

	public BusinessUnit businessUnit() {
		return BusinessUnit.getInstance();
	}

	@Override
	protected AuthService authService(URL authServiceUrl) {
		return new GorosOAuthAccessor(this);
	}

	public io.intino.alexandria.http.security.BasicAuthenticationValidator authenticationValidator() {
		return token -> false;
	}

	public boolean isInstalled() {
		return GorosUnit.isInstalled(normalize(configuration.args()));
	}

	private void listenMonet() {
		AgentNotifier.getInstance().register("Goros", ListenerGoros.class);
		ListenerGoros listener = (ListenerGoros) AgentNotifier.getInstance().get("Goros");
		listener.inject(notifier);
	}

	private Map<String, String> normalize(Map<String, String> parameters) {
		return parameters.entrySet().stream().collect(toMap(e -> normalizeParameterName(e.getKey()), Map.Entry::getValue));
	}

	private String normalizeParameterName(String key) {
		if (key.equals("jdbc-datasource")) return "Jdbc.DataSource";
		if (key.equals("jdbc-type")) return "Jdbc.Type";
		if (key.equals("jdbc-max-active-connections")) return "Jdbc.MaxActiveConnections";
		if (key.equals("jdbc-max-idle-connections")) return "Jdbc.MaxIdleConnections";
		if (key.equals("jdbc-remove-abandoned-timeout")) return "Jdbc.RemoveAbandonedTimeout";
		if (key.equals("jdbc-url")) return "Jdbc.Url";
		if (key.equals("jdbc-user")) return "Jdbc.User";
		if (key.equals("jdbc-password")) return "Jdbc.Password";
		return "MONET_" + key.toUpperCase().replace("-", "_");
	}

	private String hostOf(String url) {
		try {
			return new URL(url).getHost();
		} catch (MalformedURLException e) {
			return null;
		}
	}

}