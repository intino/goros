package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class IndexTemplate extends Template {

	@Override
	protected RuleSet ruleSet() {
		RuleSet result = new RuleSet();
		new IndexDefinitionTemplate().ruleSet().forEach(result::add);
		new NodeDefinitionTemplate().ruleSet().forEach(result::add);
		return result;
	}

}