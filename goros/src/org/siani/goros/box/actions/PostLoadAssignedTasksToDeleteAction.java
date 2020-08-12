package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadNewAssignedTasksRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadAssignedTasksToDelete;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostLoadAssignedTasksToDeleteAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadNewAssignedTasksRequest deserialized = serializer.read(LoadNewAssignedTasksRequest.class, request);
            Response result = new Response(new ActionDoLoadAssignedTasksToDelete().execute(request(parameters(String.valueOf(ActionCode.LoadAssignedTasksToDelete), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}