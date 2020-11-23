package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionAddSourceTerm;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostAddSourceTermAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;
	public String code;
    public String parent;
    public String type;
    public String source;
    public String label;
    public String tags;

    public java.lang.String execute() {
        return executeServiceAction(new ActionAddSourceTerm());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        paramMap.put(Parameter.PARENT, parent);
        paramMap.put(Parameter.TYPE, type);
        paramMap.put(Parameter.SOURCE, source);
        paramMap.put(Parameter.LABEL, label);
        paramMap.put(Parameter.TAGS, tags);
        return paramMap;
    }
}