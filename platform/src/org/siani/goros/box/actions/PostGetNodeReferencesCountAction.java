package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeReferencesCount;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeReferencesCountAction extends BackServiceAction {
    public String code;
    public String filter;
    public String parameters;

    public String execute() {
        return executeServiceAction(new ActionGetNodeReferencesCount());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.CODE, code);
        parameters.put(Parameter.FILTER, filter);
        parameters.put(Parameter.PARAMETERS, parameters);
        return parameters;
    }
}