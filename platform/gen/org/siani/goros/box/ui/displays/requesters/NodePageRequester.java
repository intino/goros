package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.NodePage;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.NodePageNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class NodePageRequester extends PageRequester {

	public NodePageRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		NodePage display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}