package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.AssignTaskRequest;
import org.monet.space.mobile.control.actions.ActionDoAssignTask;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostAssignTaskAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            AssignTaskRequest deserialized = serializer.read(AssignTaskRequest.class, request);
            Response result = new Response(new ActionDoAssignTask().execute(request(parameters(String.valueOf(ActionCode.AssignTask), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}