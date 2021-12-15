package io.intino.goros.unit.box.actions;

import io.intino.alexandria.logger.Logger;
import io.intino.goros.unit.box.services.Response;
import org.monet.http.Request;
import org.monet.mobile.service.ErrorResult;
import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.constants.ApplicationInterface;
import org.monet.space.kernel.constants.Database;
import org.monet.space.kernel.model.Context;
import org.monet.space.kernel.utils.PersisterHelper;
import org.monet.space.mobile.ApplicationMobile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;

public class MobileAction extends Action {

	MobileAction() {
		this.response = new Response(context);
	}

	protected Request request(Map<String, Object> parameters) {
		initialize();
		return new io.intino.goros.unit.box.services.Request(context, parameters);
	}

	protected void initialize() {
		String idSession = this.createSession();
		Context _context = Context.getInstance();
		Long idThread = Thread.currentThread().getId();

		_context.setApplication(idThread, context.get("realIp"), ApplicationMobile.NAME, ApplicationInterface.USER);
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

	protected void writeInResponse(ErrorResult error) {
		try {
			this.response.setContext(context);
			this.response.setContentType("text/xml");
			this.response.setFilename("out.txt");
			OutputStream outputStream = this.response.getOutputStream();
			StringWriter writer = new StringWriter();
			PersisterHelper.save(writer, new org.monet.mobile.service.Response(error));
			outputStream.write(writer.toString().getBytes(StandardCharsets.UTF_8));
			outputStream.close();
		} catch (Exception e) {
			Logger.error(e);
		}
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
