package org.siani.goros.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import org.siani.goros.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.Resource;
import io.intino.alexandria.rest.spark.SparkManager;
import io.intino.alexandria.rest.spark.SparkPushService;



public class PostImportNodeResource implements Resource {

	private GorosBox box;
	private SparkManager<SparkPushService> manager;

	public PostImportNodeResource(GorosBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;

	}

	public void execute() throws Unknown {
		write(fill(new org.siani.goros.box.actions.PostImportNodeAction()).execute());
	}

	private org.siani.goros.box.actions.PostImportNodeAction fill(org.siani.goros.box.actions.PostImportNodeAction action) {
		action.box = this.box;
		action.context = context();
		action.importer = manager.fromQuery("importer", String.class);
		action.idscope = manager.fromQuery("idscope", String.class);
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