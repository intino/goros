package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetTasks;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGetTasksAction extends Action {
	public String inbox;
	public String folder;
	public String condition;
	public String owner;
	public String start;
	public String limit;

	public String execute() {
		return setup(new ActionGetTasks()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.INBOX, inbox);
		parameters.put(Parameter.FOLDER, folder);
		parameters.put(Parameter.CONDITION, condition);
		parameters.put(Parameter.OWNER, owner);
		parameters.put(Parameter.START, start);
		parameters.put(Parameter.LIMIT, limit);
		return parameters;
	}
}