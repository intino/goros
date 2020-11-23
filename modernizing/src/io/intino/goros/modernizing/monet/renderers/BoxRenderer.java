package io.intino.goros.modernizing.monet.renderers;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.templates.java.BoxTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.goros.modernizing.monet.util.StringUtil;

import java.io.File;

public class BoxRenderer extends Renderer {

	public BoxRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		File file = file();
		if (file.exists()) return;
		writeFrame(file, new BoxTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		return baseFrame().add("box");
	}

	private File file() {
		return new File(modernization.sourceBoxDirectory() + File.separator + StringUtil.firstUpperCase(modernization.moduleName()) + "Box.java");
	}

}