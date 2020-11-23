package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class DesktopDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("desktopdefinition"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("module", "firstUpperCase")).output(literal("Box;\nimport org.monet.space.kernel.model.Source;\nimport org.monet.space.kernel.model.Node;\nimport io.intino.goros.unit.util.AccountHelper;\nimport io.intino.goros.unit.util.NodeHelper;\n\npublic class ")).output(mark("name", "firstUpperCase")).output(literal("Template extends Abstract")).output(mark("name", "firstUpperCase")).output(literal("Template<")).output(mark("module", "firstUpperCase")).output(literal("Box> {\n\n    public ")).output(mark("name", "firstUpperCase")).output(literal("Template(")).output(mark("module", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        refreshLabels();\n    }\n\n    private void refreshLabels() {\n        ")).output(expression().output(mark("view", "refreshCall").multiple("\n"))).output(literal("\n    }\n\n    ")).output(expression().output(mark("view", "refreshMethod").multiple("\n"))).output(literal("\n}")),
			rule().condition((type("nodeview")), (trigger("refreshcall"))).output(mark("show", "refreshCall")),
			rule().condition((type("nodeview")), (trigger("refreshmethod"))).output(mark("show", "refreshMethod")),
			rule().condition((type("show")), (trigger("refreshcall"))).output(expression().output(mark("item", "refreshCall").multiple("\n"))),
			rule().condition((type("show")), (trigger("refreshmethod"))).output(expression().output(mark("item", "refreshMethod").multiple("\n"))),
			rule().condition((type("item")), (trigger("refreshcall"))).output(literal("refresh")).output(mark("name", "firstUpperCase")).output(literal("();")),
			rule().condition((allTypes("item","thesaurus")), (trigger("refreshmethod"))).output(literal("private void refresh")).output(mark("name", "firstUpperCase")).output(literal("() {\n    Source<?> source = io.intino.goros.unit.util.SourceHelper.locateSource(\"")).output(mark("code")).output(literal("\");\n    ")).output(mark("name", "firstLowerCase")).output(literal(".visible(source != null);\n    if (source == null) return;\n    ")).output(mark("name", "firstLowerCase")).output(literal("Link.address(path -> path.replace(\":name\", \"")).output(mark("name", "lowerCase")).output(literal("\"));\n    ")).output(mark("name", "firstLowerCase")).output(literal("Link.title(source.getLabel());\n}")),
			rule().condition((type("item")), (trigger("refreshmethod"))).output(literal("private void refresh")).output(mark("name", "firstUpperCase")).output(literal("() {\n    Node node = io.intino.goros.unit.util.NodeHelper.singleton(\"")).output(mark("code")).output(literal("\");\n    ")).output(mark("name", "firstLowerCase")).output(literal(".visible(node != null && AccountHelper.hasRoles(node.getDefinition(), session()));\n    if (node == null) return;\n    ")).output(mark("name", "firstLowerCase")).output(literal("Link.address(path -> path.replace(\":name\", \"")).output(mark("name", "lowerCase")).output(literal("\"));\n    ")).output(mark("name", "firstLowerCase")).output(literal("Link.title(node.getLabel());\n}"))
		);
	}
}