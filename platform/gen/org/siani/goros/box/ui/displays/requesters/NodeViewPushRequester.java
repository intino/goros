package org.siani.goros.box.ui.displays.requesters;

import org.siani.goros.box.ui.displays.templates.NodeView;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;


import io.intino.alexandria.exceptions.AlexandriaException;
import io.intino.alexandria.rest.spark.SparkReader;
import io.intino.alexandria.ui.services.push.UIClient;
import io.intino.alexandria.ui.services.push.UIMessage;
import io.intino.alexandria.ui.spark.UISparkManager;

public class NodeViewPushRequester extends io.intino.alexandria.ui.displays.requesters.TemplatePushRequester {

	public void execute(UIClient client, UIMessage message) {
		NodeView display = display(client, message);
		if (display == null) return;
		String operation = operation(message);
		String data = data(message);

		super.execute(client, message);
	}

}