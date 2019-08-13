package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetUserNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetUserNodeAction extends BackServiceAction {
    public String code;
    public String depth;

    public String execute() {
        return executeServiceAction(new ActionGetUserNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.CODE, code);
        parameters.put(Parameter.DEPTH, depth);
        return parameters;
    }
}