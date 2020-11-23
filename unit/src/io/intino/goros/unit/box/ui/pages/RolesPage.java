package io.intino.goros.unit.box.ui.pages;

import io.intino.goros.unit.box.ui.displays.templates.GorosAppTemplate;

public class RolesPage extends AbstractRolesPage {

	public io.intino.alexandria.ui.Soul prepareSoul(io.intino.alexandria.ui.services.push.UIClient client) {
	    return new io.intino.alexandria.ui.Soul(session) {
			@Override
			public void personify() {
				GorosAppTemplate component = new GorosAppTemplate(box);
				register(component);
				component.init();
			}
		};
	}
}