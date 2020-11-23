package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostBusinessResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostBusinessResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostBusinessAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostBusinessAction fill(io.intino.goros.unit.box.actions.PostBusinessAction action) {
		action.box = this.box;
		action.context = context();
		action.serviceName = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromPath("service-name"), String.class);
		action.sourceUnit = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("source-unit"), String.class);
		action.replyMailbox = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("reply-mailbox"), String.class);
		action.startDate = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("start-date"), String.class);
		action.endDate = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("end-date"), String.class);
		action.comments = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("comments"), String.class);
		action.urgent = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("urgent"), String.class);
		return action;
	}

	private void write(String object) {
		manager.write(io.intino.alexandria.rest.ResponseAdapter.adapt(object));
	}

	private io.intino.alexandria.http.spark.SparkContext context() {
		io.intino.alexandria.http.spark.SparkContext context = new io.intino.alexandria.http.spark.SparkContext(manager);

		return context;
	}
}