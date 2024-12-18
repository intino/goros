package io.intino.goros.modernizing.monet.renderers;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.definition.FieldRenderer;
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
		FrameBuilder result = new FrameBuilder().add("module", modernization.moduleName()).add("boxName", modernization.boxName());
		String projectPackage = modernization.projectPackage();
		if (projectPackage != null && !projectPackage.isEmpty()) result.add("package", projectPackage);
		return result;
	}

	protected void writeFrame(File file, String content) {
		try {
			file.getParentFile().mkdirs();
			Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			Logger.getGlobal().severe(e.getMessage());
		}
	}

	protected void addResourceType(Definition definition, FrameBuilder result) {
		if (definition instanceof NodeDefinition) result.add("resourceType", ((NodeDefinition)definition).isSingleton() ? "singleton" : "instance");
		else result.add("resourceType", "singleton");
	}

	protected DesktopDefinition desktopWithDefinition(Definition definition) {
		return dictionary.getDesktopDefinitionList().stream().filter(d -> d.getViewList().stream().anyMatch(v -> containsDefinition(definition, v))).findFirst().orElse(null);
	}

	protected String javaPackage() {
		return modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "templates" + File.separator;
	}

	protected String konosPackage() {
		return modernization.sourceUiDirectory() + File.separator + "definitions" + File.separator;
	}

	protected String nameOf(Definition definition) {
		return RendererHelper.nameOf(definition, dictionary.basePackage());
	}

	protected String nameOf(IndexDefinitionBase.IndexViewProperty viewProperty) {
		return RendererHelper.nameOf(viewProperty);
	}

	protected String nameOf(ProcessDefinitionBase.ViewProperty viewProperty) {
		return RendererHelper.nameOf(viewProperty);
	}

	protected String nameOf(NodeViewProperty viewProperty) {
		return RendererHelper.nameOf(viewProperty);
	}

	protected String labelOf(NodeViewProperty viewProperty) {
		return RendererHelper.labelOf(viewProperty);
	}

	protected String labelOf(ProcessDefinitionBase.ViewProperty viewProperty) {
		return RendererHelper.labelOf(viewProperty);
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

	protected String typeOf(CompositeFieldProperty.ViewProperty.ShowProperty showProperty) {
		return RendererHelper.typeOf(showProperty);
	}

	protected String clean(Object label) {
		if (label == null) return null;
		return ((String)label).replace("\n", "");
	}

	protected FieldRenderer renderer(FormDefinition formDefinition, FieldProperty fieldProperty, CompositeFieldProperty composite) {
		FieldRenderer renderer = new FieldRenderer(dictionary, modernization, fieldProperty);
		renderer.definition(formDefinition);
		renderer.parent(composite);
		return renderer;
	}

	private boolean containsDefinition(Definition definition, DesktopDefinitionBase.ViewProperty viewProperty) {
		DesktopDefinitionBase.ViewProperty.ShowProperty show = viewProperty.getShow();
		return show.getLink().stream().anyMatch(l -> dictionary.getDefinition(l.getValue()).getCode().equals(definition.getCode()));
	}

}
