package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionOpenDatastore;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostOpenDatastoreAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String name;

    public java.lang.String execute() {
        return executeServiceAction(new ActionOpenDatastore());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.NAME, name);
        return paramMap;
    }
}