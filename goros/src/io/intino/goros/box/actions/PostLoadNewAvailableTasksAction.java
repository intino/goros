package io.intino.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadNewAvailableTasksRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadNewAvailableTasks;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostLoadNewAvailableTasksAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadNewAvailableTasksRequest deserialized = serializer.read(LoadNewAvailableTasksRequest.class, request);
            Response result = new Response(new ActionDoLoadNewAvailableTasks().execute(request(parameters(String.valueOf(ActionCode.LoadNewAvailableTasks), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}