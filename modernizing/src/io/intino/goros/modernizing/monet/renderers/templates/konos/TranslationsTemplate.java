package io.intino.goros.modernizing.monet.renderers.templates.konos;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class TranslationsTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("translations")).output(literal("dsl Konos\n\nTranslator(language = Spanish)\n\tTranslation(\"Operation executed\", \"Operación ejecutada correctamente\")\n    Translation(\"Operation canceled\", \"Operación cancelada\")\n    Translation(\"true\", \"Sí\")\n    Translation(\"false\", \"No\")\n    Translation(\"Address to search\", \"Dirección a buscar\")\n    Translation(\"Search\", \"Buscar\")\n    Translation(\"Address not found\", \"Dirección no encontrada\")")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}