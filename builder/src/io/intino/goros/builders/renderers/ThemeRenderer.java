package io.intino.goros.builders.renderers;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.goros.builders.renderers.templates.konos.ThemeTemplate;
import io.intino.itrules.FrameBuilder;

import java.io.File;

public class ThemeRenderer extends Renderer {

	public ThemeRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeFrame(file(), new ThemeTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame();
		result.add("theme");
		return result;
	}

	private File file() {
		return new File(modernization.sourceUiDirectory() + File.separator + "Theme.konos");
	}

}