package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionImportNode;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostImportNodeAction extends Action {
	public String importer;
	public String idscope;
	public String data;

	public String execute() {
		return setup(new ActionImportNode()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.IMPORTER, importer);
		parameters.put(Parameter.ID_SCOPE, idscope);
		parameters.put(Parameter.DATA, data);
		return parameters;
	}
}