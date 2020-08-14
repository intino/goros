package io.intino.goros.box;

import io.intino.alexandria.ui.services.AuthService;
import org.monet.space.kernel.agents.AgentNotifier;
import org.monet.space.kernel.listeners.IListenerMonetEvent;
import io.intino.goros.box.listeners.GorosNotifier;
import io.intino.goros.box.listeners.ListenerGoros;
import io.intino.goros.graph.BusinessUnit;

import java.net.URL;

public class GorosBox extends AbstractBox {
	private GorosNotifier notifier;

	public GorosBox(String[] args) {
		super(args);
	}

	public GorosBox(GorosConfiguration configuration) {
		super(configuration);
	}

	public GorosNotifier notifier() {
		return notifier;
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	@Override
	public void beforeStart() {
		this.notifier = new GorosNotifier();
		listenMonet();
	}

	@Override
	public void afterStart() {

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

	public GorosBox open(BusinessUnit unit) {
		Goros.open(unit);
		return this;
	}

	public io.intino.alexandria.http.security.BasicAuthenticationValidator authenticationValidator() {
		return token -> false;
	}

	private void listenMonet() {
		AgentNotifier.getInstance().register("Goros", ListenerGoros.class);
		ListenerGoros listener = (ListenerGoros) AgentNotifier.getInstance().get("Goros");
		listener.inject(notifier);
	}

}