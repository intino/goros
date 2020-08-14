package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.Definition;

import java.io.File;

public abstract class DefinitionRenderer<D extends Definition> extends Renderer {
	private final D definition;

	public DefinitionRenderer(Modernization modernization, D definition) {
		super(modernization);
		this.definition = definition;
	}

	public D definition() {
		return definition;
	}

	public void write() {
		FrameBuilder builder = buildFrame();
		writeJava(builder);
		writeKonos(builder);
	}

	protected abstract FrameBuilder buildFrame();
	protected abstract Template konosTemplate();
	protected abstract Template javaTemplate();

	protected FrameBuilder baseFrame() {
		FrameBuilder result = super.baseFrame().add("definition");
		if (definition.getType() != null) result.add(definition.getType().name());
		return result;
	}

	private void writeJava(FrameBuilder builder) {
		File file = new File(javaPackage() + nameOf(definition) + "Template.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	private void writeKonos(FrameBuilder builder) {
		File file = new File(konosPackage() + nameOf(definition) + ".konos");
		writeFrame(file, konosTemplate().render(builder.toFrame()));
	}

	private String konosPackage() {
		return modernization.sourceUiDirectory() + File.separator + "definitions" + File.separator;
	}

	private String javaPackage() {
		return modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "templates" + File.separator;
	}

	private String nameOf(Definition definition) {
		String name = definition.getName();
		return name.contains(".") ? name.substring(name.lastIndexOf(".")+1) : name;
	}
}
