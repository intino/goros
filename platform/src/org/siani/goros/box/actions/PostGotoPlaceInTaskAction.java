package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGotoPlaceInTask;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGotoPlaceInTaskAction extends Action {
	public String id;
	public String place;
	public String history;

	public String execute() {
		return setup(new ActionGotoPlaceInTask()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.PLACE, place);
		parameters.put(Parameter.HISTORY, history);
		return parameters;
	}
}