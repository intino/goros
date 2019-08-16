package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGotoPlaceInTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGotoPlaceInTaskAction extends BackServiceAction {
    public String id;
    public String place;
    public String history;

    public String execute() {
        return executeServiceAction(new ActionGotoPlaceInTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.PLACE, place);
        parameters.put(Parameter.HISTORY, history);
        return parameters;
    }
}