package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class DesktopDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("desktopdefinition"))).output(literal("dsl Konos\n\nuse UI\nuse Theme\n\nTemplate(layout=Vertical Flexible, format=smallAir) ")).output(mark("name", "firstUpperCase")).output(literal("Template\n    Block(layout=Horizontal, format=headerSpaced) header\n        Block(layout=Vertical Flexible)\n            Block(layout=Horizontal)\n                Text(value=\"")).output(mark("label")).output(literal("\", format=h4 bold) label\n            Text(format=body2 grey) description\n\n    Block(layout=Horizontal, format=headerSpaced)\n        Block(layout=Horizontal Flexible, format=middleAirTop middleAirBottom) toolbar\n            Block(layout=Vertical CenterJustified Flexible)\n                Block(layout=Horizontal)\n                    ")).output(mark("toolbar", "editable")).output(literal("\n\n\tBlock(layout=Vertical CenterCenter Flexible, visible=true) loading > Spinner\n    Block(layout=Vertical Wrap, visible=false) labels\n        ")).output(expression().output(mark("view").multiple("\n"))),
			rule().condition((type("nodeview"))).output(literal("Block(layout=Vertical Flexible, format=desktopBlockStyle)\n    Text(value=\"")).output(mark("label")).output(literal("\", format=h4 airBottom)\n    ")).output(mark("show")),
			rule().condition((type("show"))).output(expression().output(mark("item").multiple("\n"))),
			rule().condition((type("item"))).output(literal("Block(format=doubleAirBottom, visible=false) ")).output(mark("name", "firstLowerCase")).output(literal("\n    Link(title=\"")).output(mark("label")).output(literal("\", format=h5) ")).output(mark("name", "firstLowerCase")).output(literal("Link as Action Addressable(")).output(mark("module", "firstUpperCase")).output(literal("Elements.")).output(mark("resourceType")).output(literal(")\n    Text(value=\"")).output(mark("description")).output(literal("\", format=description)")),
			rule().condition((type("toolbar")), (trigger("editable"))).output(expression().output(mark("operationsGroup"))).output(literal("\n")).output(expression().output(mark("operation").multiple("\n"))),
			rule().condition((type("toolbar")), (trigger("editablerefreshcall"))).output(expression().output(mark("operationsGroup", "editableInitCall"))).output(literal("\n")).output(expression().output(mark("operation", "editableRefreshCall").multiple("\n")))
		);
	}
}