package io.intino.goros.box.actions;

import org.monet.space.kernel.utils.PersisterHelper;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class MobileTypedAction extends Action {
    MobileTypedAction() {
        this.response = new io.intino.goros.box.services.Response(context);
    }

    protected void writeResultInResponse(Object result) throws Exception {
        response.setHeader("Content-Encoding", "gzip");
        response.setContentType("text/xml");
        response.setFilename("out.zip");
        GZIPOutputStream outputStream = new GZIPOutputStream(response.getOutputStream());
        StringWriter writer = new StringWriter();
        PersisterHelper.save(writer, result);
        outputStream.write(writer.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    Map<String, Object> parameters(String operation, Object deserializedRequest) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("op", operation);
        paramMap.put("request", deserializedRequest);
        return paramMap;
    }
}