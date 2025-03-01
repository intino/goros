package io.intino.goros.documents.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.documents.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class PostPreviewDocumentResource implements Resource {

	private DocumentsBox box;
	private SparkManager<SparkPushService> manager;

	public PostPreviewDocumentResource(DocumentsBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.documents.box.actions.PostPreviewDocumentAction()).execute());
	}

	private io.intino.goros.documents.box.actions.PostPreviewDocumentAction fill(io.intino.goros.documents.box.actions.PostPreviewDocumentAction action) {
		action.box = this.box;
		action.context = context();
		action.space = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("space"), String.class);
		action.id = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("id"), String.class);
		action.page = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("page"), String.class);
		action.thumb = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("thumb"), String.class);
		return action;
	}

	private void write(io.intino.alexandria.Resource object) {
		manager.write(object);
	}

	private io.intino.alexandria.http.spark.SparkContext context() {
		io.intino.alexandria.http.spark.SparkContext context = new io.intino.alexandria.http.spark.SparkContext(manager);

		context.put("ip", manager.ip());
		return context;
	}
}