package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.Header;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.HeaderNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class HeaderRequester extends io.intino.alexandria.ui.displays.requesters.TemplateRequester {

	public HeaderRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		Header display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}