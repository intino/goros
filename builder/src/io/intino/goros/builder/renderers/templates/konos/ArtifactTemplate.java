package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ArtifactTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("artifact"))).output(literal("dsl Legio\n\nArtifact(groupId = \"")).output(mark("package")).output(literal("\", version = \"1.0.0\") model as Product\n    Model(language = \"Goros\", version = \"1.0.0-SNAPSHOT\", sdk = \"4.1.2\")\n    Box(language = \"Konos\", version = \"8.8.20\")\n\n    Imports\n        Compile(\"io.intino.alexandria\", \"ui-framework\", \"4.3.20\")\n        Compile(\"io.intino.alexandria\", \"core-framework\", \"2.0.4\")\n\n        Web(\"")).output(mark("package")).output(literal("\", \"model-elements\", \"1.0.0\")\n\n        Test(groupId = \"junit\", artifactId = \"junit\", version = \"LATEST\")\n\n    Package(mode = ModulesAndLibrariesLinkedByManifest) as Runnable(mainClass=\"")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.Main\")\n\n    Parameter(\"home\")\n    Parameter(\"port\")\n\nRepository(identifier = \"intino-maven\")\n    Release(url = \"https://artifactory.intino.io/artifactory/releases\")\n\nRunConfiguration local\n    Argument(\"home\", \"./temp\")\n    Argument(\"port\", \"8000\")"))
		);
	}
}