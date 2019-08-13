package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetTaskFlags;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetTaskFlagsAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionGetTaskFlags());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        return parameters;
    }
}