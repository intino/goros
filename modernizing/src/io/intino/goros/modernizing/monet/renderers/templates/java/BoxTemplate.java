package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class BoxTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("box")).output(literal("package ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box;\n\nimport io.intino.alexandria.core.Box;\nimport io.intino.alexandria.ui.services.AuthService;\nimport io.intino.goros.unit.box.UnitBox;\nimport io.intino.goros.unit.box.listeners.GorosUnitNotifier;\n\nimport java.net.URL;\n\npublic class ")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box extends AbstractBox {\n\n    public ")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box(String[] args) {\n        super(args);\n    }\n\n    public ")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box(")).output(placeholder("boxName", "firstUpperCase")).output(literal("Configuration configuration) {\n        super(configuration);\n    }\n\n    @Override\n    protected void initJavaLogger() {\n    }\n\n    @Override\n    public Box put(Object o) {\n        if (o instanceof UnitBox) owner = (UnitBox) o;\n        return super.put(o);\n    }\n\n    public void beforeStart() {\n    }\n\n    public void afterStart() {\n    }\n\n    public void beforeStop() {\n    }\n\n    public void afterStop() {\n    }\n\n    public UnitBox unit() {\n        return ((UnitBox)owner);\n    }\n\n    public GorosUnitNotifier notifier() {\n        return ((UnitBox)owner()).notifier();\n    }\n\n    @Override\n    protected AuthService authService(URL authServiceUrl) {\n        return null;\n    }\n}")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}