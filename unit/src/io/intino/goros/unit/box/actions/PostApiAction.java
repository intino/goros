package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionShowApi;

import java.util.*;


public class PostApiAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;

	public java.lang.String execute() {
		return executeServiceAction(new ActionShowApi());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}