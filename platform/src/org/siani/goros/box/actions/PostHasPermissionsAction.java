package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionHasPermissions;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostHasPermissionsAction extends BackServiceAction {
    public String username;

    public String execute() {
        return executeServiceAction(new ActionHasPermissions());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.USERNAME, username);
        return parameters;
    }
}