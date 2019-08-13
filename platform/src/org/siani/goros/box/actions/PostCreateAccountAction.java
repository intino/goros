package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionCreateAccount;
import org.monet.space.backservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostCreateAccountAction extends BackServiceAction {
    public String code;
    public String fullname;
    public String email;
    public String roles;

    public String execute() {
        return executeServiceAction(new ActionCreateAccount());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put(Parameter.CODE, code);
        parameters.put(Parameter.FULLNAME, fullname);
        parameters.put(Parameter.EMAIL, email);
        parameters.put(Parameter.ROLES, roles);
        return parameters;
    }
}