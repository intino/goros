package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionCreateTask;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostCreateTaskAction   extends Action {
	public String type;

	public String execute() {
		return setup(new ActionCreateTask()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.TYPE, type);
		return parameters;
	}
}