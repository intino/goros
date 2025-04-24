package io.intino.goros.unit.box;

import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.model.Context;

import java.util.*;
import java.util.stream.Collectors;

public class GorosAuthenticator {

	protected String value(Map<String, java.util.List<String>> parameters, String key) {
		if (!parameters.containsKey(key)) return null;
		List<String> values = parameters.get(key);
		return !values.isEmpty() ? values.get(0) : null;
	}

	protected ArrayList<Map.Entry<String, Object>> toList(Map<String, List<String>> params) {
		Map<String, Object> result = new HashMap<>(params);
		params.forEach((key, value) -> result.put(key, !value.isEmpty() ? value.get(0) : null));
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
