package org.siani.goros.box.services;

import io.intino.alexandria.Context;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;

public class Request implements org.monet.http.Request {
    private final Context context;
    private final Map<String, Object> parameters;

    public Request(Context context, Map<String, Object> parameters) {
        this.context = context;
        this.parameters = parameters;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public String getSessionId() {
        return null;
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
        return context.containsKey(param) ? context.get(param) : null;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public String getParameter(String name) {
        return parameters.containsKey(name) ? parameters.get(name).toString() : null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
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
}
