package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionImportNode;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostImportNodeAction extends BackServiceAction {
    public UnitBox box;
    public String importer;
    public String idscope;
    public String data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionImportNode());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.IMPORTER, importer);
        paramMap.put(Parameter.ID_SCOPE, idscope);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}