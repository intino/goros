package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionHasPermissions;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostHasPermissionsAction extends Action {
	public String username;

	public String execute() {
		return setup(new ActionHasPermissions()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.USERNAME, username);
		return parameters;
	}
}