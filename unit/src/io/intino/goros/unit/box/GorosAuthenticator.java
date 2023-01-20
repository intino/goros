package io.intino.goros.unit.box;

import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.model.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GorosAuthenticator {

	protected ArrayList<Map.Entry<String, Object>> toList(Map<String, String> params) {
		Map<String, Object> result = new HashMap<>(params);
		return new ArrayList<>(result.entrySet());
	}

	protected void initialize() {
		String idSession = this.createSession();
		Long idThread = Thread.currentThread().getId();
		Context.getInstance().setSessionId(idThread, idSession);
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
