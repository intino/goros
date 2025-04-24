package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.DefinitionRenderer;
import io.intino.goros.modernizing.monet.renderers.Formatters;
import io.intino.goros.modernizing.monet.renderers.templates.konos.ProcessDefinitionTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.formatters.StringFormatters;
import io.intino.itrules.template.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;

public abstract class ProcessRenderer<D extends ProcessDefinition> extends DefinitionRenderer<D> {

	public ProcessRenderer(Dictionary dictionary, Modernization modernization, D definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		super.write();
		writeEmbeddedTemplate();
		writeStateView();
		writeTargetViews();
		writeShortcutViews();
	}

	@Override
	protected FrameBuilder buildFrame() {
		return baseDefinitionFrame().add("process");
	}

	@Override
	protected Template konosTemplate() {
		return new ProcessDefinitionTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate();
	}

	protected void addDisplayList(FrameBuilder builder) {
		resetAddedDisplays();
		addTargetDisplays(builder);
	}

	private void addTargetViews(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getTarget() != null).forEach(v -> addTargetView(v, builder));
	}

	private void addTargetView(ProcessDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		Ref targetDefinition = viewProperty.getShow().getTarget();
		if (targetDefinition == null) return;
		builder.add("view", viewFrame(viewProperty).add("target"));
	}

	private void addShortcutViews(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getShortcut() != null).forEach(v -> addShortcutView(v, builder));
	}

	private void addShortcutView(ProcessDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ArrayList<Ref> shortcutDefinition = viewProperty.getShow().getShortcutDefinition();
		if (shortcutDefinition == null || shortcutDefinition.isEmpty()) return;
		builder.add("view", viewFrame(viewProperty).add("shortcut"));
	}

	protected FrameBuilder viewFrame(ProcessDefinitionBase.ViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("view");
		result.add("definition", nameOf(definition()));
		result.add("code", viewProperty.getCode());
		result.add("name", nameOf(viewProperty));
		result.add("label", clean(labelOf(viewProperty)));
		addShow(viewProperty, result);
		return result;
	}

	private void addShow(ProcessDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ProcessDefinitionBase.ViewProperty.ShowProperty show = viewProperty.getShow();
		if (show.getShortcut() != null) addShortcutShow(viewProperty, builder);
		else if (show.getTarget() != null) addTargetShow(viewProperty, builder);
	}

	private void addShortcutShow(ProcessDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ArrayList<Ref> definitionRefList = viewProperty.getShow().getShortcutDefinition();
		builder.add("shortcut", viewProperty.getShow().getShortcut());
		definitionRefList.forEach(ref -> addShortcutShow(viewProperty, ref, builder));
	}

	private void addShortcutShow(ProcessDefinitionBase.ViewProperty viewProperty, Ref definitionRef, FrameBuilder builder) {
		String view = viewProperty.getShow().getShortcutView();
		NodeDefinition nodeDefinition = dictionary.getNodeDefinition(definitionRef.getValue());
		NodeViewProperty nodeViewProperty = view != null && nodeDefinition.getNodeView(view) != null ? nodeDefinition.getNodeView(view) : nodeDefinition.getDefaultView();
		builder.add("show", showFrame(viewProperty, nodeDefinition, nodeViewProperty).add("shortcut").add("shortcut", viewProperty.getShow().getShortcut()));
	}

	private void addTargetShow(ProcessDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		Ref definitionRef = viewProperty.getShow().getTarget();
		builder.add("target", definitionRef);
		addTargetShow(viewProperty, definitionRef, builder);
	}

	private void addTargetShow(ProcessDefinitionBase.ViewProperty viewProperty, Ref definitionRef, FrameBuilder builder) {
		String view = definitionRef.getValue();
		NodeDefinition nodeDefinition = dictionary.getNodeDefinition(definitionRef.getDefinition());
		NodeViewProperty nodeViewProperty = view != null && nodeDefinition.getNodeView(view) != null ? nodeDefinition.getNodeView(view) : nodeDefinition.getDefaultView();
		builder.add("show", showFrame(viewProperty, nodeDefinition, nodeViewProperty).add("target").add("target", definitionRef));
	}

	private FrameBuilder showFrame(ProcessDefinitionBase.ViewProperty viewProperty, NodeDefinition nodeDefinition, NodeViewProperty nodeViewProperty) {
		FrameBuilder result = new FrameBuilder().add("show");
		result.add("definitionName", nameOf(nodeDefinition));
		result.add("definitionCode", nodeDefinition.getCode());
		result.add("code", viewProperty.getCode());
		result.add("name", nameOf(viewProperty));
		result.add("viewCode", nodeViewProperty != null ? nodeViewProperty.getCode() : nodeDefinition.getCode());
		result.add("viewName", nodeViewProperty != null ? nameOf(nodeViewProperty) + "ViewTemplate" : "EmbeddedTemplate");
		addContain(nodeDefinition, nodeViewProperty, result);
		return result;
	}

	private void addContain(NodeDefinition nodeDefinition, NodeViewProperty nodeViewProperty, FrameBuilder builder) {
		if (!nodeDefinition.isContainer() || nodeViewProperty == null) return;
		ContainerDefinitionBase.ViewProperty containViewProperty = ((ContainerDefinitionBase.ViewProperty) nodeViewProperty);
		if (containViewProperty.getShow().getComponent() == null || containViewProperty.getShow().getComponent().isEmpty()) return;
		Ref ref = containViewProperty.getShow().getComponent().get(0);
		NodeDefinition containDefinition = dictionary.getNodeDefinition(ref.getDefinition());
		FrameBuilder result = new FrameBuilder("showContain");
		result.add("definitionName", nameOf(nodeDefinition));
		result.add("definitionCode", nodeDefinition.getCode());
		result.add("code", nodeViewProperty.getCode());
		result.add("name", nameOf(nodeViewProperty));
		result.add("viewCode", nodeViewProperty.getCode());
		result.add("viewName", nameOf(nodeViewProperty) + "ViewTemplate");
		result.add("containDefinitionName", nameOf(containDefinition));
		result.add("containDefinitionCode", containDefinition.getCode());
		builder.add("showContain", result);
	}

	private void addTargetDisplays(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getTarget() != null).forEach(v -> {
			Ref target = v.getShow().getTarget();
			NodeDefinition definition = dictionary.getNodeDefinition(target.getDefinition());
			addDisplayFor(definition, target.getValue(), builder);
		});
		definition().getEditionActionList().forEach(a -> {
			NodeDefinition definition = dictionary.getNodeDefinition(a.getUse().getForm().getValue());
			addDisplayFor(definition, a.getUse().getWithView().getValue(), builder);
		});
	}

	@Override
	protected void writeKonos(FrameBuilder builder) {
		File file = new File(konosPackage() + nameOf(definition()) + ".konos");
		addTargetViews(builder);
		addShortcutViews(builder);
		addDisplayList(builder);
		writeFrame(file, new io.intino.itrules.Engine(konosTemplate()).addAll(Formatters.all).render(builder.toFrame()));
	}

	private void writeEmbeddedTemplate() {
		FrameBuilder builder = baseDefinitionFrame().add("embedded");
		addTargetViews(builder);
		addShortcutViews(builder);
		File file = new File(javaPackage() + nameOf(definition()) + "EmbeddedTemplate.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate().render(builder.toFrame()));
	}

	private void writeStateView() {
		FrameBuilder builder = baseDefinitionFrame().add("stateview");
		addDisplayList(builder);
		File file = new File(javaPackage() + nameOf(definition()) + "StateViewTemplate.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate().render(builder.toFrame()));
	}

	private void writeTargetViews() {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getTarget() != null).forEach(this::writeTargetView);
	}

	protected void writeTargetView(ProcessDefinitionBase.ViewProperty viewProperty) {
		Ref targetDefinition = viewProperty.getShow().getTarget();
		if (targetDefinition == null) return;
		FrameBuilder builder = viewFrame(viewProperty).add("target").add("process");
		File file = new File(javaPackage() + nameOf(definition()) + StringFormatters.firstUpperCase().format(nameOf(viewProperty)) + "ViewTemplate.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate().render(builder.toFrame()));
	}

	private void writeShortcutViews() {
		definition().getViewList().stream().filter(v -> v.getShow() != null && v.getShow().getShortcut() != null).forEach(this::writeShortcutView);
	}

	protected void writeShortcutView(ProcessDefinitionBase.ViewProperty viewProperty) {
		ArrayList<Ref> shortcutDefinition = viewProperty.getShow().getShortcutDefinition();
		if (shortcutDefinition == null || shortcutDefinition.isEmpty()) return;
		FrameBuilder builder = viewFrame(viewProperty).add("shortcut").add("process");
		File file = new File(javaPackage() + nameOf(definition()) + StringFormatters.firstUpperCase().format(nameOf(viewProperty)) + "ViewTemplate.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.ProcessDefinitionTemplate().render(builder.toFrame()));
	}

}
