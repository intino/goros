package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSearchNodes;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSearchNodesAction extends BackServiceAction {
    public String id;
    public String from;
    public String to;

    public String execute() {
        return executeServiceAction(new ActionSearchNodes());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.FROM, from);
        parameters.put(Parameter.TO, to);
        return parameters;
    }
}