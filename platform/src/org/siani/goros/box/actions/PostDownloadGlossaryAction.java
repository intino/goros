package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.requests.DownloadGlossaryRequest;
import org.monet.space.mobile.control.actions.ActionDoDownloadGlossary;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostDownloadGlossaryAction extends MobileNonTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Serializer serializer = new Persister();
            DownloadGlossaryRequest deserialized = serializer.read(DownloadGlossaryRequest.class, request);
            new ActionDoDownloadGlossary().execute(request(parameters(String.valueOf(ActionCode.DownloadGlossary), deserialized)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}