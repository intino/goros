package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class MainTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("main")).output(literal("package ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box;\n\nimport io.intino.goros.unit.box.UnitBox;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        ")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box box = new ")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box(args);\n        box.put(new UnitBox(args));\n        box.start();\n        Runtime.getRuntime().addShutdownHook(new Thread(box::stop));\n    }\n\n}")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}