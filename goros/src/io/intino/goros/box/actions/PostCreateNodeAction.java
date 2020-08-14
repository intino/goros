package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionCreateNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostCreateNodeAction extends BackServiceAction {
    public String parent;
    public String type;

    public String execute() {
        return executeServiceAction(new ActionCreateNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.PARENT, parent);
        paramMap.put(Parameter.TYPE, type);
        return paramMap;
    }
}