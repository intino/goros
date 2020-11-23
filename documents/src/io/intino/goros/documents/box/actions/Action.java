package io.intino.goros.documents.box.actions;

import io.intino.alexandria.http.spark.SparkContext;
import io.intino.goros.documents.box.DocumentsBox;
import io.intino.goros.documents.box.services.Response;
import org.monet.http.Request;

import java.io.InputStream;
import java.util.Map;

public abstract class Action {
    protected Response response;
    public DocumentsBox box;
    public SparkContext context;

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) return null;
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(response.getFilename(), response.getContentType(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Request request(Map<String, Object> parameters) {
        return new io.intino.goros.documents.box.services.Request(context, parameters);
    }
}
