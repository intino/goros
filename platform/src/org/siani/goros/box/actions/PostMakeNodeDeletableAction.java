package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionMakeNodeDeleteable;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostMakeNodeDeletableAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionMakeNodeDeleteable());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}