package io.intino.goros.builders.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class FormTemplate extends Template {

	@Override
	protected RuleSet ruleSet() {
		RuleSet result = new RuleSet();
		new FormDefinitionTemplate().ruleSet().forEach(result::add);
		new NodeDefinitionTemplate().ruleSet().forEach(result::add);
		return result;
	}

}