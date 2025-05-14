package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class DocumentDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("documentdefinition")).output(literal("dsl Konos\n\nuse UI\nuse Theme\n\nTemplate(layout=Vertical Flexible, format=smallAir) ")).output(placeholder("name", "firstUpperCase")).output(literal("Template\n    Block(layout=Horizontal, format=headerSpaced) header\n        Block(layout=Vertical Flexible)\n            Block(layout=Horizontal)\n                ")).output(expression().output(placeholder("desktop"))).output(literal("\n                ")).output(expression().output(placeholder("parent"))).output(literal("\n                Text(value=\"")).output(placeholder("label")).output(literal("\", format=h4 bold) label\n            Text(format=body2 grey) description\n\n    Block(layout=Horizontal Flexible, format=smallAirTop) > TemplateStamp(template=")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate) content\n\nTemplate(layout=Vertical Flexible) ")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate as Relative(height=100%)\n    ")).output(placeholder("toolbar", "navigableExpanded")).output(literal("\n    Block(layout=Horizontal, format=bottomBordered bottomSpaced leftSpaced middleTopSpaced) toolbar\n        Block(layout=Vertical CenterJustified Flexible)\n            Block(layout=Horizontal)\n                ")).output(placeholder("toolbar", "editable")).output(literal("\n        Block(layout=Horizontal EndJustified)\n            ")).output(placeholder("toolbar", "navigable")).output(literal("\n\n    Block(layout=Vertical Flexible) content as Relative(height=100%)\n        Block(layout=Vertical Flexible, format=spaced) previewView as Relative(height=100%) > InheritTemplateStamp(template=\"NodeDocumentTemplate\", owner=")).output(placeholder("module", "firstUpperCase")).output(literal("Elements.goros) previewStamp")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}