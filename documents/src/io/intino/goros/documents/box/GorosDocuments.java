package io.intino.goros.documents.box;

import io.intino.goros.documents.box.install.Install;
import io.intino.goros.documents.box.modules.DocServiceModule;
import org.monet.docservice.Application;
import org.monet.docservice.guice.InjectorFactory;

import java.util.Map;

public class GorosDocuments {

	public static void open(Map<String, String> parameters) {
		install(parameters);
		openDocuments(parameters);
	}

	private static void install(Map<String, String> parameters) {
		Install install = new Install(parameters);
		install.initWorkspace();
		install.processDB();
		install.processFonts();
	}

	private static void openDocuments(Map<String, String> parameters) {
		InjectorFactory.register(new DocServiceModule(parameters));
		Application application = InjectorFactory.get().getInstance(Application.class);
		application.setName(parameters.get("name"));
		application.run();
	}
}
