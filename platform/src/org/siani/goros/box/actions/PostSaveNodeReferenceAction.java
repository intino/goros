package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeReference;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSaveNodeReferenceAction extends Action {
	public String id;
	public String code;
	public String attributes;

	public String execute() {
		return setup(new ActionSaveNodeReference()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.ATTRIBUTES, attributes);
		return parameters;
	}
}