package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.BoxTemplate;
import io.intino.goros.builder.renderers.templates.tara.GraphTemplate;
import io.intino.goros.builder.util.StringUtil;
import io.intino.itrules.FrameBuilder;

import java.io.File;

public class GraphRenderer extends Renderer {

	public GraphRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame().add("graph");
		writeFrame(file(), new GraphTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		return baseFrame().add("box");
	}

	private File file() {
		return new File(modernization.sourceGraphDirectory() + File.separator + StringUtil.firstUpperCase(modernization.moduleName()) + "Graph.java");
	}

}