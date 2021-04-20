package io.intino.goros.documents.box.services;

import io.intino.alexandria.Context;
import io.intino.alexandria.logger.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Response implements org.monet.http.Response {
    private Context context;
    private File tempFile;
    private String contentType;
    private String filename = "out.zip";
    private int status;
    private String encoding;
    private FileOutputStream stream;
    private PrintWriter writer;

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
        if (writer == null) {
            OutputStream outputStream = outputStream();
            if (outputStream == null) return null;
            writer = new PrintWriter(outputStream);
        }
        return writer;
    }

    @Override
    public void setCharacterEncoding(String encoding) {
        this.encoding = encoding;
    }

    public InputStream stream() {
        try {
            if (writer != null) writer.close();
            else if (stream == null) return null;
            return new FileInputStream(tempFile);
        } catch (FileNotFoundException e) {
            Logger.error(e);
            return null;
        }
    }

    public void deleteTempFile() {
        if (tempFile == null) return;
        tempFile.delete();
    }

    private OutputStream outputStream() {
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

    public void setStatus(int status) {
        this.status = status;
    }

}