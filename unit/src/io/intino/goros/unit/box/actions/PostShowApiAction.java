package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionShowApi;

import java.util.HashMap;
import java.util.Map;


public class PostShowApiAction extends SetupServiceAction {
	public io.intino.alexandria.core.Box box;

	public java.lang.String execute() {
        return executeServiceAction(new ActionShowApi());
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}