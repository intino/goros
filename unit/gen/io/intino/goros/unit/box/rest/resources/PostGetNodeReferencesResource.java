package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostGetNodeReferencesResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostGetNodeReferencesResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostGetNodeReferencesAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostGetNodeReferencesAction fill(io.intino.goros.unit.box.actions.PostGetNodeReferencesAction action) {
		action.box = this.box;
		action.context = context();
		action.code = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("code"), String.class);
		action.filter = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("filter"), String.class);
		action.orderby = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("orderby"), String.class);
		action.parameters = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("parameters"), String.class);
		action.start = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("start"), String.class);
		action.limit = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("limit"), String.class);
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