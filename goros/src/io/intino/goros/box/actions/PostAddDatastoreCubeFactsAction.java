package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddDatastoreCubeFacts;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddDatastoreCubeFactsAction extends BackServiceAction {
    public String name;
    public String cube;
    public String data;

    public String execute() {
        return executeServiceAction(new ActionAddDatastoreCubeFacts());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.NAME, name);
        paramMap.put(Parameter.CUBE, cube);
        paramMap.put(Parameter.DATA, data);
        return paramMap;
    }
}