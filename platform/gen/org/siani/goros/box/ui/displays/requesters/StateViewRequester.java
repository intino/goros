package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.StateView;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.StateViewNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class StateViewRequester extends TaskViewRequester {

	public StateViewRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		StateView display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}