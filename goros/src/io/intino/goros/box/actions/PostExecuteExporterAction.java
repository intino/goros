package io.intino.goros.box.actions;

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
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.EXPORTER, exporter);
        paramMap.put(Parameter.SCOPE, scope);
        return paramMap;
    }
}