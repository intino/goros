package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExistsNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExistsNodeAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionExistsNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}