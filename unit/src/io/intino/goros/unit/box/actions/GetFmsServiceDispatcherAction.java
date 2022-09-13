package io.intino.goros.unit.box.actions;

import java.util.Collections;
import java.util.Map;

public class GetFmsServiceDispatcherAction extends FmsServiceAction {
	public String op;
	public String thumb;
	public String f;
	public String nid;
	public String id;

	public io.intino.alexandria.Resource execute() {
		if (op.equalsIgnoreCase("downloadimage")) {
			GetDownloadImageAction action = new GetDownloadImageAction();
			action.box = box;
			action.context = context;
			action.id = id;
			action.nodeId = nid;
			action.filename = f;
			action.thumbnail = thumb;
			return action.execute();
		}
		else if (op.equalsIgnoreCase("downloaddocument")) {
			GetDownloadDocumentAction action = new GetDownloadDocumentAction();
			action.box = box;
			action.context = context;
			action.id = id;
			action.nodeId = nid;
			action.filename = f;
			return action.execute();
		}
		return null;
	}

	@Override
	Map<String, Object> parameters() {
		return Collections.emptyMap();
	}
}