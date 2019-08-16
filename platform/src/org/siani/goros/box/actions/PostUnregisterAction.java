package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.UnregisterRequest;
import org.monet.space.mobile.control.actions.ActionDoUnregister;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostUnregisterAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            UnregisterRequest deserialized = serializer.read(UnregisterRequest.class, request);
            Response result = new Response(new ActionDoUnregister().execute(request(parameters(String.valueOf(ActionCode.Unregister), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}