package io.intino.goros.builders.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class DefaultTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("definition")))
		);
	}
}