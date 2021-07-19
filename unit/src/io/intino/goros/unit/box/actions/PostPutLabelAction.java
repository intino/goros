package io.intino.goros.unit.box.actions;

import org.monet.space.setupservice.control.actions.ActionPutLabel;
import org.monet.space.setupservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostPutLabelAction extends SetupServiceAction {
	public String label;

    public java.lang.String execute() {
        return executeServiceAction(new ActionPutLabel());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.LABEL, label);
        return paramMap;
    }
}