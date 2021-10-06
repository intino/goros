package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class DocumentDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("documentdefinition"))).output(literal("dsl Konos\n\nuse UI\nuse Theme\n\nTemplate(layout=Vertical Flexible, format=smallAir) ")).output(mark("name", "firstUpperCase")).output(literal("Template\n    Block(layout=Horizontal, format=headerSpaced) header\n        Block(layout=Vertical Flexible)\n            Block(layout=Horizontal)\n                ")).output(expression().output(mark("desktop"))).output(literal("\n                ")).output(expression().output(mark("parent"))).output(literal("\n                Text(value=\"")).output(mark("label")).output(literal("\", format=h4 bold) label\n            Text(format=body2 grey) description\n\n    Block(layout=Horizontal Flexible, format=smallAirTop) > TemplateStamp(template=")).output(mark("name", "firstUpperCase")).output(literal("EmbeddedTemplate) content\n\nTemplate(layout=Vertical Flexible) ")).output(mark("name", "firstUpperCase")).output(literal("EmbeddedTemplate as Relative(height=100%)\n    ")).output(mark("toolbar", "navigableExpanded")).output(literal("\n    Block(layout=Horizontal, format=bottomBordered bottomSpaced leftSpaced middleTopSpaced) toolbar\n        Block(layout=Vertical CenterJustified Flexible)\n            Block(layout=Horizontal)\n                ")).output(mark("toolbar", "editable")).output(literal("\n        Block(layout=Horizontal EndJustified)\n            ")).output(mark("toolbar", "navigable")).output(literal("\n\n    Block(layout=Vertical Flexible) content as Relative(height=100%)\n        Block(layout=Vertical Flexible, format=spaced) previewView as Relative(height=100%) > OwnerTemplateStamp(template=\"NodeDocumentTemplate\", owner=")).output(mark("module", "firstUpperCase")).output(literal("Elements.goros) previewStamp"))
		);
	}
}