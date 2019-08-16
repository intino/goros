package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExportNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExportNodeAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionExportNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        return parameters;
    }
}