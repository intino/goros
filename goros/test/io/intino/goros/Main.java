package io.intino.goros;

import io.intino.magritte.framework.Graph;
import io.intino.goros.box.GorosBox;
import io.intino.goros.graph.GorosGraph;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		args = Arrays.asList("api_url=http://localhost","port=9000").toArray(new String[0]);
		GorosBox box = new GorosBox(args);
		GorosGraph gorosGraph = new Graph().loadStashes("Goros").as(GorosGraph.class);
		box.put(gorosGraph);
		box.start();
		box.open(gorosGraph.businessUnit("viasyobras"));
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}