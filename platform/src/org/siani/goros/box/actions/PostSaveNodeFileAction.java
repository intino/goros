package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeFile;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSaveNodeFileAction extends Action {
	public String name;
	public String data;

	public String execute() {
		return setup(new ActionSaveNodeFile()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.NAME, name);
		parameters.put(Parameter.DATA, data);
		return parameters;
	}
}