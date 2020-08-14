package io.intino.goros.box.actions;

import io.intino.alexandria.http.spark.SparkContext;
import org.monet.http.Request;
import io.intino.goros.box.GorosBox;

import java.io.InputStream;
import java.util.Map;

public abstract class Action {
    protected io.intino.goros.box.services.Response response;
    public GorosBox box;
    public SparkContext context;

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) return null;
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(response.getFilename(), response.getContentType(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Request request(Map<String, Object> parameters) {
        return new io.intino.goros.box.services.Request(context, parameters);
    }
}
