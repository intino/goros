package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionGetUserTasks;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetUserTasksAction extends BackServiceAction {
    public UnitBox box;
    public String code;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetUserTasks());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        return paramMap;
    }
}