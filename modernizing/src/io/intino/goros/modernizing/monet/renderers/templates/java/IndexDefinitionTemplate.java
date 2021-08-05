package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class IndexDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("view"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.tables;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("boxName", "firstUpperCase")).output(literal("Box;\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.rows.")).output(mark("definition", "firstUpperCase")).output(mark("name", "firstUpperCase")).output(literal("TableRow;\nimport io.intino.alexandria.ui.displays.events.AddItemEvent;\nimport org.monet.space.kernel.model.NodeItem;\n\npublic class ")).output(mark("definition", "firstUpperCase")).output(mark("name", "firstUpperCase")).output(literal("Table extends Abstract")).output(mark("definition", "firstUpperCase")).output(mark("name", "firstUpperCase")).output(literal("Table<")).output(mark("boxName", "firstUpperCase")).output(literal("Box> {\n\n    public ")).output(mark("definition", "firstUpperCase")).output(mark("name", "firstUpperCase")).output(literal("Table(")).output(mark("boxName", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        onAddItem(this::fillItem);\n    }\n\n    private void fillItem(AddItemEvent e) {\n        NodeItem item = e.item();\n        ")).output(mark("definition", "firstUpperCase")).output(mark("name", "firstUpperCase")).output(literal("TableRow row = e.component();\n        ")).output(expression().output(mark("attribute").multiple("\n"))).output(literal("\n    }\n}")),
			rule().condition((allTypes("attribute","date"))),
			rule().condition((allTypes("attribute","picture"))),
			rule().condition((allTypes("attribute","real"))).output(literal("row.")).output(mark("definition", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Table")).output(mark("name", "firstUpperCase")).output(literal("Item.")).output(mark("name", "firstLowerCase")).output(literal(".value(io.intino.goros.unit.util.NodeHelper.numberOf(item, \"")).output(mark("code")).output(literal("\"));")),
			rule().condition((allTypes("attribute","integer"))).output(literal("row.")).output(mark("definition", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Table")).output(mark("name", "firstUpperCase")).output(literal("Item.")).output(mark("name", "firstLowerCase")).output(literal(".value(io.intino.goros.unit.util.NodeHelper.numberOf(item, \"")).output(mark("code")).output(literal("\"));")),
			rule().condition((type("attribute"))).output(literal("row.")).output(mark("definition", "firstLowerCase")).output(mark("view", "firstUpperCase")).output(literal("Table")).output(mark("name", "firstUpperCase")).output(literal("Item.")).output(mark("name", "firstLowerCase")).output(literal(".value(io.intino.goros.unit.util.NodeHelper.valueOf(item, \"")).output(mark("code")).output(literal("\"));"))
		);
	}
}