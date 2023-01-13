package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionEmptyTrash;

import java.util.HashMap;
import java.util.Map;


public class PostEmptyTrashAction extends BackServiceAction {

    public UnitBox box;

    public java.lang.String execute() {
        return executeServiceAction(new ActionEmptyTrash());
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}