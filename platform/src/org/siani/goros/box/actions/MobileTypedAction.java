package org.siani.goros.box.actions;

import org.monet.space.kernel.utils.PersisterHelper;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class MobileTypedAction extends Action {
    protected void writeResultInResponse(Object result) throws Exception {
        response.setHeader("Content-Encoding", "gzip");
        response.setContentType("text/xml");
        GZIPOutputStream outputStream = new GZIPOutputStream(response.getOutputStream());
        StringWriter writer = new StringWriter();
        PersisterHelper.save(writer, result);
        outputStream.write(writer.toString().getBytes("UTF-8"));
    }

    Map<String, Object> parameters(String operation, Object deserializedRequest) {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("op", operation);
        parameters.put("request", deserializedRequest);
        return parameters;
    }
}
