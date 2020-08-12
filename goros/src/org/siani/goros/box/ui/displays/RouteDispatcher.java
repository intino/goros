package org.siani.goros.box.ui.displays;

import io.intino.alexandria.ui.Soul;
import org.siani.goros.box.ui.displays.templates.GorosAppTemplate;

public class RouteDispatcher extends AbstractRouteDispatcher {
	@Override
	public void dispatchHome(Soul soul) {
	}

	@Override
	public void dispatchRoles(Soul soul) {
		soul.display(GorosAppTemplate.class).openRoles();
	}
}