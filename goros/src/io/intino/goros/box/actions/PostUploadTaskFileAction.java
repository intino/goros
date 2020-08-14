package io.intino.goros.box.actions;

import io.intino.alexandria.Resource;
import org.monet.mobile.service.ActionCode;
import org.monet.space.mobile.control.actions.ActionDoUploadTaskFile;

import java.util.HashMap;
import java.util.Map;


public class PostUploadTaskFileAction extends MobileNonTypedAction {
    public Resource request;
    public String extra;
    public String id;

    public Resource execute() {
        try {
            Map<String, Object> p = new HashMap<>();
            p.put("id", id);
            p.put("extra", extra);
            new ActionDoUploadTaskFile().execute(request(parameters(String.valueOf(ActionCode.UploadTaskFile), p)), response);
        } catch (Exception ignored) {
        }
        return resource();
    }
}