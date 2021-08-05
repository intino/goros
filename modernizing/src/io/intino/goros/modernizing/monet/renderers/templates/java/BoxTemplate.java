package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class BoxTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("box"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box;\n\nimport io.intino.alexandria.ui.services.AuthService;\nimport io.intino.goros.unit.box.UnitBox;\nimport io.intino.goros.unit.box.listeners.GorosUnitNotifier;\n\nimport java.net.URL;\n\npublic class ")).output(mark("boxName", "firstUpperCase")).output(literal("Box extends AbstractBox {\n\n    public ")).output(mark("boxName", "firstUpperCase")).output(literal("Box(String[] args) {\n        super(args);\n    }\n\n    public ")).output(mark("boxName", "firstUpperCase")).output(literal("Box(")).output(mark("boxName", "firstUpperCase")).output(literal("Configuration configuration) {\n        super(configuration);\n    }\n\n    public void beforeStart() {\n    }\n\n    public void afterStart() {\n    }\n\n    public void beforeStop() {\n    }\n\n    public void afterStop() {\n    }\n\n    public UnitBox unit() {\n        return ((UnitBox)owner);\n    }\n\n    public GorosUnitNotifier notifier() {\n        return ((UnitBox)owner()).notifier();\n    }\n\n    @Override\n    protected AuthService authService(URL authServiceUrl) {\n        return null;\n    }\n}"))
		);
	}
}