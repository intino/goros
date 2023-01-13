package io.intino.goros.unit.box.actions;

import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import org.monet.mobile.exceptions.ActionException;
import org.monet.mobile.service.ActionCode;
import org.monet.mobile.service.errors.ServerError;
import org.monet.space.mobile.control.actions.ActionDoUploadTaskSchema;

import java.util.HashMap;
import java.util.Map;


public class PostUploadTaskSchemaAction extends MobileNonTypedAction {
    public UnitBox box;
    public String id;
    public Resource request;

    public io.intino.alexandria.Resource execute() {
        try {
            Map<String, Object> p = new HashMap<>();
            p.put("id", id);
            p.put("request", request);
            new ActionDoUploadTaskSchema().execute(request(parameters(String.valueOf(ActionCode.UploadTaskSchema), p)), response);
        } catch (ActionException e) {
            writeInResponse(e.getErrorResult());
        } catch (Exception e) {
            Logger.error(e);
            writeInResponse((new ServerError()));
        }
        return resource();
    }
}