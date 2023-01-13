package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionSaveNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeAction extends BackServiceAction {
    public UnitBox box;
    public String id;
    public String data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}