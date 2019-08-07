package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSubscribe;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSubscribeAction extends Action {
	public String type;
	public String data;

	public String execute() {
		return setup(new ActionSubscribe()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.TYPE, type);
		parameters.put(Parameter.DATA, data);
		return parameters;
	}
}