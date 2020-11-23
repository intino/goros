package io.intino.goros.unit.box;

public class Main {
	public static void main(String[] args) {
		UnitBox box = new UnitBox(args);
		box.start();
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}