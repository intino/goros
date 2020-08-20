package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.konos.TranslationsTemplate;
import io.intino.goros.builder.renderers.templates.konos.UITemplate;
import io.intino.itrules.FrameBuilder;

import java.io.File;

public class TranslationsRenderer extends Renderer {

	public TranslationsRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeFrame(file(), new TranslationsTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame();
		result.add("translations");
		return result;
	}

	private File file() {
		return new File(modernization.sourceUiDirectory() + File.separator + "Translations.konos");
	}

}