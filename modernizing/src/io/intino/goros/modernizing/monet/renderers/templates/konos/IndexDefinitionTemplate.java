package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class IndexDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("indexdefinition")).output(literal("dsl Konos\n\nuse Theme\n\n")).output(expression().output(placeholder("view").multiple("\n"))));
		rules.add(rule().condition(allTypes("view")).output(literal("Table(itemClass=\"org.monet.space.kernel.model.NodeItem\", scrollingMark=false, pageSize=15, format=bordered) ")).output(placeholder("definition", "firstUpperCase")).output(placeholder("name", "firstUpperCase")).output(literal("Table as Selectable(multiple=false)\n    noItemsMessage = \"No hay elementos\"\n    ")).output(expression().output(placeholder("attribute").multiple("\n"))));
		rules.add(rule().condition(allTypes("attribute")).output(literal("Mold\n    Heading ")).output(placeholder("definition", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Table")).output(placeholder("name", "firstUpperCase")).output(literal("Heading > Text(value=\"")).output(placeholder("label")).output(literal("\")\n    Item(height=25px,width=")).output(placeholder("width")).output(literal("%) ")).output(placeholder("definition", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Table")).output(placeholder("name", "firstUpperCase")).output(literal("Item > ")).output(placeholder("type", "firstUpperCase")).output(literal("(visible=true")).output(expression().output(literal(", value=\"")).output(placeholder("value")).output(literal("\""))).output(expression().output(literal(", cropWithEllipsis=")).output(placeholder("cropWithEllipsis")).output(literal(" Chars"))).output(literal(") ")).output(placeholder("name", "firstLowerCase")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}