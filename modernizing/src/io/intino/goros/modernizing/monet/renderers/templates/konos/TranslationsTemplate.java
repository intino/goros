package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class TranslationsTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("translations"))).output(literal("dsl Konos\n\nTranslator(language = Spanish)\n\tTranslation(\"Operation executed\", \"Operación ejecutada correctamente\")\n    Translation(\"Operation canceled\", \"Operación cancelada\")\n    Translation(\"true\", \"Sí\")\n    Translation(\"false\", \"No\")\n    Translation(\"Address to search\", \"Dirección a buscar\")\n    Translation(\"Search\", \"Buscar\")\n    Translation(\"Address not found\", \"Dirección no encontrada\")"))
		);
	}
}