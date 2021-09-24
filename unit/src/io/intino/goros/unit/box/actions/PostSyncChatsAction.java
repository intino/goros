package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.SyncChatsRequest;
import org.monet.space.mobile.control.actions.ActionDoSyncChats;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostSyncChatsAction extends MobileTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoSyncChats().execute(request(parameters(String.valueOf(ActionCode.SyncChats), request)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}