package io.intino.goros.builder.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class TranslationsTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("translations"))).output(literal("dsl Konos\n\nTranslator(language = Spanish)"))
		);
	}
}