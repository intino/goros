package io.intino.goros;

import org.siani.goros.box.GorosBox;
import org.siani.goros.graph.GorosGraph;
import io.intino.tara.magritte.Graph;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		args = Arrays.asList("api_url=http://localhost","port=9000").toArray(new String[0]);
		GorosBox box = new GorosBox(args);
		GorosGraph gorosGraph = new Graph().loadStashes("Goros").as(GorosGraph.class);
		box.put(gorosGraph);
		box.open(gorosGraph.businessUnit("viasyobras"));
		Runtime.getRuntime().addShutdownHook(new Thread(box::close));
	}
}