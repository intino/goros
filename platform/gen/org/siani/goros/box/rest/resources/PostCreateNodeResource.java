package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostCreateNodeResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;

	public PostCreateNodeResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;

	}

	public void execute() throws Unknown {
		write(fill(new org.siani.goros.box.actions.PostCreateNodeAction()).execute());
	}

	private org.siani.goros.box.actions.PostCreateNodeAction fill(org.siani.goros.box.actions.PostCreateNodeAction action) {
		action.box = this.box;
		action.context = context();
		action.parent = manager.fromQuery("parent", String.class);
		action.type = manager.fromQuery("type", String.class);
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