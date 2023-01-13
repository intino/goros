package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionHasPermissions;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostHasPermissionsAction extends BackServiceAction {
    public UnitBox box;
    public String username;

    public java.lang.String execute() {
        return executeServiceAction(new ActionHasPermissions());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.USERNAME, username);
        return paramMap;
    }
}