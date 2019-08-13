package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddTaskFlag;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddTaskFlagAction extends BackServiceAction {
    public String id;
    public String name;
    public String value;

    public String execute() {
        return executeServiceAction(new ActionAddTaskFlag());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.NAME, name);
        parameters.put(Parameter.VALUE, value);
        return parameters;
    }
}