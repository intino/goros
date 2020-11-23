package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostSourceResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostSourceResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostSourceAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostSourceAction fill(io.intino.goros.unit.box.actions.PostSourceAction action) {
		action.box = this.box;
		action.context = context();
		action.action = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("action"), String.class);
		action.sourceName = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromPath("source-name"), String.class);
		action.mode = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("mode"), String.class);
		action.flatten = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("flatten"), String.class);
		action.depth = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("depth"), String.class);
		action.from = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("from"), String.class);
		action.filters = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("filters"), String.class);
		action.searchText = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("search-text"), String.class);
		action.startPos = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("start-pos"), String.class);
		action.count = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("count"), String.class);
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