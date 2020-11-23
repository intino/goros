package io.intino.goros.unit.box.actions;

import io.intino.alexandria.http.spark.SparkContext;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.services.Response;
import org.monet.http.Request;

import java.io.InputStream;
import java.util.Map;

public abstract class Action {
    protected Response response;
    public UnitBox box;
    public SparkContext context;

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) return null;
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(response.getFilename(), response.getContentType(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Request request(Map<String, Object> parameters) {
        return new io.intino.goros.unit.box.services.Request(context, parameters);
    }
}
