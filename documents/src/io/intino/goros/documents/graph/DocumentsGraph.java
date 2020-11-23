package io.intino.goros.documents.graph;

import io.intino.magritte.framework.Graph;

public class DocumentsGraph extends io.intino.goros.documents.graph.AbstractGraph {

	public DocumentsGraph(Graph graph) {
		super(graph);
	}

	public DocumentsGraph(io.intino.magritte.framework.Graph graph, DocumentsGraph wrapper) {
	    super(graph, wrapper);
	}
}