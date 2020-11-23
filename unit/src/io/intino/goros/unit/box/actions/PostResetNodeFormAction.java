package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionResetNodeForm;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostResetNodeFormAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;

    public java.lang.String execute() {
        return executeServiceAction(new ActionResetNodeForm());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}