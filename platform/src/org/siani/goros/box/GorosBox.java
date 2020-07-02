package org.siani.goros.box;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.ui.services.AuthService;
import org.siani.goros.graph.BusinessUnit;

import java.net.URL;

public class GorosBox extends AbstractBox {

	public GorosBox(String[] args) {
		super(args);
	}

	public GorosBox(GorosConfiguration configuration) {
		super(configuration);
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	@Override
	public void beforeStart() {

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

	public io.intino.alexandria.core.Box start(BusinessUnit unit) {
		Box box = super.start();
		Goros.start(unit);
		return box;
	}

	public io.intino.alexandria.http.security.BasicAuthenticationValidator authenticationValidator() {
		return token -> false;
	}
}