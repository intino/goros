package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.requests.DownloadGlossaryRequest;
import org.monet.space.mobile.control.actions.ActionDoDownloadGlossary;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostDownloadGlossaryAction extends MobileNonTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            new ActionDoDownloadGlossary().execute(request(parameters(String.valueOf(ActionCode.DownloadGlossary), request)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}