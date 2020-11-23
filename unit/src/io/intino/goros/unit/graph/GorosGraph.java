package io.intino.goros.unit.graph;

import io.intino.magritte.framework.Graph;

public class GorosGraph extends io.intino.goros.unit.graph.AbstractGraph {

	public GorosGraph(Graph graph) {
		super(graph);
	}

	public GorosGraph(io.intino.magritte.framework.Graph graph, GorosGraph wrapper) {
	    super(graph, wrapper);
	}
}