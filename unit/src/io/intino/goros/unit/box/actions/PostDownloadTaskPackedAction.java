package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import org.monet.mobile.exceptions.ActionException;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.errors.ServerError;
import org.monet.mobile.service.requests.DownloadTaskPackedRequest;
import org.monet.space.mobile.control.actions.ActionDoDownloadTaskPacked;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostDownloadTaskPackedAction extends MobileNonTypedAction {
	public UnitBox box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            new ActionDoDownloadTaskPacked().execute(request(parameters(String.valueOf(ActionCode.DownloadTaskPacked), request)), response);
		} catch (ActionException e) {
			writeInResponse(e.getErrorResult());
		} catch (Exception e) {
			Logger.error(e);
			writeInResponse((new ServerError()));
		}
        return resource();
    }
}