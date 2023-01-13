package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionGetTaskFlags;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetTaskFlagsAction extends BackServiceAction {
    public UnitBox box;
    public String id;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetTaskFlags());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}