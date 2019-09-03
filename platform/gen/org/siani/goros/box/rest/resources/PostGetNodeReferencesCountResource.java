package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostGetNodeReferencesCountResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;

	public PostGetNodeReferencesCountResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;

	}

	public void execute() throws Unknown {
		write(fill(new org.siani.goros.box.actions.PostGetNodeReferencesCountAction()).execute());
	}

	private org.siani.goros.box.actions.PostGetNodeReferencesCountAction fill(org.siani.goros.box.actions.PostGetNodeReferencesCountAction action) {
		action.box = this.box;
		action.context = context();
		action.code = manager.fromQuery("code", String.class);
		action.filter = manager.fromQuery("filter", String.class);
		action.parameters = manager.fromQuery("parameters", String.class);
		return action;
	}

	private void write(String object) {
		manager.write(object);
	}

	private io.intino.alexandria.core.Context context() {
		io.intino.alexandria.core.Context context = new io.intino.alexandria.core.Context();
		context.put("domain", manager.domain());
		context.put("baseUrl", manager.baseUrl());
		context.put("requestUrl", manager.baseUrl() + manager.request().pathInfo());
		context.put("realIp", manager.realIp());

		return context;
	}
}