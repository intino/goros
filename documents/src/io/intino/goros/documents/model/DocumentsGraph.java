package io.intino.goros.documents.model;

import io.intino.magritte.framework.Graph;

public class DocumentsGraph extends io.intino.goros.documents.model.AbstractGraph {

	public DocumentsGraph(Graph graph) {
		super(graph);
	}

	public DocumentsGraph(io.intino.magritte.framework.Graph graph, DocumentsGraph wrapper) {
	    super(graph, wrapper);
	}
}