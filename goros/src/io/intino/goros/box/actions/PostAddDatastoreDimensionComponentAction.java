package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddDatastoreDimensionComponent;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddDatastoreDimensionComponentAction extends BackServiceAction {
    public String name;
    public String dimension;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionAddDatastoreDimensionComponent());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.NAME, name);
        paramMap.put(Parameter.DIMENSION, dimension);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}