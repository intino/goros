package io.intino.goros.builders.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class BoxTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("box"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box;\n\nimport io.intino.alexandria.ui.services.AuthService;\nimport io.intino.goros.box.GorosBox;\nimport io.intino.goros.box.listeners.GorosNotifier;\n\nimport java.net.URL;\n\npublic class ")).output(mark("module", "firstUpperCase")).output(literal("Box extends AbstractBox {\n\n    public ")).output(mark("module", "firstUpperCase")).output(literal("Box(String[] args) {\n        super(args);\n    }\n\n    public ")).output(mark("module", "firstUpperCase")).output(literal("Box(")).output(mark("module", "firstUpperCase")).output(literal("Configuration configuration) {\n        super(configuration);\n    }\n\n    public void beforeStart() {\n    }\n\n    public void afterStart() {\n    }\n\n    public void beforeStop() {\n    }\n\n    public void afterStop() {\n    }\n\n    public GorosBox goros() {\n        return ((GorosBox)owner);\n    }\n\n    public GorosNotifier notifier() {\n        return ((GorosBox)owner()).notifier();\n    }\n\n    @Override\n    protected AuthService authService(URL authServiceUrl) {\n        return null;\n    }\n}"))
		);
	}
}