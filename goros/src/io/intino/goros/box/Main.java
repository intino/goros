package io.intino.goros.box;

public class Main {
	public static void main(String[] args) {
		GorosBox box = new GorosBox(args);
		box.start();
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}