package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class DesktopDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("desktopdefinition")).output(literal("package ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box;\nimport org.monet.space.kernel.model.Source;\nimport org.monet.space.kernel.model.Node;\nimport io.intino.goros.unit.util.AccountHelper;\nimport io.intino.goros.unit.util.LayerHelper;\n\nimport java.util.List;\n\npublic class ")).output(placeholder("name", "firstUpperCase")).output(literal("Template extends Abstract")).output(placeholder("name", "firstUpperCase")).output(literal("Template<")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box> {\n    private Node node;\n    private boolean readonly = false;\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("Template(")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public void open(String code, boolean readonly) {\n        node(LayerHelper.nodeLayer().locateNode(code));\n        readonly(readonly);\n        refresh();\n    }\n\n    public void open(String id, String view, boolean readonly) {\n        node(LayerHelper.nodeLayer().loadNode(id));\n        readonly(readonly);\n        refresh();\n    }\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("Template node(Node node) {\n        this.node = node;\n        return this;\n    }\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("Template readonly(boolean value) {\n        this.readonly = value;\n        return this;\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        initToolbar();\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        refreshToolbar();\n        refreshLabels();\n    }\n\n    private void initToolbar() {\n        ")).output(expression().output(placeholder("toolbar", "editableInitCall"))).output(literal("\n    }\n\n    private void refreshToolbar() {\n        ")).output(expression().output(placeholder("toolbar", "editableRefreshCall"))).output(literal("\n    }\n\n    private void refreshLabels() {\n        loading.visible(true);\n        labels.visible(false);\n        ")).output(expression().output(placeholder("view", "refreshCall").multiple("\n"))).output(literal("\n        loading.visible(false);\n        labels.visible(true);\n    }\n\n    ")).output(expression().output(placeholder("view", "refreshMethod").multiple("\n"))).output(literal("\n    ")).output(expression().output(placeholder("toolbar", "editableMethods"))).output(literal("\n}")));
		rules.add(rule().condition(all(allTypes("nodeview"), trigger("refreshcall"))).output(placeholder("show", "refreshCall")));
		rules.add(rule().condition(all(allTypes("nodeview"), trigger("refreshmethod"))).output(placeholder("show", "refreshMethod")));
		rules.add(rule().condition(all(allTypes("show"), trigger("refreshcall"))).output(expression().output(placeholder("item", "refreshCall").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("show"), trigger("refreshmethod"))).output(expression().output(placeholder("item", "refreshMethod").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("item"), trigger("refreshcall"))).output(literal("refresh")).output(placeholder("name", "firstUpperCase")).output(literal("();")));
		rules.add(rule().condition(all(allTypes("item", "thesaurus"), trigger("refreshmethod"))).output(literal("private void refresh")).output(placeholder("name", "firstUpperCase")).output(literal("() {\n    Source<?> source = io.intino.goros.unit.util.SourceHelper.locateSource(\"")).output(placeholder("code")).output(literal("\");\n    ")).output(placeholder("name", "firstLowerCase")).output(literal(".visible(source != null);\n    if (source == null) return;\n    ")).output(placeholder("name", "firstLowerCase")).output(literal("Link.address(path -> path.replace(\":name\", \"")).output(placeholder("name", "lowerCase")).output(literal("\"));\n    ")).output(placeholder("name", "firstLowerCase")).output(literal("Link.title(source.getLabel());\n}")));
		rules.add(rule().condition(all(allTypes("item"), trigger("refreshmethod"))).output(literal("private void refresh")).output(placeholder("name", "firstUpperCase")).output(literal("() {\n    Node node = io.intino.goros.unit.util.NodeHelper.singleton(\"")).output(placeholder("code")).output(literal("\");\n    ")).output(placeholder("name", "firstLowerCase")).output(literal(".visible(node != null && AccountHelper.hasRoles(node.getDefinition(), session()));\n    if (node == null) return;\n    ")).output(placeholder("name", "firstLowerCase")).output(literal("Link.address(path -> path.replace(\":name\", \"")).output(placeholder("name", "lowerCase")).output(literal("\").replace(\":mode\", readonly ? \"default\" : \"edit\"));\n    ")).output(placeholder("name", "firstLowerCase")).output(literal("Link.title(node.getLabel());\n}")));
		rules.add(rule().condition(all(allTypes("toolbar"), trigger("editableinitcall"))).output(expression().output(placeholder("operationsGroup", "editableInitCall"))).output(literal("\n")).output(expression().output(placeholder("operation", "editableInitCall").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("operation"), trigger("executemethodcall"))).output(literal("if (option.equals(\"")).output(placeholder("label")).output(literal("\")) io.intino.goros.unit.util.NodeHelper.executeOperation(session(), operaciones, node, \"")).output(placeholder("name")).output(literal("\", translate(\"Operation executed\"), box().routeManager().routeDispatcher());")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}