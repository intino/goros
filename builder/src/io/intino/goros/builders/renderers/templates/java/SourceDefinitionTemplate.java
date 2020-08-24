package io.intino.goros.builders.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class SourceDefinitionTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("source"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.ui.displays.templates;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box.")).output(mark("module", "firstUpperCase")).output(literal("Box;\nimport org.monet.metamodel.SourceDefinition;\nimport org.monet.space.kernel.model.Source;\nimport io.intino.goros.util.Formatters;\nimport io.intino.goros.util.SourceHelper;\n\npublic class ")).output(mark("name", "firstUpperCase")).output(literal("Template extends Abstract")).output(mark("name", "firstUpperCase")).output(literal("Template<")).output(mark("module", "firstUpperCase")).output(literal("Box> {\n    private Source<SourceDefinition> source;\n\n    public ")).output(mark("name", "firstUpperCase")).output(literal("Template(")).output(mark("module", "firstUpperCase")).output(literal("Box box) {\n        super(box);\n    }\n\n    public ")).output(mark("name", "firstUpperCase")).output(literal("Template open(String source) {\n        return this;\n    }\n\n    @Override\n    public void refresh() {\n        super.refresh();\n        source = SourceHelper.locateSource(\"")).output(mark("code")).output(literal("\");\n        content.onTermsCountChange(this::refreshCount);\n        content.source(source);\n        content.refresh();\n    }\n\n    private void refreshCount(long countValue) {\n        count.value(Formatters.countMessage(countValue, translate(\"Term\").toLowerCase(), translate(\"Terms\").toLowerCase()));\n    }\n\n}"))
		);
	}
}