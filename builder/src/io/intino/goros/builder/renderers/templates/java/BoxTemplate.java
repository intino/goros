package io.intino.goros.builder.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class BoxTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("box"))).output(literal("package ")).output(mark("package")).output(literal(".box;\n\nimport ")).output(mark("package")).output(literal(".graph.")).output(mark("module", "firstUpperCase")).output(literal("Graph;\nimport io.intino.alexandria.core.Box;\nimport io.intino.alexandria.ui.services.AuthService;\nimport io.intino.magritte.framework.Graph;\nimport org.siani.goros.box.GorosBox;\nimport org.siani.goros.box.listeners.GorosNotifier;\nimport org.siani.goros.graph.BusinessUnit;\nimport org.siani.goros.graph.GorosGraph;\n\nimport java.net.URL;\n\npublic class ")).output(mark("module", "firstUpperCase")).output(literal("Box extends AbstractBox {\n    private ")).output(mark("module", "firstUpperCase")).output(literal("Graph graph;\n\n    public ")).output(mark("module", "firstUpperCase")).output(literal("Box(String[] args) {\n        super(args);\n    }\n\n    public ")).output(mark("module", "firstUpperCase")).output(literal("Box(")).output(mark("module", "firstUpperCase")).output(literal("Configuration configuration) {\n        super(configuration);\n    }\n\n    @Override\n    public io.intino.alexandria.core.Box put(Object o) {\n        super.put(o);\n        if (o instanceof Graph) graph = ((Graph) o).as(")).output(mark("module", "firstUpperCase")).output(literal("Graph.class);\n        return this;\n    }\n\n    public void beforeStart() {\n    }\n\n    public void afterStart() {\n    }\n\n    public void beforeStop() {\n    }\n\n    public void afterStop() {\n    }\n\n    public GorosBox goros() {\n        return ((GorosBox)owner);\n    }\n\n    public CoordinacionBox open(String businessUnit) {\n        open(graph.a$(GorosGraph.class).businessUnitList().stream().filter(b -> b.name$().equals(businessUnit)).findFirst().orElse(null));\n        return this;\n    }\n\n    public Box open(BusinessUnit businessUnit) {\n        goros().open(businessUnit);\n        return this;\n    }\n\n    public GorosNotifier notifier() {\n        return ((GorosBox)owner()).notifier();\n    }\n\n    @Override\n    protected AuthService authService(URL authServiceUrl) {\n        return null;\n    }\n}"))
		);
	}
}