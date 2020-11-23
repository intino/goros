package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeSchema;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeSchemaAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetNodeSchema());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}