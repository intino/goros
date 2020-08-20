package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import io.intino.goros.builder.renderers.templates.java.BoxTemplate;
import io.intino.goros.builder.util.StringUtil;

import java.io.File;

public class BoxRenderer extends Renderer {

	public BoxRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeFrame(file(), new BoxTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		return baseFrame().add("box");
	}

	private File file() {
		return new File(modernization.sourceBoxDirectory() + File.separator + StringUtil.firstUpperCase(modernization.moduleName()) + "Box.java");
	}

}