package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionGetVersion;

import java.util.*;


public class PostGetMajorVersionAction extends SetupServiceAction {

	public java.lang.String execute() {
		return executeServiceAction(new ActionGetVersion());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}