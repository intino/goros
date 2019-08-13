package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeDocument;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeDocumentAction extends BackServiceAction {
    public String id;
    public String data;
    public String contenttype;

    public String execute() {
        return executeServiceAction(new ActionSaveNodeDocument());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.DATA, data);
        parameters.put(Parameter.CONTENT_TYPE, data);
        return parameters;
    }
}