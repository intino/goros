package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.SyncChatsRequest;
import org.monet.space.mobile.control.actions.ActionDoSyncChats;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostSyncChatsAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            SyncChatsRequest deserialized = serializer.read(SyncChatsRequest.class, request);
            Response result = new Response(new ActionDoSyncChats().execute(request(parameters(String.valueOf(ActionCode.SyncChats), deserialized)), response));
            writeResultInResponse(result);
        } catch (Exception ignored) {
        }
        return resource();
    }
}