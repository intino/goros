package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionExecuteExporter;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostExecuteExporterAction extends BackServiceAction {
    public String exporter;
    public String scope;

    public io.intino.alexandria.Resource execute() {
        executeServiceAction(new ActionExecuteExporter());
        return resource();
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.EXPORTER, exporter);
        parameters.put(Parameter.SCOPE, scope);
        return parameters;
    }
}