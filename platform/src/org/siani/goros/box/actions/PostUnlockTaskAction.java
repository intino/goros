package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionUnLockTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostUnlockTaskAction extends BackServiceAction {
    public String id;
    public String place;
    public String stop;

    public String execute() {
        return executeServiceAction(new ActionUnLockTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.PLACE, place);
        parameters.put(Parameter.STOP, stop);
        return parameters;
    }
}