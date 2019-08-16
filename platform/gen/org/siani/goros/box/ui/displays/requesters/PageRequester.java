package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.Page;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.PageNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class PageRequester extends io.intino.alexandria.ui.displays.requesters.TemplateRequester {

	public PageRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		Page display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}