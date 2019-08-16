package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadNewAssignedTasksRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadNewAssignedTasks;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostLoadNewAssignedTasksAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadNewAssignedTasksRequest deserialized = serializer.read(LoadNewAssignedTasksRequest.class, request);
            Response result = new Response(new ActionDoLoadNewAssignedTasks().execute(request(parameters(String.valueOf(ActionCode.LoadNewAssignedTasks), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}