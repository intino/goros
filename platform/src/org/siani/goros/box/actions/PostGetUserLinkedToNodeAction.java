package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetUserLinkedToNode;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGetUserLinkedToNodeAction extends Action {
	public String idnode;

	public String execute() {
		return setup(new ActionGetUserLinkedToNode()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID_NODE, idnode);
		return parameters;
	}
}