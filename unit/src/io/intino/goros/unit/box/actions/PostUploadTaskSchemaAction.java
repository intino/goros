package io.intino.goros.unit.box.actions;

import io.intino.alexandria.Resource;
import org.monet.mobile.service.ActionCode;
import org.monet.space.mobile.control.actions.ActionDoUploadTaskSchema;

import java.util.HashMap;
import java.util.Map;


public class PostUploadTaskSchemaAction extends MobileNonTypedAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public Resource request;

    public io.intino.alexandria.Resource execute() {
        try {
            Map<String, Object> p = new HashMap<>();
            p.put("id", id);
            p.put("request", request);
            new ActionDoUploadTaskSchema().execute(request(parameters(String.valueOf(ActionCode.UploadTaskSchema), p)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}