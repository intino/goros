package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionUnLockTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostUnlockTaskAction extends BackServiceAction {
    public UnitBox box;
    public String id;
    public String place;
    public String stop;

    public java.lang.String execute() {
        return executeServiceAction(new ActionUnLockTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.PLACE, place);
        paramMap.put(Parameter.STOP, stop);
        return paramMap;
    }
}