package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.requests.DownloadTaskPackedRequest;
import org.monet.space.mobile.control.actions.ActionDoDownloadTaskPacked;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostDownloadTaskPackedAction extends MobileNonTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            new ActionDoDownloadTaskPacked().execute(request(parameters(String.valueOf(ActionCode.DownloadTaskPacked), request)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}