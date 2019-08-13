package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionShowApi;

import java.util.HashMap;
import java.util.Map;


public class PostShowApiAction extends BackServiceAction {
    public String execute() {
        return executeServiceAction(new ActionShowApi());
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}