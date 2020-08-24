package io.intino.goros.builders.renderers;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

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

	protected void addDisplayFor(NodeDefinition definition, String view, FrameBuilder builder) {
		addDisplayFor(definition, definition.getNodeView(view), builder);
	}

	protected void addDisplayFor(NodeDefinition definition, NodeViewProperty view, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("display");
		NodeViewProperty viewProperty = view != null ? view : findEmbeddedView(definition);
		if (viewProperty == null) return;
		String key = definition.getCode() + viewProperty.getCode();
		if (addedDisplays.contains(key)) return;
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		result.add("viewName", nameOf(viewProperty));
		result.add("viewCode", viewProperty.getCode());
		addedDisplays.add(key);
		builder.add("display", result);
	}

	protected void addDesktop(FrameBuilder result) {
		List<DesktopDefinition> desktopList = dictionary.getDesktopDefinitionList().stream().filter(d -> d.getViewList().stream().anyMatch(this::containsDefinition)).collect(toList());
		if (desktopList.size() <= 0) return;
		result.add("desktop", desktopFrame(desktopList.get(0)));
	}

	protected FrameBuilder desktopFrame(DesktopDefinition desktopDefinition) {
		FrameBuilder result = baseFrame().add("desktop");
		result.add("name", nameOf(desktopDefinition));
		result.add("label", desktopDefinition.getLabel());
		return result;
	}

	private boolean containsDefinition(DesktopDefinitionBase.ViewProperty viewProperty) {
		DesktopDefinitionBase.ViewProperty.ShowProperty show = viewProperty.getShow();
		return show.getLink().stream().anyMatch(l -> dictionary.getDefinition(l.getValue()).getCode().equals(definition().getCode()));
	}

	protected void writeJava(FrameBuilder builder) {
		File file = new File(javaPackage() + nameOf(definition) + "Template.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	protected void writeKonos(FrameBuilder builder) {
		File file = new File(konosPackage() + nameOf(definition) + ".konos");
		writeFrame(file, konosTemplate().render(builder.toFrame()));
	}

	private NodeViewProperty findEmbeddedView(NodeDefinition definition) {
		NodeViewProperty defaultView = definition.getDefaultView();
		if (defaultView != null && defaultView.isVisibleWhenEmbedded()) return defaultView;
		return definition.getViewDefinitionList().stream().filter(NodeViewProperty::isVisibleWhenEmbedded).findFirst().orElse(definition.getDefaultView());
	}

}
