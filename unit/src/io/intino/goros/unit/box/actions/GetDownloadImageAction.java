package io.intino.goros.unit.box.actions;

import org.monet.space.fms.control.actions.ActionDownloadImage;
import org.monet.space.fms.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;

public class GetDownloadImageAction extends FmsServiceAction {
	public String id;
	public String nodeId;
	public String filename;
	public String thumbnail;

	public io.intino.alexandria.Resource execute() {
		executeServiceAction(new ActionDownloadImage());
		return resource();
	}

	@Override
	Map<String, Object> parameters() {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.ID_NODE, nodeId);
		parameters.put(Parameter.FILENAME, filename);
		parameters.put(Parameter.THUMB, thumbnail);
		return parameters;
	}

}