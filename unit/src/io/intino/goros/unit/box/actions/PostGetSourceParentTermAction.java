package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionGetSourceParentTerm;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetSourceParentTermAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String code;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetSourceParentTerm());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.CODE, code);
        return paramMap;
    }
}