package io.intino.goros.unit.box;

import io.intino.alexandria.ui.services.AuthService;
import io.intino.goros.unit.box.listeners.GorosUnitNotifier;
import io.intino.goros.unit.box.listeners.ListenerGoros;
import org.monet.space.kernel.agents.AgentNotifier;

import java.net.URL;
import java.util.Map;

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
		GorosUnit.open(normalize(configuration.args()));
	}

	@Override
	public void beforeStop() {

	}

	@Override
	public void afterStop() {

	}

	@Override
	protected AuthService authService(URL authServiceUrl) {
		return null;
	}

	public io.intino.alexandria.http.security.BasicAuthenticationValidator authenticationValidator() {
		return token -> false;
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
		if (key.equals("jdbc-url")) return "Jdbc.Url";
		if (key.equals("jdbc-user")) return "Jdbc.User";
		if (key.equals("jdbc-password")) return "Jdbc.Password";
		return "MONET_" + key.toUpperCase().replace("-", "_");
	}

}