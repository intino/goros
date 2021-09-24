package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.UnassignTaskRequest;
import org.monet.space.mobile.control.actions.ActionDoUnassignTask;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostUnassignTaskAction extends MobileTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoUnassignTask().execute(request(parameters(String.valueOf(ActionCode.UnassignTask), request)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}