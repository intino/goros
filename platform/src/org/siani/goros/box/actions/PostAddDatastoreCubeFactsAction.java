package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddDatastoreCubeFacts;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.*;


public class PostAddDatastoreCubeFactsAction extends Action {
	public String name;
	public String cube;
	public String data;

	public String execute() {
		return setup(new ActionAddDatastoreCubeFacts()).execute();
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