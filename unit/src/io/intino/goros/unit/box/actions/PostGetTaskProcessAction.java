package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionGetTaskProcess;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetTaskProcessAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetTaskProcess());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}