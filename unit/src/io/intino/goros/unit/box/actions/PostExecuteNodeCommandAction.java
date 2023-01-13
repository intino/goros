package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionExecuteNodeCommand;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExecuteNodeCommandAction extends BackServiceAction {
    public UnitBox box;
    public String idnode;
    public String command;

    public java.lang.String execute() {
        return executeServiceAction(new ActionExecuteNodeCommand());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID_NODE, idnode);
        paramMap.put(Parameter.COMMAND, command);
        return paramMap;
    }
}