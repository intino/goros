package org.siani.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionStop;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostStopAction extends SetupServiceAction {
	public String execute() {
		return executeServiceAction(new ActionStop());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}