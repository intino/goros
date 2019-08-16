package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.FormPage;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.FormPageNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class FormPageRequester extends NodePageRequester {

	public FormPageRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		FormPage display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}