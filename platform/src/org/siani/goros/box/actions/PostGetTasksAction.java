package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetTasks;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetTasksAction extends BackServiceAction {
    public String inbox;
    public String folder;
    public String condition;
    public String owner;
    public String start;
    public String limit;

    public String execute() {
        return executeServiceAction(new ActionGetTasks());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.INBOX, inbox);
        paramMap.put(Parameter.FOLDER, folder);
        paramMap.put(Parameter.CONDITION, condition);
        paramMap.put(Parameter.OWNER, owner);
        paramMap.put(Parameter.START, start);
        paramMap.put(Parameter.LIMIT, limit);
        return paramMap;
    }
}