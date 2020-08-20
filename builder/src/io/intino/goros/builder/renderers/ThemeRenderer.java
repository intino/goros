package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.konos.ThemeTemplate;
import io.intino.goros.builder.renderers.templates.konos.UITemplate;
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