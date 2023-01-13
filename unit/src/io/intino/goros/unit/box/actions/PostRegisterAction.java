package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.space.mobile.control.actions.ActionDoRegister;

public class PostRegisterAction extends MobileTypedAction {
    public UnitBox box;
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoRegister().execute(request(parameters(String.valueOf(ActionCode.Register), request)), response));
            writeResultInResponse(result);
            return resource();
        } catch (Exception e) {
            Logger.error(e);
            return null;
        }
    }
}