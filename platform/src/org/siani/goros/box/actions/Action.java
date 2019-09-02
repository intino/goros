package org.siani.goros.box.actions;

import org.monet.http.Request;
import org.monet.space.backservice.ApplicationBackService;
import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.constants.ApplicationInterface;
import org.monet.space.kernel.constants.Database;
import org.monet.space.kernel.model.Context;
import org.siani.goros.box.GorosBox;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

public abstract class Action {
    protected org.siani.goros.box.services.Response response;
    public GorosBox box;
    public io.intino.alexandria.core.Context context = new io.intino.alexandria.core.Context();

    protected io.intino.alexandria.Resource resource() {
        InputStream stream = response.stream();
        if (stream == null) return null;
        //TODO establecer el content-type correcto. El método extensionOf de resource da RuntimeException
        io.intino.alexandria.Resource resource = new io.intino.alexandria.Resource(response.getFilename(), stream);
        response.deleteTempFile();
        return resource;
    }

    protected Request request(Map<String, Object> parameters) {
        return new org.siani.goros.box.services.Request(context, parameters);
    }
}
