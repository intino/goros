package io.intino.goros.unit.printers.templates;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class CsvTaskListTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("tasklist")).output(placeholder("content")));
		rules.add(rule().condition(allTypes("content", "empty")));
		rules.add(rule().condition(allTypes("content")).output(placeholder("header")).output(literal("\n")).output(placeholder("references")));
		rules.add(rule().condition(allTypes("header")).output(expression().output(placeholder("reference", "header").multiple("\n"))));
		rules.add(rule().condition(allTypes("references")).output(expression().output(placeholder("reference").multiple("\n"))));
		rules.add(rule().condition(all(allTypes("reference"), trigger("header"))).output(expression().output(placeholder("attribute", "header").multiple(";"))));
		rules.add(rule().condition(allTypes("reference")).output(expression().output(placeholder("attribute").multiple(";"))));
		rules.add(rule().condition(all(allTypes("attribute"), trigger("header"))).output(placeholder("label")));
		rules.add(rule().condition(allTypes("attribute")).output(placeholder("value")));
		rules.add(rule().condition(allTypes("comma")).output(literal(";")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}