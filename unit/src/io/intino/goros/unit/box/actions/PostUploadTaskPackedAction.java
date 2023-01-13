package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import org.monet.mobile.exceptions.ActionException;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.errors.ServerError;
import org.monet.space.mobile.control.actions.ActionDoUploadTaskPacked;

public class PostUploadTaskPackedAction extends MobileNonTypedAction {
	public UnitBox box;
	public io.intino.alexandria.Resource request;

    public io.intino.alexandria.Resource execute() {
        try {
            new ActionDoUploadTaskPacked().execute(request(parameters(String.valueOf(ActionCode.UploadTaskPacked), request)), response);
		} catch (ActionException e) {
			writeInResponse(e.getErrorResult());
		} catch (Exception e) {
			Logger.error(e);
			writeInResponse((new ServerError()));
		}
        return resource();
    }
}