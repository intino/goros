package io.intino.goros.builder.renderers.templates.tara;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class GraphTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("graph"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".graph;\n\nimport io.intino.magritte.framework.Graph;\n\npublic class ")).output(mark("module", "firstUpperCase")).output(literal("Graph extends ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".graph.AbstractGraph {\n\n\tpublic ")).output(mark("module", "firstUpperCase")).output(literal("Graph(Graph graph) {\n\t\tsuper(graph);\n\t}\n\n\tpublic ")).output(mark("module", "firstUpperCase")).output(literal("Graph(io.intino.magritte.framework.Graph graph, ")).output(mark("module", "firstUpperCase")).output(literal("Graph wrapper) {\n\t\tsuper(graph, wrapper);\n\t}\n}"))
		);
	}
}