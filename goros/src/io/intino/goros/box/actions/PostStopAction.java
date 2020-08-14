package io.intino.goros.box.actions;

import org.monet.space.setupservice.control.actions.ActionStop;
import io.intino.goros.box.GorosBox;
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