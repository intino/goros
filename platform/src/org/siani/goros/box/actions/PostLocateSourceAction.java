package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionLocateSource;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostLocateSourceAction extends Action {
	public String code;
	public String url;

	public String execute() {
		return setup(new ActionLocateSource()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.URL, url);
		return parameters;
	}
}