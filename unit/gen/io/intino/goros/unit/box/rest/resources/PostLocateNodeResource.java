package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostLocateNodeResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostLocateNodeResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostLocateNodeAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostLocateNodeAction fill(io.intino.goros.unit.box.actions.PostLocateNodeAction action) {
		action.box = this.box;
		action.context = context();
		action.code = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("code"), String.class);
		action.depth = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("depth"), String.class);
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