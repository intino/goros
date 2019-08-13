package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetSourceTerms;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetSourceTermsAction extends BackServiceAction {
    public String id;
    public String parent;

    public String execute() {
        return executeServiceAction(new ActionGetSourceTerms());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.PARENT, parent);
        return parameters;
    }
}