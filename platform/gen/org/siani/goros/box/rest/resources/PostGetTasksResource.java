package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostGetTasksResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;
	io.intino.alexandria.rest.security.BasicAuthenticationValidator validator;

	public PostGetTasksResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
		this.validator = box.authenticationValidator();
	}

	public void execute() throws Unauthorized {
		String auth = manager.fromHeader("Authorization", String.class);
		if (auth == null || !validator.validate(auth.replace("Basic ", ""))) throw new Unauthorized("Credential not found");
		write(fill(new org.siani.goros.box.actions.PostGetTasksAction()).execute());
	}

	private org.siani.goros.box.actions.PostGetTasksAction fill(org.siani.goros.box.actions.PostGetTasksAction action) {
		action.box = this.box;
		action.context = context();
		action.inbox = manager.fromQuery("inbox", String.class);
		action.folder = manager.fromQuery("folder", String.class);
		action.condition = manager.fromQuery("condition", String.class);
		action.owner = manager.fromQuery("owner", String.class);
		action.start = manager.fromQuery("start", String.class);
		action.limit = manager.fromQuery("limit", String.class);
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
		context.put("auth", manager.fromHeader("Authorization", String.class).replace("Basic ", ""));
		return context;
	}
}