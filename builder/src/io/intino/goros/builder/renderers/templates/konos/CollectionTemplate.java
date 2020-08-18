package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class CollectionTemplate extends Template {

	@Override
	protected RuleSet ruleSet() {
		RuleSet result = new RuleSet();
		new CollectionDefinitionTemplate().ruleSet().forEach(result::add);
		new NodeDefinitionTemplate().ruleSet().forEach(result::add);
		return result;
	}

}