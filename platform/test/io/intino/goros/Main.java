package io.intino.goros;

import org.siani.goros.box.GorosBox;
import org.siani.goros.graph.GorosGraph;
import io.intino.tara.magritte.Graph;

public class Main {
	public static void main(String[] args) {
		GorosBox box = new GorosBox(args);
		GorosGraph gorosGraph = new Graph().loadStashes("goros").as(GorosGraph.class);
		box.put(gorosGraph);
		box.open(gorosGraph.businessUnit("viasyobras"));
		Runtime.getRuntime().addShutdownHook(new Thread(box::close));
	}
}