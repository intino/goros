package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostAddDatastoreCubeFactsResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;

	public PostAddDatastoreCubeFactsResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;

	}

	public void execute() throws Unknown {
		write(fill(new org.siani.goros.box.actions.PostAddDatastoreCubeFactsAction()).execute());
	}

	private org.siani.goros.box.actions.PostAddDatastoreCubeFactsAction fill(org.siani.goros.box.actions.PostAddDatastoreCubeFactsAction action) {
		action.box = this.box;
		action.context = context();
		action.name = manager.fromQuery("name", String.class);
		action.cube = manager.fromQuery("cube", String.class);
		action.data = manager.fromQuery("data", String.class);
		return action;
	}

	private void write(String object) {
		manager.write(object);
	}

	private io.intino.alexandria.rest.spark.SparkContext context() {
		io.intino.alexandria.rest.spark.SparkContext context = new io.intino.alexandria.rest.spark.SparkContext();

		return context;
	}
}