package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeReference;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeReferenceAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String code;
    public String attributes;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveNodeReference());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.CODE, code);
        paramMap.put(Parameter.ATTRIBUTES, attributes);
        return paramMap;
    }
}