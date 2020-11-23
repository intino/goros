package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionEmptyTrash;

import java.util.HashMap;
import java.util.Map;


public class PostEmptyTrashAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;

	public java.lang.String execute() {
        return executeServiceAction(new ActionEmptyTrash());
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}