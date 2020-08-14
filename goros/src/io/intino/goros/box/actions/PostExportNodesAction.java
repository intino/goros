package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExportNodes;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExportNodesAction extends BackServiceAction {
    public String ids;

    public String execute() {
        return executeServiceAction(new ActionExportNodes());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.IDS, ids);
        return paramMap;
    }
}