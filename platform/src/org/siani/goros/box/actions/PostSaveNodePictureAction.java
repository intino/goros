package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodePicture;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodePictureAction extends BackServiceAction {
    public String name;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionSaveNodePicture());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.NAME, name);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}