package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class IndexDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("indexdefinition"))).output(literal("dsl Konos\n\nuse Theme\n\n")).output(expression().output(mark("view").multiple("\n"))),
			rule().condition((type("view"))).output(literal("Table(itemClass=\"org.monet.space.kernel.model.NodeItem\", scrollingMark=false, pageSize=10, format=bordered) ")).output(mark("definition", "firstUpperCase")).output(mark("name", "firstUpperCase")).output(literal("Table as Selectable(multiple=false)\n    noItemsMessage = \"No hay elementos\"\n    ")).output(expression().output(mark("attribute").multiple("\n"))),
			rule().condition((type("attribute"))).output(literal("Mold\n    Heading ")).output(mark("definition", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Table")).output(mark("name", "firstUpperCase")).output(literal("Heading > Text(value=\"")).output(mark("label")).output(literal("\")\n    Item(height=25px,width=")).output(mark("width")).output(literal("%) ")).output(mark("definition", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Table")).output(mark("name", "firstUpperCase")).output(literal("Item > ")).output(mark("type", "firstUpperCase")).output(expression().output(literal("(value=\"")).output(mark("value")).output(literal("\")"))).output(literal(" ")).output(mark("name", "firstLowerCase"))
		);
	}
}