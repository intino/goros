package io.intino.goros.box.actions;

import io.intino.alexandria.Resource;
import org.monet.mobile.service.ActionCode;
import org.monet.space.mobile.control.actions.ActionDoUploadTaskSchema;

import java.util.HashMap;
import java.util.Map;


public class PostUploadTaskSchemaAction extends MobileNonTypedAction {
    public String id;
    public Resource request;

    public Resource execute() {
        try {
            Map<String, Object> p = new HashMap<>();
            p.put("id", id);
            new ActionDoUploadTaskSchema().execute(request(parameters(String.valueOf(ActionCode.UploadTaskSchema), p)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}