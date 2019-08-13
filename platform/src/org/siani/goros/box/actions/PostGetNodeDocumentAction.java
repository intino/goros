package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeDocument;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeDocumentAction extends BackServiceAction {
    public String id;

    public io.intino.alexandria.Resource execute() {
        executeServiceAction(new ActionGetNodeDocument());
        return resource();
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        return parameters;
    }
}