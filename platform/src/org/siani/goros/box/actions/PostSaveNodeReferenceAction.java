package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeReference;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeReferenceAction extends BackServiceAction {
    public String id;
    public String code;
    public String attributes;

    public String execute() {
        return executeServiceAction(new ActionSaveNodeReference());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.CODE, code);
        parameters.put(Parameter.ATTRIBUTES, attributes);
        return parameters;
    }
}