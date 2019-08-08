package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionEmptyTrash;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostEmptyTrashAction extends Action {
	public String execute() {
		return setup(new ActionEmptyTrash()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}