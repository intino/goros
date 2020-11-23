package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostExecuteExporterResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostExecuteExporterResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostExecuteExporterAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostExecuteExporterAction fill(io.intino.goros.unit.box.actions.PostExecuteExporterAction action) {
		action.box = this.box;
		action.context = context();
		action.exporter = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("exporter"), String.class);
		action.scope = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("scope"), String.class);
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