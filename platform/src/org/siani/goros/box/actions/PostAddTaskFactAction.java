package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionAddTaskFact;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddTaskFactAction extends BackServiceAction {
    public String id;
    public String title;
    public String subtitle;
    public String user;
    public String links;

    public String execute() {
        return executeServiceAction(new ActionAddTaskFact());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.TITLE, title);
        paramMap.put(Parameter.SUBTITLE, subtitle);
        paramMap.put(Parameter.USER, user);
        paramMap.put(Parameter.LINKS, links);
        return paramMap;
    }
}