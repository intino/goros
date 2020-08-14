package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveTask;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveTaskAction extends BackServiceAction {
    public String id;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionSaveTask());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}