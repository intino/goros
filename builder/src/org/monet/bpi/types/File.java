package org.monet.bpi.types;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class File {

	@Attribute(name = "is-attachment")
	protected boolean isAttachment = true;
	@Text
	private String filename;

	private InputStream content;
	private boolean isModelResource = false;
	private String contentType;

	public File() {
	}

	public File(File file) {
	}

	public File(String filename) {
		this.filename = filename;
	}

	public File(String filename, boolean isModelResource) {
		this(filename);
		this.isModelResource = isModelResource;
	}

	public String getFilename() {
		return this.filename;
	}

	public String getContentType() {
		return null;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public boolean equals(File obj) {
		return this.filename.equals(obj.filename);
	}

	public boolean isStoredAtDocEngine() {
		return false;
	}

	public boolean isModelResource() {
		return this.isModelResource;
	}

	public String getAbsolutePath() {
		return null;
	}

	public InputStream getContentAsStream() {
		return null;
	}

	public byte[] getContent() {
		return null;
	}

	public void setContent(byte[] content) {
		this.content = new ByteArrayInputStream(content);
	}

	public void setContent(InputStream content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return this.filename;
	}

	public static File fromFile(java.io.File file) {
		return null;
	}

	public static File fromInputStream(String contentType, InputStream stream) {
		return fromInputStream(UUID.randomUUID().toString(), contentType, stream);
	}

	public static File fromInputStream(String filename, String contentType, InputStream stream) {
		return null;
	}

	public static File fromUrl(String url) {
		return null;
	}

	public static File fromUrl(String url, HashMap<String, List<String>> parameters) {
		return null;
	}

}
