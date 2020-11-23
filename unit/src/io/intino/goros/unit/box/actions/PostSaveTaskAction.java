package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveTaskAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}