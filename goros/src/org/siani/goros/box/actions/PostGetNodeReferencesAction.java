package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeReferences;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeReferencesAction extends BackServiceAction {
    public String code;
    public String filter;
    public String orderby;
    public String parameters;
    public String start;
    public String limit;

    public String execute() {
        return executeServiceAction(new ActionGetNodeReferences());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        paramMap.put(Parameter.FILTER, filter);
        paramMap.put(Parameter.ORDER_BY, orderby);
        paramMap.put(Parameter.PARAMETERS, parameters);
        paramMap.put(Parameter.START, start);
        paramMap.put(Parameter.LIMIT, limit);
        return paramMap;
    }
}