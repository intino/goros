package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class ContainerDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(all(allTypes("show", "components"), trigger("declaration"))).output(literal("private Node contain;")));
		rules.add(rule().condition(all(allTypes("show", "components"), trigger("hidetoolbar"))).output(expression().output(placeholder("component", "hideToolbar").multiple("\n"))));
		rules.add(rule().condition(allTypes("show", "components")).output(literal("public ")).output(placeholder("definition", "firstUpperCase")).output(placeholder("view", "firstUpperCase")).output(literal("ViewTemplate contain(Node contain) {\n\tthis.contain = contain;\n\treturn this;\n}\n\n@Override\npublic void refresh() {\n\tsuper.refresh();\n\t")).output(expression().output(placeholder("component").multiple("\n"))).output(literal("\n}")));
		rules.add(rule().condition(all(allTypes("component"), trigger("hidetoolbar"))).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.hideToolbar();")));
		rules.add(rule().condition(allTypes("component", "collection")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.node(contain);\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.view(\"")).output(placeholder("viewCode")).output(literal("\");\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.toggleView(ToggleEvent.State.On);\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.readonly(readonly);\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.refresh();")));
		rules.add(rule().condition(allTypes("component")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.node(contain);\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.view(\"")).output(placeholder("viewCode")).output(literal("\");\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.readonly(readonly);\n")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp.refresh();")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}