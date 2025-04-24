package io.intino.goros.documents.box.actions;

import io.intino.alexandria.Resource;
import io.intino.alexandria.http.server.AlexandriaHttpContext;
import io.intino.goros.documents.box.DocumentsBox;
import io.intino.goros.documents.box.services.Response;
import io.intino.goros.documents.box.util.ResourceHelper;
import org.monet.http.Request;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public abstract class Action {
    protected Response response;
    public DocumentsBox box;
    public AlexandriaHttpContext context;

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) stream = new ByteArrayInputStream(new byte[0]);
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(response.getFilename(), response.getContentType(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Object streamOf(Resource resource) {
        return ResourceHelper.streamOf(resource);
    }

    protected Request request(Map<String, Object> parameters) {
        return new io.intino.goros.documents.box.services.Request(context, parameters);
    }

    public void onMalformedRequest(Throwable e) {
    }

}
