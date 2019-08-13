package org.siani.goros.box.actions;

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
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.CODE, code);
        return parameters;
    }
}