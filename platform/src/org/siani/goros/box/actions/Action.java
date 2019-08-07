package org.siani.goros.box.actions;

import org.monet.http.Request;
import org.monet.http.Response;
import org.siani.goros.box.GorosBox;

import java.util.HashMap;
import java.util.Map;

public abstract class Action {
    public GorosBox box;
    public io.intino.alexandria.core.Context context = new io.intino.alexandria.core.Context();

    abstract Map<String, Object> parameters();

    org.monet.space.backservice.control.actions.Action setup(org.monet.space.backservice.control.actions.Action action) {
        HashMap<String, Object> parameters = (HashMap<String, Object>) parameters();
        action.setRequest(request(parameters));
        action.setResponse(response());
        action.setParameters(parameters);
        return action;
    }

    private Request request(Map<String, Object> parameters) {
        return new org.siani.goros.box.Request(context, parameters);
    }

    private Response response() {
        return new org.siani.goros.box.Response();
    }
}
