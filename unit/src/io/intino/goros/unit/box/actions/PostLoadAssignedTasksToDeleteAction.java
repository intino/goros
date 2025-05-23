package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import org.monet.mobile.exceptions.ActionException;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.errors.ServerError;
import org.monet.mobile.service.requests.LoadNewAssignedTasksRequest;
import org.monet.space.mobile.control.actions.ActionDoLoadAssignedTasksToDelete;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostLoadAssignedTasksToDeleteAction extends MobileTypedAction {
	public UnitBox box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoLoadAssignedTasksToDelete().execute(request(parameters(String.valueOf(ActionCode.LoadAssignedTasksToDelete), request)), response));
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