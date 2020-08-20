package io.intino.goros.builder.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class SetTemplate extends Template {

	@Override
	protected RuleSet ruleSet() {
		RuleSet result = new RuleSet();
		new SetDefinitionTemplate().ruleSet().forEach(result::add);
		new NodeDefinitionTemplate().ruleSet().forEach(result::add);
		return result;
	}

}