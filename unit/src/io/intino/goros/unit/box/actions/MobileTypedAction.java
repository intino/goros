package io.intino.goros.unit.box.actions;

import org.monet.space.kernel.utils.PersisterHelper;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class MobileTypedAction extends MobileAction {

    protected void writeResultInResponse(org.monet.mobile.service.Response response) throws Exception {
        this.response.setContext(context);
        this.response.setHeader("Content-Encoding", "gzip");
        this.response.setContentType("text/xml");
        this.response.setFilename("out.zip");
        GZIPOutputStream outputStream = new GZIPOutputStream(this.response.getOutputStream());
        StringWriter writer = new StringWriter();
        PersisterHelper.save(writer, response);
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
