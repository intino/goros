package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionOpenTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostOpenTaskAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;

    public java.lang.String execute() {
        return executeServiceAction(new ActionOpenTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}