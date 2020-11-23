package io.intino.goros.documents.box;

public class Main {
	public static void main(String[] args) {
		DocumentsBox box = new DocumentsBox(args);
		box.start();
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}