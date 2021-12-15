package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import org.monet.mobile.exceptions.ActionException;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.errors.ServerError;
import org.monet.mobile.service.requests.UnregisterRequest;
import org.monet.space.mobile.control.actions.ActionDoUnregister;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class PostUnregisterAction extends MobileTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoUnregister().execute(request(parameters(String.valueOf(ActionCode.Unregister), request)), response));
            writeResultInResponse(result);
		} catch (ActionException e) {
			response.getWriter().write(e.getErrorResult().toString());
		} catch (Exception e) {
			Logger.error(e);
			response.getWriter().write((new ServerError()).toString());
		}
        return resource();
    }
}