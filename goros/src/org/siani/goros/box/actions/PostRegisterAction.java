package org.siani.goros.box.actions;

import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.Response;
import org.monet.mobile.service.requests.RegisterRequest;
import org.monet.space.mobile.control.actions.ActionDoRegister;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;


public class PostRegisterAction extends MobileTypedAction {
    public String request;

    public io.intino.alexandria.Resource execute() {
        try {
            Response result = new Response(new ActionDoRegister().execute(request(parameters(String.valueOf(ActionCode.Register), request)), response));
            writeResultInResponse(result);
            return resource();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}