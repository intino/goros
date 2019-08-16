package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.TaskView;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.TaskViewNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class TaskViewRequester extends ViewRequester {

	public TaskViewRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		TaskView display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}