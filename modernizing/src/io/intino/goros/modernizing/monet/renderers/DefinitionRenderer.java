package io.intino.goros.modernizing.monet.renderers;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class DefinitionRenderer<D extends Definition> extends Renderer {
	private final D definition;
	private final Set<String> addedDisplays = new HashSet<>();

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
		result.add("label", clean(definition().getLabel()));
		if (definition.getType() != null) {
			result.add(definition.getType().name());
			if (definition instanceof ProcessDefinition) result.add("process");
		}
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
		DesktopDefinition desktop = desktopWithDefinition(definition());
		if (desktop == null) return;
		result.add("desktop", desktopFrame(desktop));
	}

	protected FrameBuilder desktopFrame(DesktopDefinition desktopDefinition) {
		FrameBuilder result = baseFrame().add("desktop");
		if (desktopDefinition.isSingleton()) result.add("singleton");
		result.add("name", nameOf(desktopDefinition));
		result.add("label", clean(desktopDefinition.getLabel()));
		addResourceType(desktopDefinition, result);
		return result;
	}

	protected void addRecentTaskType(TaskDefinition definition, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("tasktype");
		result.add("name", nameOf(definition));
		result.add("code", definition.getCode());
		builder.add("tasktype", result);
	}

	protected List<TaskDefinition> findTaskDefinitionsWith(Definition definition) {
		return dictionary.getTaskDefinitionList().stream().filter(d -> contains(d, definition)).collect(Collectors.toList());
	}

	private boolean contains(TaskDefinition taskDefinition, Definition definition) {
		if (taskDefinition.isJob()) return false;
		Ref target = taskDefinition.isActivity() ? ((ActivityDefinition)taskDefinition).getTarget() : ((ServiceDefinition)taskDefinition).getTarget();
		return target != null && dictionary.getDefinitionCode(target.getValue()).equals(definition.getCode());
	}

	private boolean containsDefinition(DesktopDefinitionBase.ViewProperty viewProperty) {
		DesktopDefinitionBase.ViewProperty.ShowProperty show = viewProperty.getShow();
		return show.getLink().stream().anyMatch(l -> dictionary.getDefinition(l.getValue()).getCode().equals(definition().getCode()));
	}

	protected void writeJava(FrameBuilder builder) {
		File file = new File(javaPackage() + nameOf(definition) + "Template.java");
		writeFrame(file, new io.intino.itrules.Engine(javaTemplate()).addAll(Formatters.all).render(builder.toFrame()));
	}

	protected void writeKonos(FrameBuilder builder) {
		File file = new File(konosPackage() + nameOf(definition) + ".konos");
		writeFrame(file, new io.intino.itrules.Engine(konosTemplate()).addAll(Formatters.all).render(builder.toFrame()));
	}

	private NodeViewProperty findEmbeddedView(NodeDefinition definition) {
		NodeViewProperty defaultView = definition.getDefaultView();
		if (defaultView != null && defaultView.isVisibleWhenEmbedded()) return defaultView;
		return definition.getViewDefinitionList().stream().filter(NodeViewProperty::isVisibleWhenEmbedded).findFirst().orElse(definition.getDefaultView());
	}

}
