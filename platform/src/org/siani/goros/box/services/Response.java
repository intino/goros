package org.siani.goros.box.services;

import io.intino.alexandria.Context;
import io.intino.alexandria.logger.Logger;

import java.io.*;

public class Response implements org.monet.http.Response {
    private Context context;
    private FileOutputStream stream;
    private File tempFile;
    private String contentType;
    private String filename;

    public Response(Context context) {
        this.context = context;
    }

    @Override
    public void setContentType(String type) {
        context.add("content-type", type);
        contentType = type;
    }

    @Override
    public void setContentLength(int length) {
        context.add("content-length", String.valueOf(length));
    }

    @Override
    public void setHeader(String name, String value) {
        context.add(name, value);
        if(name.equals("Content-Disposition")) filename = value.substring(value.indexOf("filename=") + 9);
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream();
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(outputStream());
    }

    public InputStream stream() {
        try {
            if (stream == null) return null;
            stream.close();
            return new FileInputStream(tempFile);
        } catch (IOException e) {
            Logger.error(e);
            return null;
        }
    }

    public void deleteTempFile() {
        if (tempFile == null) return;
        tempFile.delete();
    }

    private FileOutputStream outputStream() {
        if (stream == null) {
            try {
                tempFile = File.createTempFile("goros-response", null);
                stream = new FileOutputStream(tempFile);
            } catch (IOException e) {
                Logger.error(e);
            }
        }
        return stream;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}