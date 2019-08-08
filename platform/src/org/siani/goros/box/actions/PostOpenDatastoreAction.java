package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionOpenDatastore;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostOpenDatastoreAction extends Action {
	public String name;

	public String execute() {
		return setup(new ActionOpenDatastore()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.NAME, name);
		return parameters;
	}
}