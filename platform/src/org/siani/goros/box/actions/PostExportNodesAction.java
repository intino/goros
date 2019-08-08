package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExportNodes;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostExportNodesAction extends Action {
	public String ids;

	public String execute() {
		return setup(new ActionExportNodes()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.IDS, ids);
		return parameters;
	}
}