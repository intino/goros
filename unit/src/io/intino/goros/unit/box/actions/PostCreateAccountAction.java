package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.backservice.control.actions.ActionCreateAccount;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostCreateAccountAction extends BackServiceAction {
    public UnitBox box;
    public String code;
    public String fullname;
    public String email;
    public String roles;

    public java.lang.String execute() {
        return executeServiceAction(new ActionCreateAccount());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(Parameter.CODE, code);
        paramMap.put(Parameter.FULLNAME, fullname);
        paramMap.put(Parameter.EMAIL, email);
        paramMap.put(Parameter.ROLES, roles);
        return paramMap;
    }
}