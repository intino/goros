package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeReferences;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGetNodeReferencesAction extends Action {
	public String code;
	public String filter;
	public String orderby;
	public String parameters;
	public String start;
	public String limit;

	public String execute() {
		return setup(new ActionGetNodeReferences()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.FILTER, filter);
		parameters.put(Parameter.ORDER_BY, orderby);
		parameters.put(Parameter.PARAMETERS, parameters);
		parameters.put(Parameter.START, start);
		parameters.put(Parameter.LIMIT, limit);
		return parameters;
	}
}