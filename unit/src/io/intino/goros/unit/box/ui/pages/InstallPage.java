package io.intino.goros.unit.box.ui.pages;

import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;
import io.intino.goros.unit.box.ui.displays.templates.*;

public class InstallPage extends AbstractInstallPage {

	public io.intino.alexandria.ui.Soul prepareSoul(io.intino.alexandria.ui.services.push.UIClient client) {
	    return new io.intino.alexandria.ui.Soul(session) {
			@Override
			public void personify() {
				GorosInstallTemplate component = new GorosInstallTemplate(box);
				register(component);
				component.init();
			}
		};
	}
}