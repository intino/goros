package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionImportNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostImportNodeAction extends BackServiceAction {
    public String importer;
    public String idscope;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionImportNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.IMPORTER, importer);
        parameters.put(Parameter.ID_SCOPE, idscope);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}