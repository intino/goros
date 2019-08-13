package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionOpenNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostOpenNodeAction extends BackServiceAction {
    public String id;
    public String depth;

    public String execute() {
        return executeServiceAction(new ActionOpenNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.NAME, depth);
        return parameters;
    }
}