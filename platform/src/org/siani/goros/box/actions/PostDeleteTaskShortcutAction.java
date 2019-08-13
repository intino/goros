package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionDeleteTaskShortCut;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostDeleteTaskShortcutAction extends BackServiceAction {
    public String id;
    public String name;

    public String execute() {
        return executeServiceAction(new ActionDeleteTaskShortCut());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.NAME, name);
        return parameters;
    }
}