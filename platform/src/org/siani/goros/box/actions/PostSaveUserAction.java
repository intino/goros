package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveUser;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSaveUserAction extends Action {
	public String code;
	public String data;

	public String execute() {
		return setup(new ActionSaveUser()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.DATA, data);
		return parameters;
	}
}