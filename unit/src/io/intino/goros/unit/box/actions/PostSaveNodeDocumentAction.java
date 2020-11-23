package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodeDocument;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodeDocumentAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String id;
    public io.intino.alexandria.Resource data;
    public String contenttype;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveNodeDocument());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.DATA, data.stream());
        paramMap.put(Parameter.CONTENT_TYPE, contenttype);
        return paramMap;
    }
}