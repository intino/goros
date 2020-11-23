package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class MainTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("main"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        ")).output(mark("module", "firstUpperCase")).output(literal("Box box = new ")).output(mark("module", "firstUpperCase")).output(literal("Box(args);\n        box.start();\n        Runtime.getRuntime().addShutdownHook(new Thread(box::stop));\n    }\n\n}"))
		);
	}
}