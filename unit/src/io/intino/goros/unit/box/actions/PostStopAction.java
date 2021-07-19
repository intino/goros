package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionStop;

import java.util.*;


public class PostStopAction extends SetupServiceAction {

	public java.lang.String execute() {
		return executeServiceAction(new ActionStop());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}