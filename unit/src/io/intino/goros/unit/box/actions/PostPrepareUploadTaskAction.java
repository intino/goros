package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.space.mobile.control.actions.ActionDoPrepareUploadTask;

public class PostPrepareUploadTaskAction extends MobileNonTypedAction {
	public io.intino.alexandria.core.Box box;
	public io.intino.alexandria.Resource request;

    public io.intino.alexandria.Resource execute() {
        try {
            new ActionDoPrepareUploadTask().execute(request(parameters(String.valueOf(ActionCode.UploadTaskPacked), request)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}