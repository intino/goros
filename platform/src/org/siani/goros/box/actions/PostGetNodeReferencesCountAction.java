package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeReferencesCount;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGetNodeReferencesCountAction extends Action {
	public String code;
	public String filter;
	public String parameters;

	public String execute() {
		return setup(new ActionGetNodeReferencesCount()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.FILTER, filter);
		parameters.put(Parameter.PARAMETERS, parameters);
		return parameters;
	}
}