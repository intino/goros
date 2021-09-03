package io.intino.goros.documents.box.rest.resources;

import java.util.List;
import java.util.ArrayList;
import io.intino.alexandria.exceptions.*;
import io.intino.goros.documents.box.*;
import io.intino.alexandria.core.Box;
import io.intino.alexandria.rest.*;
import io.intino.alexandria.http.spark.SparkManager;
import io.intino.alexandria.http.spark.SparkPushService;



public class GetDocumentResource implements Resource {

	private DocumentsBox box;
	private SparkManager<SparkPushService> manager;

	public GetDocumentResource(DocumentsBox box, SparkManager manager) {
		this.box = box;
		this.manager = manager;
	}

	public void execute() throws AlexandriaException {
		write(fill(new io.intino.goros.documents.box.actions.GetDocumentAction()).execute());
	}

	private io.intino.goros.documents.box.actions.GetDocumentAction fill(io.intino.goros.documents.box.actions.GetDocumentAction action) {
		action.box = this.box;
		action.context = context();
		action.action = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("action"), String.class);
		action.templateCode = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("templateCode"), String.class);
		action.templateData = manager.fromForm("templateData");
		action.mimeType = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("mimeType"), String.class);
		action.signFields = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signFields"), String.class);
		action.signsPosition = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signsPosition"), String.class);
		action.signsCount = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signsCount"), String.class);
		action.signsCountPattern = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signsCountPattern"), String.class);
		action.documentCode = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("documentCode"), String.class);
		action.documentData = manager.fromForm("documentData");
		action.contentType = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("contentType"), String.class);
		action.width = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("width"), String.class);
		action.height = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("height"), String.class);
		action.asynchronous = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("asynchronous"), String.class);
		action.nodeCode = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("nodeCode"), String.class);
		action.copiedDocumentCode = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("copiedDocumentCode"), String.class);
		action.generatePreview = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("generatePreview"), String.class);
		action.sourceDocumentId = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("sourceDocumentId"), String.class);
		action.destinationDocumentId = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("destinationDocumentId"), String.class);
		action.documentXmlData = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("documentXmlData"), String.class);
		action.documentId = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("documentId"), String.class);
		action.certificate = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("certificate"), String.class);
		action.signReason = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signReason"), String.class);
		action.signLocation = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signLocation"), String.class);
		action.signContact = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signContact"), String.class);
		action.signField = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signField"), String.class);
		action.signId = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signId"), String.class);
		action.signature = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("signature"), String.class);
		action.label = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("label"), String.class);
		action.space = io.intino.alexandria.rest.RequestAdapter.adapt(manager.fromQuery("space"), String.class);
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