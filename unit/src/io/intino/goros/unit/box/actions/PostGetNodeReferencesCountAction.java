package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeReferencesCount;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeReferencesCountAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String code;
    public String filter;
    public String parameters;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetNodeReferencesCount());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        paramMap.put(Parameter.FILTER, filter);
        paramMap.put(Parameter.PARAMETERS, parameters);
        return paramMap;
    }
}