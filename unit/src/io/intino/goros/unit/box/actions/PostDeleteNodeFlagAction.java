package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionDeleteNodeFlag;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostDeleteNodeFlagAction extends BackServiceAction {
    public UnitBox box;
    public String id;
    public String name;

    public java.lang.String execute() {
        return executeServiceAction(new ActionDeleteNodeFlag());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.NAME, name);
        return paramMap;
    }
}