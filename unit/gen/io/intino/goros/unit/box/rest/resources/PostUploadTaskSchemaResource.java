package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostUploadTaskSchemaResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostUploadTaskSchemaResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostUploadTaskSchemaAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostUploadTaskSchemaAction fill(io.intino.goros.unit.box.actions.PostUploadTaskSchemaAction action) {
		action.box = this.box;
		action.context = context();
		action.request = new io.intino.alexandria.Resource("request", manager.fromBodyAsBytes());
		action.id = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("id"), String.class);
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