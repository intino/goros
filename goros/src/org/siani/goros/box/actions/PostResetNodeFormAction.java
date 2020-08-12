package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionResetNodeForm;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostResetNodeFormAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionResetNodeForm());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}