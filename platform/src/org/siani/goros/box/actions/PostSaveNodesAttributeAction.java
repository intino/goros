package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodesAttribute;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodesAttributeAction extends BackServiceAction {
    public String nodes;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionSaveNodesAttribute());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.NODES, nodes);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}