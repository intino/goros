package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetSourceParentTerm;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetSourceParentTermAction extends BackServiceAction {
    public String id;
    public String code;

    public String execute() {
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