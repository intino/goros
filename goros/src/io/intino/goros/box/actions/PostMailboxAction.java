package io.intino.goros.box.actions;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.monet.space.frontservice.control.actions.ActionMailBox;
import org.monet.space.frontservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostMailboxAction extends FrontServiceAction {
    public String address;
    public String signaling;
    public io.intino.alexandria.Resource message;
    public String messageCode;
    public String messageType;
    public String messageHash;

    public String execute() {
        return executeServiceAction(new ActionMailBox());
    }

    @Override
    Map<String, Object> parameters() {
        HashMap<String, Object> paramMap = new HashMap<>();
        if (address != null) paramMap.put(Parameter.ADDRESS, address);
        if (signaling != null) paramMap.put(Parameter.SIGNALING, signaling);
        if (message != null)
            paramMap.put(Parameter.MESSAGE, new InputStreamBody(message.stream(), ContentType.APPLICATION_OCTET_STREAM));
        if (messageCode != null) paramMap.put(Parameter.MESSAGE_CODE, messageCode);
        if (messageType != null) paramMap.put(Parameter.MESSAGE_TYPE, messageType);
        if (messageHash != null) paramMap.put(Parameter.MESSAGE_HASH, messageHash);
        return paramMap;
    }
}