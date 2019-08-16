package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodePartnerContext;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodePartnerContextAction extends Action {
	public String id;
//TODO FRAN no se puede llamar context -> public String context;

	public String execute() {
		return setup(new ActionSaveNodePartnerContext()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.CONTEXT, context);
		return parameters;
	}
}