package org.siani.goros.box.actions;

import org.monet.http.Request;
import org.siani.goros.box.GorosBox;

import java.io.InputStream;
import java.util.Map;

public abstract class Action {
    protected org.siani.goros.box.services.Response response;
    public GorosBox box;
    public io.intino.alexandria.rest.spark.SparkContext context;

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) return null;
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(response.getFilename(), response.getContentType(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Request request(Map<String, Object> parameters) {
        return new org.siani.goros.box.services.Request(context, parameters);
    }
}
