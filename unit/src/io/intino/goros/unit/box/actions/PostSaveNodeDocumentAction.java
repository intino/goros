package io.intino.goros.unit.box.actions;

import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionSaveNodeDocument;
import org.monet.space.backservice.control.constants.Parameter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostSaveNodeDocumentAction extends BackServiceAction {
    public UnitBox box;
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
        paramMap.put(Parameter.DATA, streamOf(data));
        paramMap.put(Parameter.CONTENT_TYPE, contenttype);
        return paramMap;
    }

}