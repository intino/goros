package io.intino.goros.unit.box.actions;

import org.monet.space.backservice.control.actions.ActionDownloadDistribution;

import java.util.HashMap;
import java.util.Map;


public class PostDownloadDistributionAction extends BackServiceAction {
	public io.intino.alexandria.core.Box box;

	public io.intino.alexandria.Resource execute() {
        executeServiceAction(new ActionDownloadDistribution());
        return resource();
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}