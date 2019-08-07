package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExecuteNodeCommand;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostExecuteNodeCommandAction extends Action {
	public String idnode;
	public String command;

	public String execute() {
		return setup(new ActionExecuteNodeCommand()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID_NODE, idnode);
		parameters.put(Parameter.COMMAND, command);
		return parameters;
	}
}