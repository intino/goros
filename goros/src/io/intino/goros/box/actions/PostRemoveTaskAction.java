package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionRemoveTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostRemoveTaskAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionRemoveTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}