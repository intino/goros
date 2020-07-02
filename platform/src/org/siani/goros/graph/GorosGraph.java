package org.siani.goros.graph;

import io.intino.magritte.framework.Graph;

public class GorosGraph extends org.siani.goros.graph.AbstractGraph {

	public GorosGraph(Graph graph) {
		super(graph);
	}

	public GorosGraph(io.intino.magritte.framework.Graph graph, GorosGraph wrapper) {
	    super(graph, wrapper);
	}

	public BusinessUnit businessUnit(String name) {
		return businessUnitList().stream().filter(b -> b.name$().equals(name)).findFirst().orElse(null);
	}
}