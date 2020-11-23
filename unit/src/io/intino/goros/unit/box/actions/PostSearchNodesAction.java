package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionSearchNodes;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSearchNodesAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String from;
    public String to;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSearchNodes());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.FROM, from);
        paramMap.put(Parameter.TO, to);
        return paramMap;
    }
}