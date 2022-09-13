package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.services.Response;
import org.monet.http.Request;
import org.monet.space.applications.ServiceAction;
import org.monet.space.fms.ApplicationFms;
import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.constants.ApplicationInterface;
import org.monet.space.kernel.constants.Database;
import org.monet.space.kernel.model.Context;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class FmsServiceAction extends Action {

    public FmsServiceAction() {
        super();
    }

    abstract Map<String, Object> parameters();

    public String executeServiceAction(ServiceAction action) {
        initialize();
        Request request;
        HashMap<String, Object> parameters;
        parameters = (HashMap<String, Object>) parameters();
        request = request(parameters);
        action.setRequest(request);
        action.setResponse(this.response);
        action.setParameters(parameters);
        return action.execute();
    }

    private void initialize() {
        String idSession = this.createSession();
        Context _context = Context.getInstance();
        Long idThread = Thread.currentThread().getId();

        _context.setApplication(idThread, context.get("realIp"), ApplicationFms.NAME, ApplicationInterface.USER);
        URL url = null;
        try {
            url = new URL(context.get("requestUrl"));
        } catch (MalformedURLException ignore) {
        }
        _context.setUserServerConfig(idThread, url.getHost(), url.getPath(), url.getPort());
        _context.setSessionId(idThread, idSession);
        _context.setDatabaseConnectionType(idThread, Database.ConnectionTypes.AUTO_COMMIT);
        this.response = new Response(context);
    }

    private String createSession() {
        AgentSession agentSession = AgentSession.getInstance();
        String idSession = UUID.randomUUID().toString();
        org.monet.space.kernel.model.Session session = agentSession.get(idSession);

        if (session == null) {
            agentSession.add(idSession);
        }

        return idSession;
    }

}
