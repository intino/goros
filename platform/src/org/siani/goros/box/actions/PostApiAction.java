package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionShowApi;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostApiAction extends BackServiceAction {
	public String execute() {
		return executeServiceAction(new ActionShowApi());
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}