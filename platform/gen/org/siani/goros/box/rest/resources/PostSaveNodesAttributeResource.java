package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostSaveNodesAttributeResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;

	public PostSaveNodesAttributeResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;

	}

	public void execute() throws Unknown {
		write(fill(new org.siani.goros.box.actions.PostSaveNodesAttributeAction()).execute());
	}

	private org.siani.goros.box.actions.PostSaveNodesAttributeAction fill(org.siani.goros.box.actions.PostSaveNodesAttributeAction action) {
		action.box = this.box;
		action.context = context();
		action.nodes = manager.fromQuery("nodes", String.class);
		action.data = manager.fromQuery("data", String.class);
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