package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadFinishedTasksToDeleteRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadFinishedTasksToDelete;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostLoadFinishedTasksToDeleteAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadFinishedTasksToDeleteRequest deserialized = serializer.read(LoadFinishedTasksToDeleteRequest.class, request);
            Response result = new Response(new ActionDoLoadFinishedTasksToDelete().execute(request(parameters(String.valueOf(ActionCode.LoadFinishedTasksToDelete), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}