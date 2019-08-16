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
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.ID, id);
        parameters.put(Parameter.TITLE, title);
        parameters.put(Parameter.SUBTITLE, subtitle);
        parameters.put(Parameter.USER, user);
        parameters.put(Parameter.LINKS, links);
        return parameters;
    }
}