package io.intino.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionGetVersion;
import io.intino.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostGetMajorVersionAction extends SetupServiceAction {
	public String execute() {
		return executeServiceAction(new ActionGetVersion());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}