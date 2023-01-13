package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionAddDatastoreCubeFacts;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddDatastoreCubeFactsAction extends BackServiceAction {
    public UnitBox box;
    public String name;
    public String cube;
    public String data;

    public java.lang.String execute() {
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