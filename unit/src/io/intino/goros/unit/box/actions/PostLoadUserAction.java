package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionLoadUser;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostLoadUserAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String code;

    public java.lang.String execute() {
        return executeServiceAction(new ActionLoadUser());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        return paramMap;
    }
}