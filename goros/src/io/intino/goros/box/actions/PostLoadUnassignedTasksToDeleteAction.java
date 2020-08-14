package io.intino.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadUnassignedTasksToDeleteRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadUnassignedTasksToDelete;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostLoadUnassignedTasksToDeleteAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadUnassignedTasksToDeleteRequest deserialized = serializer.read(LoadUnassignedTasksToDeleteRequest.class, request);
            Response result = new Response(new ActionDoLoadUnassignedTasksToDelete().execute(request(parameters(String.valueOf(ActionCode.LoadAssignedTasksToDelete), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}