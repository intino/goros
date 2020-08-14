package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.itrules.FrameBuilder;
import io.intino.goros.builder.renderers.templates.konos.ArtifactTemplate;

import java.io.File;

public class ArtifactRenderer extends Renderer {

	public ArtifactRenderer(Modernization modernization) {
		super(modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeFrame(file(), new ArtifactTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame();
		result.add("artifact");
		result.add("package", modernization.projectPackage());
		return result;
	}

	private File file() {
		return new File(modernization.moduleDirectory() + File.separator + "artifact.legio");
	}

}