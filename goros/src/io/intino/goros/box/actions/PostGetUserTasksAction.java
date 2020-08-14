package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetUserTasks;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetUserTasksAction extends BackServiceAction {
    public String code;

    public String execute() {
        return executeServiceAction(new ActionGetUserTasks());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        return paramMap;
    }
}