package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class DesktopDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("desktopdefinition"))).output(literal("dsl Konos\n\nuse UI\nuse Theme\n\nTemplate(layout=Vertical Flexible, format=smallAir) ")).output(mark("name", "firstUpperCase")).output(literal("Template\n    Block(layout=Horizontal, format=bordered spaced) header\n        Block(layout=Vertical Flexible)\n            Block(layout=Horizontal)\n                Text(value=\"")).output(mark("label")).output(literal("\", format=h4 bold) label\n\n    Block(layout=Vertical Wrap)\n        ")).output(expression().output(mark("view").multiple("\n"))),
			rule().condition((type("nodeview"))).output(literal("Block(layout=Vertical Flexible, format=smallAirTop spaced desktopBlockStyle)\n    Text(value=\"")).output(mark("label")).output(literal("\", format=h4 airBottom)\n    ")).output(mark("show")),
			rule().condition((type("show"))).output(expression().output(mark("item").multiple("\n"))),
			rule().condition((type("item"))).output(literal("Block(format=doubleAirBottom, visible=false) ")).output(mark("name", "firstLowerCase")).output(literal("\n    Link(title=\"")).output(mark("label")).output(literal("\", format=h5) ")).output(mark("name", "firstLowerCase")).output(literal("Link as Action Addressable(")).output(mark("module", "firstUpperCase")).output(literal("Elements.")).output(mark("resourceType")).output(literal(")\n    Text(value=\"")).output(mark("description")).output(literal("\", format=description)"))
		);
	}
}