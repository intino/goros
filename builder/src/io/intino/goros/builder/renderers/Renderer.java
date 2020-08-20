package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;

public abstract class Renderer {
	protected final Dictionary dictionary;
	protected final Modernization modernization;

	public Renderer(Dictionary dictionary, Modernization modernization) {
		this.dictionary = dictionary;
		this.modernization = modernization;
	}

	public abstract void write();

	protected FrameBuilder baseFrame() {
		return new FrameBuilder().add("package", modernization.projectPackage()).add("module", modernization.moduleName());
	}

	protected void writeFrame(File file, String content) {
		try {
			file.getParentFile().mkdirs();
			Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			Logger.getGlobal().severe(e.getMessage());
		}
	}

	protected String javaPackage() {
		return modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "templates" + File.separator;
	}

	protected String konosPackage() {
		return modernization.sourceUiDirectory() + File.separator + "definitions" + File.separator;
	}

	protected String nameOf(Definition definition) {
		return RendererHelper.nameOf(definition);
	}

	protected String nameOf(IndexDefinitionBase.IndexViewProperty viewProperty) {
		return RendererHelper.nameOf(viewProperty);
	}

	protected String nameOf(NodeViewProperty viewProperty) {
		return RendererHelper.nameOf(viewProperty);
	}

	protected String normalize(String name) {
		return RendererHelper.normalize(name);
	}

	protected String nameOf(ViewProperty viewProperty, String label) {
		return RendererHelper.nameOf(viewProperty, label);
	}

	protected String typeOf(NodeViewProperty viewProperty) {
		return RendererHelper.typeOf(viewProperty);
	}

	protected String typeOf(SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty) {
		return RendererHelper.typeOf(showProperty);
	}

	protected String typeOf(ContainerDefinitionBase.ViewProperty.ShowProperty showProperty) {
		return RendererHelper.typeOf(showProperty);
	}

	protected String typeOf(FormViewProperty.ShowProperty showProperty) {
		return RendererHelper.typeOf(showProperty);
	}

}
