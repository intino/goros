package org.siani.goros.box.actions;

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
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.NAME, name);
        parameters.put(Parameter.CUBE, cube);
        parameters.put(Parameter.DATA, data);
        return parameters;
    }
}