package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveTask;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSaveTaskAction extends Action {
	public String id;
	public String data;

	public String execute() {
		return setup(new ActionSaveTask()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.DATA, data);
		return parameters;
	}
}