package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionAddTaskFact;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddTaskFactAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public String title;
    public String subtitle;
    public String user;
    public String links;

    public java.lang.String execute() {
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