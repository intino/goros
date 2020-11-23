package io.intino.goros.documents.box;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class DocumentsBox extends AbstractBox {

	public DocumentsBox(String[] args) {
		super(args);
	}

	public DocumentsBox(DocumentsConfiguration configuration) {
		super(configuration);
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	@Override
	public void beforeStart() {
	}

	@Override
	public void afterStart() {
		GorosDocuments.open(configuration.args());
	}

	@Override
	public void beforeStop() {
	}

	@Override
	public void afterStop() {
	}

	public io.intino.alexandria.http.security.BasicAuthenticationValidator authenticationValidator() {
		return token -> false;
	}

}