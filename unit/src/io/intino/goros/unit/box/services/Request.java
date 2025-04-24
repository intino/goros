package io.intino.goros.unit.box.services;

import io.intino.alexandria.Resource;
import io.intino.alexandria.http.server.AlexandriaHttpContext;
import io.intino.alexandria.logger.Logger;
import org.monet.space.kernel.model.Context;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;

public class Request implements org.monet.http.Request {
    private final AlexandriaHttpContext context;
    private final Map<String, Object> parameters;
    private final InputStream inputStream;

    public Request(AlexandriaHttpContext context, Map<String, Object> parameters) {
        this.context = context;
        this.parameters = parameters;
        this.inputStream = streamFrom(parameters);
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public String getSessionId() {
        return Context.getInstance().getIdSession(Thread.currentThread().getId());
    }

    @Override
    public String getRequestURL() {
        return context.get("requestUrl");
    }

    @Override
    public String getContextPath() {
        URL url = null;
        try {
            url = new URL(context.get("requestUrl"));
        } catch (MalformedURLException ignore) {
            return null;
        }
        return url.getPath();
    }

    @Override
    public String getHeader(String param) {
        return context.header(param);
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public String getParameter(String name) {
        Object result = parameters.getOrDefault(name, null);
        return result != null ? result.toString() : null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public InputStream getInputStream() {
        return inputStream != null ? inputStream : new ByteArrayInputStream(new byte[0]);
    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    private InputStream streamFrom(Map<String, Object> parameters) {
        try {
            Resource resource = parameters.values().stream().filter(p -> p instanceof Resource).map(p -> (Resource) p).findFirst().orElse(null);
            return resource != null ? resource.stream() : null;
        } catch (IOException e) {
            Logger.error(e);
            return null;
		}
	}

}
