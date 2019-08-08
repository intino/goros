package org.siani.goros.box.services;

import io.intino.alexandria.core.Context;

import java.io.IOException;
import java.io.InputStream;
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
        return null;
    }

    @Override
    public String getContextPath() {
        return null;
    }

    @Override
    public String getHeader(String s) {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public String getParameter(String s) {
        return null;
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
