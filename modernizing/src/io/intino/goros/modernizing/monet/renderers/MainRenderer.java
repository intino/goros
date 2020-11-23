package io.intino.goros.modernizing.monet.renderers;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.templates.java.MainTemplate;
import io.intino.itrules.FrameBuilder;

import java.io.File;

public class MainRenderer extends Renderer {

	public MainRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		File file = file();
		if (file.exists()) return;
		writeFrame(file, new MainTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		return baseFrame().add("main");
	}

	private File file() {
		return new File(modernization.sourceBoxDirectory() + File.separator + "Main.java");
	}

}