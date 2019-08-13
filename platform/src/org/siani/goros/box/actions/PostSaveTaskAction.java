package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveTaskAction extends BackServiceAction {
    public String id;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionSaveTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}