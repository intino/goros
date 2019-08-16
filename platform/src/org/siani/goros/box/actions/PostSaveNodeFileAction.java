package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeFile;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeFileAction extends BackServiceAction {
    public String name;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionSaveNodeFile());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.NAME, name);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}