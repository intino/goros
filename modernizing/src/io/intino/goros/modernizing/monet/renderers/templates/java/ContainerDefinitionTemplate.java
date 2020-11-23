package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ContainerDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((allTypes("show","components")), (trigger("declaration"))).output(literal("private Node contain;")),
			rule().condition((allTypes("show","components"))).output(literal("public ")).output(mark("definition", "firstUpperCase")).output(mark("view", "firstUpperCase")).output(literal("ViewTemplate contain(Node contain) {\n\tthis.contain = contain;\n\treturn this;\n}\n\n@Override\npublic void refresh() {\n\tsuper.refresh();\n\t")).output(expression().output(mark("component").multiple("\n"))).output(literal("\n}")),
			rule().condition((type("component"))).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp.node(contain);\n")).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp.view(\"")).output(mark("viewCode")).output(literal("\");\n")).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp.readonly(readonly);\n")).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp.refresh();"))
		);
	}
}