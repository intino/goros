package io.intino.goros.box.ui.pages;

import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;
import io.intino.goros.box.ui.displays.templates.*;

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