package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionAddDatastoreCubeFact;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddDatastoreCubeFactAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String name;
    public String cube;
    public String data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionAddDatastoreCubeFact());
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