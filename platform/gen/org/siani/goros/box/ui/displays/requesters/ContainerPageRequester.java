package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.ContainerPage;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.ContainerPageNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class ContainerPageRequester extends NodePageRequester {

	public ContainerPageRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		ContainerPage display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}