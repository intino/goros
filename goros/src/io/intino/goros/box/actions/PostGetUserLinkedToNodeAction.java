package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetUserLinkedToNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetUserLinkedToNodeAction extends BackServiceAction {
    public String idnode;

    public String execute() {
        return executeServiceAction(new ActionGetUserLinkedToNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID_NODE, idnode);
        return paramMap;
    }
}