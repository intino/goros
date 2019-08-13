package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSearchEvent;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSearchEventAction extends BackServiceAction {
    public String type;
    public String from;
    public String to;

    public String execute() {
        return executeServiceAction(new ActionSearchEvent());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.TYPE, type);
        parameters.put(Parameter.FROM, from);
        parameters.put(Parameter.TO, to);
        return parameters;
    }
}