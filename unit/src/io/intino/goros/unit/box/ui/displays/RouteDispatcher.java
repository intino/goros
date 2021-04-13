package io.intino.goros.unit.box.ui.displays;

import io.intino.alexandria.ui.Soul;
import io.intino.goros.unit.box.ui.displays.templates.GorosAppTemplate;

public class RouteDispatcher extends AbstractRouteDispatcher {
	@Override
	public void dispatchHome(Soul soul) {
	}

	@Override
	public void dispatchRoles(Soul soul) {
		soul.display(GorosAppTemplate.class).openRoles();
	}

	@Override
	public void dispatchInstall(Soul soul) {
	}
}