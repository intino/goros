package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddTaskFact;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostAddTaskFactAction extends Action {
	public String id;
	public String title;
	public String subtitle;
	public String user;
	public String links;

	public String execute() {
		return setup(new ActionAddTaskFact()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.TITLE, title);
		parameters.put(Parameter.SUBTITLE, subtitle);
		parameters.put(Parameter.USER, user);
		parameters.put(Parameter.LINKS, links);
		return parameters;
	}
}