package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodesAttribute;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSaveNodesAttributeAction extends Action {
	public String nodes;
	public String data;

	public String execute() {
		return setup(new ActionSaveNodesAttribute()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.NODES, nodes);
		parameters.put(Parameter.DATA, data);
		return parameters;
	}
}