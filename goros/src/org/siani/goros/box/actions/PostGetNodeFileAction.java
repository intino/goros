package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionGetNodeFile;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostGetNodeFileAction extends BackServiceAction {
    public String id;
    public String name;

    public io.intino.alexandria.Resource execute() {
        executeServiceAction(new ActionGetNodeFile());
        return resource();
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        paramMap.put(Parameter.NAME, name);
        return paramMap;
    }
}