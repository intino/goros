package io.intino.goros.unit.box.actions;

import org.monet.space.frontservice.control.actions.ActionSource;
import org.monet.space.kernel.agents.AgentRestfullClient;

import java.util.HashMap;
import java.util.Map;


public class PostSourceAction extends FrontServiceAction {
	public io.intino.alexandria.core.Box box;
	public String count;
    public String startPos;
    public String searchText;
    public String filters;
    public String from;
    public String depth;
    public String flatten;
    public String mode;
    public String sourceName;
    public String action;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSource());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        if (sourceName != null) paramMap.put(AgentRestfullClient.RequestParameter.SOURCE_NAME, sourceName);
        if (action != null) paramMap.put(AgentRestfullClient.RequestParameter.ACTION, action);
        if (startPos != null) paramMap.put(AgentRestfullClient.RequestParameter.START_POS, startPos);
        if (count != null) paramMap.put(AgentRestfullClient.RequestParameter.COUNT, count);
        if (mode != null) paramMap.put(AgentRestfullClient.RequestParameter.MODE, mode);
        if (flatten != null) paramMap.put(AgentRestfullClient.RequestParameter.FLATTEN, flatten);
        if (depth != null) paramMap.put(AgentRestfullClient.RequestParameter.DEPTH, depth);
        if (from != null) paramMap.put(AgentRestfullClient.RequestParameter.FROM, from);
        if (filters != null) paramMap.put(AgentRestfullClient.RequestParameter.FILTERS, filters);
        if (searchText != null) paramMap.put(AgentRestfullClient.RequestParameter.SEARCH_TEXT, searchText);
        return paramMap;
    }
}