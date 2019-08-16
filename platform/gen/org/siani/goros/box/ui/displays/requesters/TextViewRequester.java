package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.TextView;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.TextViewNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class TextViewRequester extends FieldViewRequester {

	public TextViewRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		TextView display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}