package org.siani.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionRun;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostRunAction extends SetupServiceAction {
	public String execute() {
		return executeServiceAction(new ActionRun());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}