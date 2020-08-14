package io.intino.goros.box.actions;

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
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.TYPE, type);
        paramMap.put(Parameter.FROM, from);
        paramMap.put(Parameter.TO, to);
        return paramMap;
    }
}