package io.intino.goros.builder.renderers;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.Definition;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.NodeViewProperty;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public abstract class DefinitionRenderer<D extends Definition> extends Renderer {
	private final D definition;
	private Set<String> addedDisplays = new HashSet<>();

	public DefinitionRenderer(Dictionary dictionary, Modernization modernization, D definition) {
		super(dictionary, modernization);
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

	protected void resetAddedDisplays() {
		addedDisplays.clear();
	}

	protected FrameBuilder baseDefinitionFrame() {
		FrameBuilder result = super.baseFrame();
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		result.add("label", definition().getLabel());
		if (definition.getType() != null) result.add(definition.getType().name());
		return result;
	}

	protected String javaPackage() {
		return modernization.sourceUiDirectory() + File.separator + "displays" + File.separator + "templates" + File.separator;
	}

	protected String konosPackage() {
		return modernization.sourceUiDirectory() + File.separator + "definitions" + File.separator;
	}

	protected void addDisplayFor(NodeDefinition definition, String view, FrameBuilder builder) {
		addDisplayFor(definition, definition.getNodeView(view), builder);
	}

	protected void addDisplayFor(NodeDefinition definition, NodeViewProperty view, FrameBuilder builder) {
		FrameBuilder result = new FrameBuilder().add("display").add("package", modernization.projectPackage());
		NodeViewProperty viewProperty = view != null ? view : findEmbeddedView(definition);
		String key = definition.getCode() + viewProperty.getCode();
		if (addedDisplays.contains(key)) return;
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		result.add("viewName", nameOf(viewProperty));
		result.add("viewCode", viewProperty.getCode());
		addedDisplays.add(key);
		builder.add("display", result);
	}

	private NodeViewProperty findEmbeddedView(NodeDefinition definition) {
		NodeViewProperty defaultView = definition.getDefaultView();
		if (defaultView.isVisibleWhenEmbedded()) return defaultView;
		return definition.getViewDefinitionList().stream().filter(NodeViewProperty::isVisibleWhenEmbedded).findFirst().orElse(definition.getDefaultView());
	}

	private void writeJava(FrameBuilder builder) {
		File file = new File(javaPackage() + nameOf(definition) + "Template.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	private void writeKonos(FrameBuilder builder) {
		File file = new File(konosPackage() + nameOf(definition) + ".konos");
		writeFrame(file, konosTemplate().render(builder.toFrame()));
	}

}
