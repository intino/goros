package io.intino.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.space.mobile.control.actions.ActionDoUploadTaskPacked;

public class PostUploadTaskPackedAction extends MobileNonTypedAction {
    public io.intino.alexandria.Resource request;

    public io.intino.alexandria.Resource execute() {
        try {
            new ActionDoUploadTaskPacked().execute(request(parameters(String.valueOf(ActionCode.UploadTaskPacked), request)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}