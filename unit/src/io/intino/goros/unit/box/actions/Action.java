package io.intino.goros.unit.box.actions;

import cotton.signatory.core.StreamHelper;
import io.intino.alexandria.Resource;
import io.intino.alexandria.http.server.AlexandriaHttpContext;
import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.services.Response;
import io.intino.goros.unit.util.ResourceHelper;
import org.monet.http.Request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract class Action {
    protected Response response;
    public UnitBox box;
    public AlexandriaHttpContext context;

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) return null;
        String filename = response.getFilename() != null ? response.getFilename() : "out.zip";
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(filename, response.getContentType(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Object streamOf(Resource resource) {
        return ResourceHelper.streamOf(resource);
    }

    protected Request request(Map<String, Object> parameters) {
        return new io.intino.goros.unit.box.services.Request(context, parameters);
    }

    public void onMalformedRequest(Throwable e) {
    }
}
