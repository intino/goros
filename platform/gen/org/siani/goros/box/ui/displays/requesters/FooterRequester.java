package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.Footer;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.FooterNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class FooterRequester extends io.intino.alexandria.ui.displays.requesters.TemplateRequester {

	public FooterRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		Footer display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}