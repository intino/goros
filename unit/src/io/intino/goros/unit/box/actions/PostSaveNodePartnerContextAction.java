package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionSaveNodePartnerContext;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostSaveNodePartnerContextAction extends BackServiceAction {
    public UnitBox box;
    public String id;
    // TODO MARIO permitir context como nombre de parametro public String context;

    public java.lang.String execute() {
        return executeServiceAction(new ActionSaveNodePartnerContext());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.ID, id);
        //paramMap.put(Parameter.CONTEXT, context);
        return paramMap;
    }
}