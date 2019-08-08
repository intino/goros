package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddSourceTerm;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostAddSourceTermAction extends Action {
	public String code;
	public String parent;
	public String type;
	public String source;
	public String label;
	public String tags;

	public String execute() {
		return setup(new ActionAddSourceTerm()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put(Parameter.CODE, code);
		parameters.put(Parameter.PARENT, parent);
		parameters.put(Parameter.TYPE, type);
		parameters.put(Parameter.SOURCE, source);
		parameters.put(Parameter.LABEL, label);
		parameters.put(Parameter.TAGS, tags);
		return parameters;
	}
}