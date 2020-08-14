package io.intino.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.requests.DownloadTaskPackedRequest;
import org.monet.space.mobile.control.actions.ActionDoDownloadTaskPacked;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostDownloadTaskPackedAction extends MobileNonTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            DownloadTaskPackedRequest deserialized = serializer.read(DownloadTaskPackedRequest.class, request);
            new ActionDoDownloadTaskPacked().execute(request(parameters(String.valueOf(ActionCode.DownloadTaskPacked), deserialized)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}