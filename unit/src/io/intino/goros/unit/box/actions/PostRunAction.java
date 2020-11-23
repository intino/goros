package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionRun;

import java.util.*;


public class PostRunAction extends SetupServiceAction {
	public io.intino.alexandria.core.Box box;

	public java.lang.String execute() {
		return executeServiceAction(new ActionRun());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}