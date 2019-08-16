package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSubscribe;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSubscribeAction extends BackServiceAction {
    public String type;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionSubscribe());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.TYPE, type);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}