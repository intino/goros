package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionDownloadDistribution;

import java.util.HashMap;
import java.util.Map;


public class PostDownloadDistributionAction extends BackServiceAction {

    public UnitBox box;

    public io.intino.alexandria.Resource execute() {
        executeServiceAction(new ActionDownloadDistribution());
        return resource();
    }

    @Override
    Map<String, Object> parameters() {
        return new HashMap<>();
    }
}