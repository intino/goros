package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionGetUserLinkedToNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetUserLinkedToNodeAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String idnode;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetUserLinkedToNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID_NODE, idnode);
        return paramMap;
    }
}