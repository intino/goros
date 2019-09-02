package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostSaveNodeDocumentResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;

	public PostSaveNodeDocumentResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;

	}

	public void execute() throws Unknown {
		write(fill(new org.siani.goros.box.actions.PostSaveNodeDocumentAction()).execute());
	}

	private org.siani.goros.box.actions.PostSaveNodeDocumentAction fill(org.siani.goros.box.actions.PostSaveNodeDocumentAction action) {
		action.box = this.box;
		action.context = context();
		action.id = manager.fromQuery("id", String.class);
		action.data = manager.fromForm("data", io.intino.alexandria.Resource.class);
		action.contenttype = manager.fromQuery("contenttype", String.class);
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

		return context;
	}
}