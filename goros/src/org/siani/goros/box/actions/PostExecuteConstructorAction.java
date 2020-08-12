package org.siani.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionExecuteConstructor;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostExecuteConstructorAction extends SetupServiceAction {
	public String execute() {
		return executeServiceAction(new ActionExecuteConstructor());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}