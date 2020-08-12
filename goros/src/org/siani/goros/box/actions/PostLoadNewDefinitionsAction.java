package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadNewDefinitionsRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadNewDefinitions;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostLoadNewDefinitionsAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadNewDefinitionsRequest deserialized = serializer.read(LoadNewDefinitionsRequest.class, request);
            Response result = new Response(new ActionDoLoadNewDefinitions().execute(request(parameters(String.valueOf(ActionCode.LoadNewDefinitions), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}