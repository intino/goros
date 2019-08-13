package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeReference;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeReferenceAction extends BackServiceAction {
    public String id;
    public String name;

    public String execute() {
        return executeServiceAction(new ActionGetNodeReference());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.NAME, name);
        return parameters;
    }
}