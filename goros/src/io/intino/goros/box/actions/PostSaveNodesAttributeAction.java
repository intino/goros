package io.intino.goros.box.actions;

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
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.NODES, nodes);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}