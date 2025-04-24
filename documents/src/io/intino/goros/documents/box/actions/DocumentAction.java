package io.intino.goros.documents.box.actions;

import com.google.inject.Injector;
import io.intino.alexandria.Resource;
import io.intino.alexandria.exceptions.BadRequest;
import io.intino.goros.documents.box.services.Response;
import org.monet.docservice.core.log.Logger;
import org.monet.docservice.guice.InjectorFactory;
import org.monet.docservice.servlet.RequestParams;
import org.monet.docservice.servlet.factory.ActionFactory;
import org.monet.docservice.servlet.factory.impl.Action;

import java.util.HashMap;
import java.util.Map;

public class DocumentAction extends io.intino.goros.documents.box.actions.Action {
	public String documentCode;
	public String documentReferenced;
	public String destinationDocumentId;
	public String signature;
	public String signField;
	public Resource templateData;
	public String copiedDocumentCode;
	public String certificate;
	public String templateCode;
	public String mimeType;
	public Resource documentData;
	public String signId;
	public String signFields;
	public String asynchronous;
	public String action;
	public String contentType;
	public String sourceDocumentId;
	public String height;
	public String signReason;
	public String generatePreview;
	public String nodeCode;
	public String signsPosition;
	public String signLocation;
	public String signsCount;
	public String signContact;
	public String width;
	public String signsCountPattern;
	public String documentXmlData;
	public String documentId;
	public String label;
	public String space;

	private Logger logger;
	private ActionFactory actionsFactory;

	public DocumentAction() {
		Injector injector = InjectorFactory.get();
		this.logger = injector.getInstance(Logger.class);
		this.actionsFactory = injector.getInstance(ActionFactory.class);
	}

	public io.intino.alexandria.Resource execute() throws BadRequest {
		try {
			response = new Response(context);
			Map<String, Object> params = parametersToMap();
			String actionName = (String)params.get(RequestParams.REQUEST_PARAM_ACTION);
			this.logger.info("Controller.doProcess(%s)", actionName);
			Action action = this.actionsFactory.create(actionName);
			if (action != null) action.execute(params, response);
			else this.logger.info("Action(%s) not found", actionName);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			throw new BadRequest(e.getMessage());
		}

		return resource();
	}

	private Map<String, Object> parametersToMap() {
		return new HashMap<>() {{
			put("documentCode", documentCode);
			put("documentReferenced", documentReferenced);
			put("destinationDocumentId", destinationDocumentId);
			put("signature", signature);
			put("signField", signField);
			put("templateData", templateData != null ? streamOf(templateData) : null);
			put("copiedDocumentCode", copiedDocumentCode);
			put("certificate", certificate);
			put("templateCode", templateCode);
			put("mimeType", mimeType);
			put("documentData", documentData != null ? streamOf(documentData) : null);
			put("signId", signId);
			put("signFields", signFields);
			put("asynchronous", asynchronous);
			put("action", action);
			put("contentType", contentType);
			put("sourceDocumentId", sourceDocumentId);
			put("height", height);
			put("signReason", signReason);
			put("generatePreview", generatePreview);
			put("nodeCode", nodeCode);
			put("signsPosition", signsPosition);
			put("signLocation", signLocation);
			put("signsCount", signsCount);
			put("signContact", signContact);
			put("width", width);
			put("signsCountPattern", signsCountPattern);
			put("documentXmlData", documentXmlData);
			put("documentId", documentId);
			put("label", label);
			put("space", space);
		}};
	}
}
