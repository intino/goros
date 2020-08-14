package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionMakeNodeEditable;
import org.monet.space.backservice.control.actions.ActionMakeNodePrivate;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostMakeNodePrivateAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionMakeNodePrivate());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}