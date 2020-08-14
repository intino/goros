package io.intino.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionExecuteConstructor;
import io.intino.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostExecuteConstructorAction extends SetupServiceAction {
	public String execute() {
		return executeServiceAction(new ActionExecuteConstructor());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}