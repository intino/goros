package io.intino.goros.printers.templates;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class CsvNodeTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("node"))).output(mark("content")),
			rule().condition((allTypes("content","empty"))),
			rule().condition((type("content"))).output(mark("header")).output(literal("\n")).output(mark("references")),
			rule().condition((type("header"))).output(expression().output(mark("reference", "header").multiple("\n"))),
			rule().condition((type("references"))).output(expression().output(mark("reference").multiple("\n"))),
			rule().condition((type("reference")), (trigger("header"))).output(expression().output(mark("attribute", "header").multiple(";"))),
			rule().condition((type("reference"))).output(expression().output(mark("attribute").multiple(";"))),
			rule().condition((type("attribute")), (trigger("header"))).output(mark("label")),
			rule().condition((type("attribute"))).output(mark("value")),
			rule().condition((type("comma"))).output(literal(";"))
		);
	}
}