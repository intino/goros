package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeNotes;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeNotesAction extends BackServiceAction {
    public String id;

    public String execute() {
        return executeServiceAction(new ActionGetNodeNotes());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        return paramMap;
    }
}