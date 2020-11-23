package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.services.Response;

import java.util.HashMap;
import java.util.Map;

public class MobileNonTypedAction extends Action {
    MobileNonTypedAction() {
        this.response = new Response(context);
    }

    Map<String, Object> parameters(String operation, Object deserializedRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("op", operation);
        paramMap.put("request", deserializedRequest);
        return paramMap;
    }

    Map<String, Object> parameters(String operation, Map<String, Object> paramsToAdd) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("op", operation);
        paramMap.putAll(paramsToAdd);
        return paramMap;
    }
}
