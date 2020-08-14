package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionMakeNodeUnDeleteable;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostMakeNodeUndeletableAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionMakeNodeUnDeleteable());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}