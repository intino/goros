package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class ContainerDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(all(allTypes("show", "components"), trigger("use"))).output(expression().output(placeholder("component", "use").multiple("\n"))));
		rules.add(rule().condition(allTypes("show", "components")).output(expression().output(placeholder("component").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("component"), trigger("use"))).output(literal("use ")).output(placeholder("name", "firstUpperCase")));
		rules.add(rule().condition(allTypes("component", "collection")).output(literal("TemplateStamp(template=")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate) ")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp")));
		rules.add(rule().condition(allTypes("component", "catalog")).output(literal("TemplateStamp(template=")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate) ")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp")));
		rules.add(rule().condition(allTypes("component")).output(literal("TemplateStamp(template=")).output(placeholder("name", "firstUpperCase")).output(placeholder("view", "firstUpperCase")).output(literal("ViewTemplate) ")).output(placeholder("name", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Stamp")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}