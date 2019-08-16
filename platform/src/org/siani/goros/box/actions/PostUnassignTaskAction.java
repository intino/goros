package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.UnassignTaskRequest;
import org.monet.space.mobile.control.actions.ActionDoUnassignTask;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostUnassignTaskAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            UnassignTaskRequest deserialized = serializer.read(UnassignTaskRequest.class, request);
            Response result = new Response(new ActionDoUnassignTask().execute(request(parameters(String.valueOf(ActionCode.UnassignTask), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}