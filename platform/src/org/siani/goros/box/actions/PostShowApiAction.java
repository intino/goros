package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionShowApi;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostShowApiAction extends Action {
	public String execute() {
		return setup(new ActionShowApi()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}