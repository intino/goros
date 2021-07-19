package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionExecuteConstructor;

import java.util.*;


public class PostExecuteConstructorAction extends SetupServiceAction {

	public java.lang.String execute() {
		return executeServiceAction(new ActionExecuteConstructor());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}