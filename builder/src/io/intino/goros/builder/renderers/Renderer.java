package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.itrules.FrameBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;

public abstract class Renderer {
	final Modernization modernization;

	public Renderer(Modernization modernization) {
		this.modernization = modernization;
	}

	public abstract void write();

	protected FrameBuilder baseFrame() {
		return new FrameBuilder();
	}

	protected void writeFrame(File file, String content) {
		try {
			file.getParentFile().mkdirs();
			Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			Logger.getGlobal().severe(e.getMessage());
		}
	}

}
