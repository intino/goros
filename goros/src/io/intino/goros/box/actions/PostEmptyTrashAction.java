package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionEmptyTrash;

import java.util.HashMap;
import java.util.Map;


public class PostEmptyTrashAction extends BackServiceAction {
    public String execute() {
        return executeServiceAction(new ActionEmptyTrash());
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}