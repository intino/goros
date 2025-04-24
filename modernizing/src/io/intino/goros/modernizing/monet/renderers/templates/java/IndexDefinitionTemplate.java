package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class IndexDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("view")).output(literal("package ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.ui.displays.tables;\n\nimport ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box;\nimport ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.ui.displays.rows.")).output(placeholder("definition", "firstUpperCase")).output(placeholder("name", "firstUpperCase")).output(literal("TableRow;\nimport io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;\nimport org.monet.space.kernel.model.NodeItem;\n\npublic class ")).output(placeholder("definition", "firstUpperCase")).output(placeholder("name", "firstUpperCase")).output(literal("Table extends Abstract")).output(placeholder("definition", "firstUpperCase")).output(placeholder("name", "firstUpperCase")).output(literal("Table<")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box> {\n\n    public ")).output(placeholder("definition", "firstUpperCase")).output(placeholder("name", "firstUpperCase")).output(literal("Table(")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        onAddItem(this::fillItem);\n    }\n\n    private void fillItem(AddCollectionItemEvent e) {\n        NodeItem item = e.item();\n        ")).output(placeholder("definition", "firstUpperCase")).output(placeholder("name", "firstUpperCase")).output(literal("TableRow row = e.component();\n        ")).output(expression().output(placeholder("attribute").multiple("\n"))).output(literal("\n    }\n}")));
		rules.add(rule().condition(allTypes("attribute", "date")));
		rules.add(rule().condition(allTypes("attribute", "picture")));
		rules.add(rule().condition(allTypes("attribute", "real")).output(literal("row.")).output(placeholder("definition", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Table")).output(placeholder("name", "firstUpperCase")).output(literal("Item.")).output(placeholder("name", "firstLowerCase")).output(literal(".value(io.intino.goros.unit.util.NodeHelper.numberOf(item, \"")).output(placeholder("code", "lowerCase")).output(literal("\"));")));
		rules.add(rule().condition(allTypes("attribute", "integer")).output(literal("row.")).output(placeholder("definition", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Table")).output(placeholder("name", "firstUpperCase")).output(literal("Item.")).output(placeholder("name", "firstLowerCase")).output(literal(".value(io.intino.goros.unit.util.NodeHelper.numberOf(item, \"")).output(placeholder("code", "lowerCase")).output(literal("\"));")));
		rules.add(rule().condition(allTypes("attribute")).output(literal("row.")).output(placeholder("definition", "firstLowerCase")).output(placeholder("view", "firstUpperCase")).output(literal("Table")).output(placeholder("name", "firstUpperCase")).output(literal("Item.")).output(placeholder("name", "firstLowerCase")).output(literal(".value(io.intino.goros.unit.util.NodeHelper.valueOf(item, \"")).output(placeholder("code", "lowerCase")).output(literal("\"));")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}