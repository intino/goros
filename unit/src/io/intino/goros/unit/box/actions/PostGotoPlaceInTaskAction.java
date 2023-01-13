package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionGotoPlaceInTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGotoPlaceInTaskAction extends BackServiceAction {
    public UnitBox box;
    public String id;
    public String place;
    public String history;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGotoPlaceInTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.PLACE, place);
        paramMap.put(Parameter.HISTORY, history);
        return paramMap;
    }
}