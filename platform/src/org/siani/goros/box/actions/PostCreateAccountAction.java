package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionCreateAccount;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostCreateAccountAction extends Action {
	public String code;
	public String fullname;
	public String email;
	public String roles;

	public String execute() {
		return setup(new ActionCreateAccount()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.FULLNAME, fullname);
		parameters.put(Parameter.EMAIL, email);
		parameters.put(Parameter.ROLES, roles);
		return parameters;
	}
}