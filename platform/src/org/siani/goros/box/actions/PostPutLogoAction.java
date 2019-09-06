package org.siani.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionPutLogo;
import org.monet.space.setupservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostPutLogoAction extends SetupServiceAction {
	public io.intino.alexandria.Resource logo;

	public String execute() {
		return executeServiceAction(new ActionPutLogo());
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put(Parameter.LOGO, logo.stream());
		return paramMap;
	}
}