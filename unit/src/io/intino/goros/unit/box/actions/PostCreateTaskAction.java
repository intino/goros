package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionCreateTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostCreateTaskAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String type;

    public java.lang.String execute() {
        return executeServiceAction(new ActionCreateTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.TYPE, type);
        return paramMap;
    }
}