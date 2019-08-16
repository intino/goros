package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.DesktopView;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.DesktopViewNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class DesktopViewRequester extends NodeViewRequester {

	public DesktopViewRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		DesktopView display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}