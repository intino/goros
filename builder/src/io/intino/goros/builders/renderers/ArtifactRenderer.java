package io.intino.goros.builders.renderers;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import io.intino.goros.builders.renderers.templates.konos.ArtifactTemplate;

import java.io.File;

public class ArtifactRenderer extends Renderer {

	public ArtifactRenderer(Dictionary dictionary, Modernization modernization) {
		super(dictionary, modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		File file = file();
		if (file.exists()) return;
		writeFrame(file, new ArtifactTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		return baseFrame().add("artifact");
	}

	private File file() {
		return new File(modernization.moduleDirectory() + File.separator + "artifact.legio");
	}

}