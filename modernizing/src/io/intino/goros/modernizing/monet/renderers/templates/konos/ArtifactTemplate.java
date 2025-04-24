package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class ArtifactTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("artifact")).output(literal("dsl Legio\n\nArtifact(groupId = \"")).output(placeholder("package")).output(literal("\", version = \"1.0.0\") model\n    Dsl(name=\"Konos\", version=\"13.2.7\") > Builder(generationPackage=\"box\")\n\n    Imports\n        Compile(\"io.intino.goros\", \"unit\", \"1.3.32\")\n        Compile(\"io.intino.alexandria\", \"ui-framework\", \"4.25.27)\n        Compile(\"io.intino.alexandria\", \"core-framework\", \"2.1.2\")\n\n        Web(\"")).output(placeholder("package")).output(literal("\", \"model-elements\", \"1.0.0\")\n\n        Test(groupId = \"junit\", artifactId = \"junit\", version = \"LATEST\")\n\n    Package(mode = ModulesAndLibrariesLinkedByManifest) as Runnable(mainClass=\" ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.Main\")\n\n    Parameter(\"home\")\n    Parameter(\"port\")\n\nRepository(identifier = \"intino-maven\")\n    Release(url = \"https://artifactory.intino.io/artifactory/releases\")\n    Snapshot(url = \"https://artifactory.intino.io/artifactory/snapshots\")\n\nRunConfiguration local\n    Argument(\"workspace\", \"./temp\")\n    Argument(\"port\", \"9000\")\n    Argument(\"certificate-filename\", \"businessunit-monet.p12\")\n    Argument(\"certificate-password\", \"1234\")\n    Argument(\"jdbc-datasource\", \"jdbc/MonetDatabaseSource\")\n    Argument(\"jdbc-type\", \"mysql\")\n    Argument(\"jdbc-url\", \"jdbc:mysql://localhost:3306/monet?autoReconnect=true&amp;useSSL=false\")\n    Argument(\"jdbc-user\", \"root\")\n    Argument(\"jdbc-password\", \"\")\n    Argument(\"user-data-dir\", \"./temp/monet\")\n    Argument(\"component-documents-monet-url\", \"http://localhost:8080/docservice\")\n    Argument(\"component-documents-monet-is-shared\", \"true\")\n    Argument(\"component-datawarehouse-monet-url\", \"http://localhost:8081/sumus\")\n    Argument(\"services-base-url\", \"http://127.0.0.1:9000\")\n    Argument(\"mobile-fcm-settings-filename\", \"./temp/monet/settings-fcm.json\")\n    Argument(\"mobile-fcm-project-id\", \"\")\n    Argument(\"mobile-google-api-key\", \"\")\n    Argument(\"mail-admin-host\", \"smtp.gmail.com\")\n    Argument(\"mail-admin-host\", \"monet.org\")\n    Argument(\"mail-admin-from\", \"noreply@monet.org\")\n    Argument(\"mail-admin-to\", \"admin@monet.org\")\n    Argument(\"mail-admin-username\", \"admin\")\n    Argument(\"mail-admin-password\", \"\")\n    Argument(\"is-debug-mode\", \"false\")\n    Argument(\"store-directory\", \"./temp/monetfederation/store\")")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}