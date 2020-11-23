package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.LoadNewGlossariesRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadNewGlossaries;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostLoadNewGlossariesAction extends MobileTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            LoadNewGlossariesRequest deserialized = serializer.read(LoadNewGlossariesRequest.class, request);
            Response result = new Response(new ActionDoLoadNewGlossaries().execute(request(parameters(String.valueOf(ActionCode.LoadNewGlossaries), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}