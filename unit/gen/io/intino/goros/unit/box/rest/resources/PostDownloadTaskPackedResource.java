package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostDownloadTaskPackedResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostDownloadTaskPackedResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostDownloadTaskPackedAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostDownloadTaskPackedAction fill(io.intino.goros.unit.box.actions.PostDownloadTaskPackedAction action) {
		action.box = this.box;
		action.context = context();
		action.request = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("request"), String.class);
		return action;
	}

	private void write(io.intino.alexandria.Resource object) {
		manager.write(object);
	}

	private io.intino.alexandria.http.spark.SparkContext context() {
		io.intino.alexandria.http.spark.SparkContext context = new io.intino.alexandria.http.spark.SparkContext(manager);

		return context;
	}
}