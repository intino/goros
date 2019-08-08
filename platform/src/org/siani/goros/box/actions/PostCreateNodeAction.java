package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionCreateNode;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostCreateNodeAction  extends Action {
	public String parent;
	public String type;

	public String execute() {
		return setup(new ActionCreateNode()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.PARENT, parent);
		parameters.put(Parameter.TYPE, type);
		return parameters;
	}
}