package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class ContainerDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((allTypes("show","components")), (trigger("use"))).output(expression().output(mark("component", "use").multiple("\n"))),
			rule().condition((allTypes("show","components"))).output(expression().output(mark("component").multiple("\n"))),
			rule().condition((type("component")), (trigger("use"))).output(literal("use ")).output(mark("name", "firstUpperCase")),
			rule().condition((allTypes("component","collection"))).output(literal("TemplateStamp(template=")).output(mark("name", "firstUpperCase")).output(literal("EmbeddedTemplate) ")).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp")),
			rule().condition((allTypes("component","catalog"))).output(literal("TemplateStamp(template=")).output(mark("name", "firstUpperCase")).output(literal("EmbeddedTemplate) ")).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp")),
			rule().condition((type("component"))).output(literal("TemplateStamp(template=")).output(mark("name", "firstUpperCase")).output(mark("view", "firstUpperCase")).output(literal("ViewTemplate) ")).output(mark("name", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Stamp"))
		);
	}
}