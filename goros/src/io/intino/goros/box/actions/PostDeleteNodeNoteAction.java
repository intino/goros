package io.intino.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionDeleteNodeNote;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostDeleteNodeNoteAction extends BackServiceAction {
    public String id;
    public String name;

    public String execute() {
        return executeServiceAction(new ActionDeleteNodeNote());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.NAME, name);
        return paramMap;
    }
}