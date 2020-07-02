package org.siani.goros.box;

import io.intino.magritte.framework.Graph;
import org.siani.goros.graph.GorosGraph;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		args = Arrays.asList("api_url=http://localhost","port=9000").toArray(new String[0]);
		GorosBox box = new GorosBox(args);
		GorosGraph gorosGraph = new Graph().loadStashes("Goros").as(GorosGraph.class);
		box.put(gorosGraph);
		box.start(gorosGraph.businessUnit(box.configuration().get("business-unit")));
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}