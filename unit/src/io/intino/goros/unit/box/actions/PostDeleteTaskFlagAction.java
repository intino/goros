package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionDeleteTaskFlag;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostDeleteTaskFlagAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String name;

    public java.lang.String execute() {
        return executeServiceAction(new ActionDeleteTaskFlag());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.NAME, name);
        return paramMap;
    }
}