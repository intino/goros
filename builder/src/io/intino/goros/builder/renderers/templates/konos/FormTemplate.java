package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class FormTemplate extends Template {

	@Override
	protected RuleSet ruleSet() {
		RuleSet result = new RuleSet();
		new NodeViewTemplate().ruleSet().forEach(result::add);
		new FormDefinitionTemplate().ruleSet().forEach(result::add);
		return result;
	}

}