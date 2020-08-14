package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.renderers.templates.java.MainTemplate;
import io.intino.itrules.FrameBuilder;

import java.io.File;

public class MainRenderer extends Renderer {

	public MainRenderer(Modernization modernization) {
		super(modernization);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeFrame(file(), new MainTemplate().render(builder.toFrame()));
	}

	private FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame();
		result.add("main");
		result.add("package", modernization.projectPackage());
		result.add("module", modernization.moduleName());
		return result;
	}

	private File file() {
		return new File(modernization.sourceBoxDirectory() + File.separator + "Main.java");
	}

}