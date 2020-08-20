package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.MainTemplate;
import io.intino.itrules.FrameBuilder;

import java.io.File;

public class MainRenderer extends Renderer {

	public MainRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeFrame(file(), new MainTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		return baseFrame().add("main");
	}

	private File file() {
		return new File(modernization.sourceBoxDirectory() + File.separator + "Main.java");
	}

}