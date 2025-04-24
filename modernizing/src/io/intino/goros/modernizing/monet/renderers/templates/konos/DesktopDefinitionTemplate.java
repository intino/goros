package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class DesktopDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("desktopdefinition")).output(literal("dsl Konos\n\nuse UI\nuse Theme\n\nTemplate(layout=Vertical Flexible, format=smallAir) ")).output(placeholder("name", "firstUpperCase")).output(literal("Template\n    Block(layout=Horizontal, format=headerSpaced) header\n        Block(layout=Vertical Flexible)\n            Block(layout=Horizontal)\n                Text(value=\"")).output(placeholder("label")).output(literal("\", format=h4 bold) label\n            Text(format=body2 grey) description\n\n    Block(layout=Horizontal, format=headerSpaced)\n        Block(layout=Horizontal Flexible, format=middleAirTop middleAirBottom) toolbar\n            Block(layout=Vertical CenterJustified Flexible)\n                Block(layout=Horizontal)\n                    ")).output(placeholder("toolbar", "editable")).output(literal("\n\n\tBlock(layout=Vertical CenterCenter Flexible, visible=true) loading > Spinner\n    Block(layout=Vertical Wrap, visible=false) labels\n        ")).output(expression().output(placeholder("view").multiple("\n"))));
		rules.add(rule().condition(allTypes("nodeview")).output(literal("Block(layout=Vertical Flexible, format=desktopBlockStyle)\n    Text(value=\"")).output(placeholder("label")).output(literal("\", format=h4 airBottom)\n    ")).output(placeholder("show")));
		rules.add(rule().condition(allTypes("show")).output(expression().output(placeholder("item").multiple("\n"))));
		rules.add(rule().condition(allTypes("item")).output(literal("Block(format=doubleAirBottom, visible=false) ")).output(placeholder("name", "firstLowerCase")).output(literal("\n    Link(title=\"")).output(placeholder("label")).output(literal("\", format=h5) ")).output(placeholder("name", "firstLowerCase")).output(literal("Link as Action Addressable(")).output(placeholder("module", "firstUpperCase")).output(literal("Elements.")).output(placeholder("resourceType")).output(literal(")\n    Text(value=\"")).output(placeholder("description")).output(literal("\", format=description)")));
		rules.add(rule().condition(all(allTypes("toolbar"), trigger("editable"))).output(expression().output(placeholder("operationsGroup"))).output(literal("\n")).output(expression().output(placeholder("operation").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("toolbar"), trigger("editablerefreshcall"))).output(expression().output(placeholder("operationsGroup", "editableInitCall"))).output(literal("\n")).output(expression().output(placeholder("operation", "editableRefreshCall").multiple("\n"))));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}