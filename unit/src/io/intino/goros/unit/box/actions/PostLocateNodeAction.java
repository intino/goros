package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionLocateNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostLocateNodeAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String code;
    public String depth;

    public java.lang.String execute() {
        return executeServiceAction(new ActionLocateNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        if(depth != null) paramMap.put(Parameter.DEPTH, depth);
        return paramMap;
    }
}