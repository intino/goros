package org.siani.goros.box.actions;

import java.util.HashMap;
import java.util.Map;

public class MobileNonTypedAction extends Action {
    Map<String, Object> parameters(String operation, Object deserializedRequest) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("op", operation);
        parameters.put("request", deserializedRequest);
        return parameters;
    }

    Map<String, Object> parameters(String operation, Map<String, Object> paramsToAdd) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("op", operation);
        parameters.putAll(paramsToAdd);
        return parameters;
    }
}
