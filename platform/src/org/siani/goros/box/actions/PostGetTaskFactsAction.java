package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetTaskFacts;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGetTaskFactsAction extends Action {
	public String id;

	public String execute() {
		return setup(new ActionGetTaskFacts()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		return parameters;
	}
}