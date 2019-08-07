package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddNodeNote;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostAddNodeNoteAction extends Action {
	public String id;
	public String name;
	public String value;

	public String execute() {
		return setup(new ActionAddNodeNote()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.NAME, name);
		parameters.put(Parameter.VALUE, value);
		return parameters;
	}
}