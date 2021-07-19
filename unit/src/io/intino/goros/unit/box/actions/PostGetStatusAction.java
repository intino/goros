package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionGetStatus;

import java.util.*;


public class PostGetStatusAction extends SetupServiceAction {

	public java.lang.String execute() {
		return executeServiceAction(new ActionGetStatus());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}