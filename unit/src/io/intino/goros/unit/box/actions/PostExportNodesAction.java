package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionExportNodes;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExportNodesAction extends BackServiceAction {
    public UnitBox box;
    public String ids;

    public java.lang.String execute() {
        return executeServiceAction(new ActionExportNodes());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.IDS, ids);
        return paramMap;
    }
}