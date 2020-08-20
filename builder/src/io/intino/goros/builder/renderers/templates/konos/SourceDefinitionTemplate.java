package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class SourceDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("source"))).output(literal("dsl Konos\n\nuse UI\nuse Theme\n\nTemplate(layout=Vertical Flexible, format=smallAir) ")).output(mark("name", "firstUpperCase")).output(literal("Template\n    Block(layout=Horizontal, format=bordered spaced) header\n        Block(layout=Vertical Flexible)\n            Block(layout=Horizontal)\n                Link(title=\"Inicio\", format=h4 middleAirRight) as Action Addressable(")).output(mark("module", "firstUpperCase")).output(literal("Elements.inicio)\n                Text(value=\"/\", format=h4 middleAirRight)\n                Text(value=\"")).output(mark("label")).output(literal("\", format=h4 bold) label\n            Text(format=body2) count\n            OwnerTemplateStamp(template=\"SourceLegendTemplate\", owner=")).output(mark("module", "firstUpperCase")).output(literal("Elements.goros)\n\n    Block(layout=Horizontal Flexible, format=smallAirTop)\n        Block(layout=Vertical Flexible, format=bordered)\n            OwnerTemplateStamp(template=\"SourceEmbeddedTemplate\", owner=")).output(mark("module", "firstUpperCase")).output(literal("Elements.goros) content"))
		);
	}
}