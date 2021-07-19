package io.intino.goros.unit.box.actions;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.monet.space.setupservice.control.actions.ActionUpdateModel;
import org.monet.space.setupservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostUpdateModelAction extends SetupServiceAction {
	public io.intino.alexandria.Resource model;

    public java.lang.String execute() {
        return executeServiceAction(new ActionUpdateModel());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.MODEL, new InputStreamBody(model.stream(), ContentType.APPLICATION_OCTET_STREAM));
        return paramMap;
    }
}