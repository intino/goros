package io.intino.goros.unit.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.space.mobile.control.actions.ActionDoHelo;

public class PostHeloAction extends MobileTypedAction {
	public io.intino.alexandria.core.Box box;
	public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoHelo().execute(request(parameters(String.valueOf(ActionCode.Helo), request)), response));
            writeResultInResponse(result);
            return resource();
        } catch (Exception e) {
            return null;
        }
    }
}