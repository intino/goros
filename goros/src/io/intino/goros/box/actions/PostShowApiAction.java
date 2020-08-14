package io.intino.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionShowApi;

import java.util.HashMap;
import java.util.Map;


public class PostShowApiAction extends SetupServiceAction {
    public String execute() {
        return executeServiceAction(new ActionShowApi());
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}