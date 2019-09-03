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

	public io.intino.alexandria.core.Box open(BusinessUnit unit) {
		Box result = super.open();
		Goros.start(unit);
		return result;
	}

	public void close() {
		super.close();
	}

	@Override
	protected AuthService authService(URL authServiceUrl) {
		return null;
	}

	public io.intino.alexandria.rest.security.BasicAuthenticationValidator authenticationValidator() {
		return token -> false;
	}
}