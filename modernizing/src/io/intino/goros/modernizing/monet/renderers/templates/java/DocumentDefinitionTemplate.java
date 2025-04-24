package io.intino.goros.modernizing.monet.renderers.templates.java;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class DocumentDefinitionTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("documentdefinition", "embedded")).output(literal("package ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(placeholder("package")).output(literal(".")).output(placeholder("module", "lowerCase")).output(literal(".box.")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box;\nimport org.monet.space.kernel.model.Node;\nimport io.intino.goros.unit.util.DisplayHelper;\n\nimport java.util.List;\n\npublic class ")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate extends Abstract")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate<")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box> {\n    private Node node;\n    private boolean readonly = false;\n    private io.intino.goros.unit.box.ui.ViewMode viewMode;\n    ")).output(expression().output(placeholder("toolbar", "editableDeclaration"))).output(literal("\n    ")).output(expression().output(placeholder("toolbar", "navigableDeclaration"))).output(literal("\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate(")).output(placeholder("boxName", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate node(Node node) {\n        this.node = node;\n        return this;\n    }\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate readonly(boolean readonly) {\n        this.readonly = readonly;\n        return this;\n    }\n\n    public boolean editing() {\n        return !readonly;\n    }\n\n    public ")).output(placeholder("name", "firstUpperCase")).output(literal("EmbeddedTemplate hideToolbar() {\n        toolbar.visible(false);\n        return this;\n    }\n\n    ")).output(expression().output(placeholder("toolbar", "editableEvents"))).output(literal("\n    ")).output(expression().output(placeholder("toolbar", "navigableEvents"))).output(literal("\n    ")).output(expression().output(placeholder("toolbar", "navigableMethods"))).output(literal("\n\n    public void openView(String view) {\n        openView(view, readonly);\n    }\n\n    public void openView(String view, boolean readonly) {\n    }\n\n    public String selectedView() {\n        return null;\n    }\n\n    public void selectDefaultView() {\n    }\n\n    @Override\n    public void init() {\n        super.init();\n        initToolbar();\n        initViews();\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        refreshToolbar();\n        refreshView();\n    }\n\n    private void refreshToolbar() {\n        edit.title(readonly ? \"Editar\" : \"Finalizar edición\");\n        edit.highlight(readonly ? io.intino.alexandria.ui.displays.components.Actionable.Highlight.Outline : io.intino.alexandria.ui.displays.components.Actionable.Highlight.Fill);\n        edit.visible(node.isEditable() && !node.getDefinition().isReadonly() && !node.isLocked());\n        ")).output(expression().output(placeholder("toolbar", "editableRefreshCall"))).output(literal("\n        ")).output(expression().output(placeholder("toolbar", "navigableRefreshCall"))).output(literal("\n    }\n\n    private void refreshView() {\n        refreshPreviewView();\n    }\n\n    private void initToolbar() {\n        edit.onExecute(e -> toggleEdition());\n        ")).output(expression().output(placeholder("toolbar", "editableInitCall"))).output(literal("\n    }\n\n    private void initViews() {\n        refreshPreviewView();\n    }\n\n    private void refreshPreviewView() {\n        if (node == null) return;\n        previewView.previewStamp.node(node);\n        previewView.previewStamp.readonly(")).output(placeholder("readonly")).output(literal(" || !node.isEditable() || node.isLocked());\n        previewView.previewStamp.refresh();\n    }\n\n    private void toggleEdition() {\n        readonly(!readonly);\n        ")).output(expression().output(placeholder("toolbar", "editableCall"))).output(literal("\n        refresh();\n    }\n\n    ")).output(expression().output(placeholder("toolbar", "editableMethods"))).output(literal("\n}")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}