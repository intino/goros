package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionSaveNodePicture;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodePictureAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String name;
    public io.intino.alexandria.Resource data;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveNodePicture());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.NAME, name);
        paramMap.put(Parameter.DATA, data.stream());
        return paramMap;
    }
}