package io.intino.goros.builder.renderers.templates.java;

import io.intino.itrules.RuleSet;
import io.intino.itrules.Template;

public class MainTemplate extends Template {

	public RuleSet ruleSet() {
		return new RuleSet().add(
			rule().condition((type("main"))).output(literal("package ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".box;\n\nimport ")).output(mark("package")).output(literal(".")).output(mark("module", "lowerCase")).output(literal(".graph.")).output(mark("module", "firstUpperCase")).output(literal("Graph;\nimport io.intino.magritte.framework.Graph;\nimport io.intino.magritte.framework.stores.FileSystemStore;\nimport io.intino.magritte.io.Stash;\n\nimport java.io.File;\n\npublic class Main {\n\n    public static void main(String[] args) {\n        ")).output(mark("module", "firstUpperCase")).output(literal("Box box = new ")).output(mark("module", "firstUpperCase")).output(literal("Box(args);\n        ")).output(mark("module", "firstUpperCase")).output(literal("Graph graph = new Graph(store(box.configuration.home())).as(")).output(mark("module", "firstUpperCase")).output(literal("Graph.class);\n        box.put(graph);\n        Runtime.getRuntime().addShutdownHook(new Thread(box::stop));\n    }\n\n    private static FileSystemStore store(File datamartFolder) {\n        return new FileSystemStore(datamartFolder) {\n\n            @Override\n            public Stash stashFrom(String path) {\n                Stash stash = super.stashFrom(path);\n                if (stash != null && stash.language == null) stash.language = \"")).output(mark("module", "firstUpperCase")).output(literal("\";\n                return stash;\n            }\n\n            @Override\n            public void writeStash(Stash stash, String path) {\n                stash.language = stash.language == null || stash.language.isEmpty() ? \"")).output(mark("module", "firstUpperCase")).output(literal("\" : stash.language;\n                super.writeStash(stash, path);\n            }\n        };\n    }\n}"))
		);
	}
}