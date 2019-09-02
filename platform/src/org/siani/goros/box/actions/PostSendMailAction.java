package org.siani.goros.box.actions;

import org.monet.space.mailservice.control.actions.ActionSendMail;

import java.util.HashMap;
import java.util.Map;


public class PostSendMailAction extends MailServiceAction {
    public String from;
    public String body;
    public String files;

    public String execute() {
        return executeServiceAction(new ActionSendMail());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("from", from);
        paramMap.put("body", body);
        paramMap.put("files", files);
        return paramMap;
    }
}