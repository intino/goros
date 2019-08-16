package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.CollectionView;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import org.siani.goros.box.ui.displays.notifiers.CollectionViewNotifier;
import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.ui.displays.notifiers.DisplayNotifierProvider;
import io.intino.alexandria.ui.spark.UISparkManager;

public class CollectionViewRequester extends NodeViewRequester {

	public CollectionViewRequester(UISparkManager manager, DisplayNotifierProvider notifierProvider) {
		super(manager, notifierProvider);
	}

	@Override
	public void execute() throws AlexandriaException {
		CollectionView display = display();
		if (display == null) return;
		String operation = operation();

		super.execute();
	}
}