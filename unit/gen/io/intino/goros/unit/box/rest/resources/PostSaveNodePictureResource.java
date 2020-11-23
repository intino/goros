package io.intino.goros.unit.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.unit.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostSaveNodePictureResource implements Resource {

	private UnitBox box;
	private SparkManager<SparkPushService> manager;

	public PostSaveNodePictureResource(UnitBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.unit.box.actions.PostSaveNodePictureAction()).execute());
	}

	private io.intino.goros.unit.box.actions.PostSaveNodePictureAction fill(io.intino.goros.unit.box.actions.PostSaveNodePictureAction action) {
		action.box = this.box;
		action.context = context();
		action.name = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("name"), String.class);
		action.data = manager.fromForm("data");
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