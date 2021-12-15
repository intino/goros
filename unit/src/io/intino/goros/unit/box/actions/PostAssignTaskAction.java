package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import org.monet.mobile.exceptions.ActionException;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.errors.ServerError;
import org.monet.mobile.service.requests.AssignTaskRequest;
import org.monet.space.mobile.control.actions.ActionDoAssignTask;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostAssignTaskAction extends MobileTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoAssignTask().execute(request(parameters(String.valueOf(ActionCode.AssignTask), request)), response));
            writeResultInResponse(result);
		} catch (ActionException e) {
			writeInResponse(e.getErrorResult());
		} catch (Exception e) {
			Logger.error(e);
			writeInResponse((new ServerError()));
		}
        return resource();
    }
}