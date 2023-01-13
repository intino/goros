package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionSaveUser;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveUserAction extends BackServiceAction {
    public UnitBox box;
    public String code;
    public String data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveUser());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}