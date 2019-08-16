package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExecuteNodeCommand;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExecuteNodeCommandAction extends BackServiceAction {
    public String idnode;
    public String command;

    public String execute() {
        return executeServiceAction(new ActionExecuteNodeCommand());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID_NODE, idnode);
        parameters.put(Parameter.COMMAND, command);
        return parameters;
    }
}