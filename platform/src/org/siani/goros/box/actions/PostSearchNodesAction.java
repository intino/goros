package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSearchNodes;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSearchNodesAction extends Action {
	public String id;
	public String from;
	public String to;

	public String execute() {
		return setup(new ActionSearchNodes()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.FROM, from);
		parameters.put(Parameter.TO, to);
		return parameters;
	}
}