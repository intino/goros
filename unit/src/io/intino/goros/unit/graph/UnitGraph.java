package io.intino.goros.unit.graph;

import io.intino.magritte.framework.Graph;

public class UnitGraph extends io.intino.goros.unit.graph.AbstractGraph {

	public UnitGraph(Graph graph) {
		super(graph);
	}

	public UnitGraph(io.intino.magritte.framework.Graph graph, UnitGraph wrapper) {
	    super(graph, wrapper);
	}
}