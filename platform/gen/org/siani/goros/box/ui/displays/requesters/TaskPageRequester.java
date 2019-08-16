package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.TaskPage;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.TaskPageNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class TaskPageRequester extends PageRequester {

	public TaskPageRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		TaskPage display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}