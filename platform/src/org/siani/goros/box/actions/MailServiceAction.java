package org.siani.goros.box.actions;

import org.monet.space.applications.ServiceAction;

import java.util.HashMap;
import java.util.Map;

public abstract class MailServiceAction extends Action {
    abstract Map<String, Object> parameters();

    public MailServiceAction() {
        super();
    }

    public String executeServiceAction(ServiceAction action) {
        HashMap<String, Object> parameters = (HashMap<String, Object>) parameters();
        action.setRequest(request(parameters));
        action.setResponse(this.response);
        action.setParameters(parameters);
        return action.execute();
    }
}
