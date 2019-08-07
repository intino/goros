package org.siani.goros.box;

import io.intino.alexandria.core.Box;

public class Main {
	public static void main(String[] args) {
		Box box = new GorosBox(args);
		io.intino.tara.magritte.Graph graph = new io.intino.tara.magritte.Graph().loadStashes("goros");
		box.put(graph);
		box.open();
		Runtime.getRuntime().addShutdownHook(new Thread(box::close));
	}
}