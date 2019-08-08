package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeDocument;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostSaveNodeDocumentAction extends Action {
	public String id;
	public String data;
	public String contenttype;

	public String execute() {
		return setup(new ActionSaveNodeDocument()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.ID, id);
		parameters.put(Parameter.DATA, data);
		parameters.put(Parameter.CONTENT_TYPE, data);
		return parameters;
	}
}