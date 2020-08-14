package org.monet.bpi.java;

import org.monet.bpi.NodeDocument;
import org.monet.bpi.ProviderResponse;
import org.monet.bpi.Schema;
import org.monet.bpi.types.File;

import java.util.Iterator;

public class ProviderResponseImpl implements ProviderResponse {

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public String getContent() {
		return null;
	}

	@Override
	public File getFile(String name) {
		return null;
	}

	@Override
	public NodeDocument getDocument(String name, Class<? extends NodeDocument> documentType) {
		return null;
	}

	@Override
	public Schema getSchema(String name, Class<? extends Schema> schemaType) {
		return null;
	}

	@Override
	public String getString(String name) {
		return null;
	}

	@Override
	public Iterator<String> getAttachmentsKeys() {
		return null;
	}
}
