package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionSaveNodesAttribute;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodesAttributeAction extends BackServiceAction {
    public UnitBox box;
    public String nodes;
    public String data;

    public java.lang.String execute() {
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