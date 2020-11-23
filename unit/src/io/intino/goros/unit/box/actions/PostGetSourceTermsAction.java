package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionGetSourceTerms;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetSourceTermsAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String parent;

    public java.lang.String execute() {
        return executeServiceAction(new ActionGetSourceTerms());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.PARENT, parent);
        return paramMap;
    }
}