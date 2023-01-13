package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionSaveNodeFile;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeFileAction extends BackServiceAction {
    public UnitBox box;
    public String name;
    public io.intino.alexandria.Resource data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveNodeFile());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.NAME, name);
        paramMap.put(Parameter.DATA, data.stream());
        return paramMap;
    }
}