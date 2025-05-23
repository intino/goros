package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.templates.konos.ContainerTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.Template;
import org.monet.metamodel.ContainerDefinition;
import org.monet.metamodel.ContainerDefinitionBase;
import org.monet.metamodel.NodeDefinition;
import org.monet.metamodel.NodeViewProperty;
import org.monet.metamodel.internal.Ref;

import java.util.ArrayList;

public class ContainerRenderer extends NodeRenderer<ContainerDefinition> {

	public ContainerRenderer(Dictionary dictionary, Modernization modernization, ContainerDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected FrameBuilder viewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseViewFrame(viewProperty);
		addContain((ContainerDefinitionBase.ViewProperty) viewProperty, result);
		addShow((ContainerDefinitionBase.ViewProperty) viewProperty, result);
		return result;
	}

	@Override
	protected boolean isVisibleOnRevision(NodeViewProperty viewProperty) {
		ContainerDefinitionBase.ViewProperty.ShowProperty showProperty = ((ContainerDefinitionBase.ViewProperty)viewProperty).getShow();
		return showProperty.getComponent().size() > 0;
	}

	@Override
	protected boolean hasTemplate(NodeViewProperty viewProperty) {
		ContainerDefinitionBase.ViewProperty.ShowProperty showProperty = ((ContainerDefinitionBase.ViewProperty)viewProperty).getShow();
		if (showProperty.getRecentTask() != null) return true;
		else if (showProperty.getRevisions() != null) return true;
		else return showProperty.getComponent().size() > 0;
	}

	@Override
	protected Template konosTemplate() {
		return new ContainerTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.ContainerTemplate();
	}

	private void addContain(ContainerDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ContainerDefinitionBase.ViewProperty.ShowProperty showProperty = viewProperty.getShow();
		if (showProperty.getComponent().size() <= 0) return;
		NodeDefinition containDefinition = dictionary.getNodeDefinition(showProperty.getComponent().get(0).getDefinition());
		FrameBuilder result = baseFrame().add("contain");
		result.add(containDefinition.getType().name().toLowerCase());
		result.add("name", nameOf(viewProperty));
		result.add("contain", containDefinition.getCode());
		result.add("containName", nameOf(containDefinition));
		result.add("containView", nameOf(containDefinition.getNodeView(showProperty.getComponent().get(0).getValue())));
		builder.add("contain", result);
	}

	private void addShow(ContainerDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ContainerDefinitionBase.ViewProperty.ShowProperty showProperty = viewProperty.getShow();
		FrameBuilder result = baseFrame().add("show");
		result.add(definition().getType().name().toLowerCase());
		result.add(typeOf(showProperty));
		result.add("view", nameOf(viewProperty));
		result.add("definition", nameOf(definition()));
		if (showProperty.getRecentTask() != null) addRecentTaskShow(viewProperty, showProperty, result);
		else if (showProperty.getComponent().size() > 0) addComponentShow(viewProperty, showProperty, result);
		builder.add("show", result);
	}

	private void addRecentTaskShow(ContainerDefinitionBase.ViewProperty viewProperty, ContainerDefinitionBase.ViewProperty.ShowProperty showProperty, FrameBuilder builder) {
		findTaskDefinitionsWith(definition()).forEach(d -> addRecentTaskType(d, builder));
	}

	private void addComponentShow(ContainerDefinitionBase.ViewProperty viewProperty, ContainerDefinitionBase.ViewProperty.ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> componentList = showProperty.getComponent();
		componentList.forEach(ref -> {
			NodeDefinition definition = dictionary.getNodeDefinition(ref.getDefinition());
			NodeViewProperty view = definition.getNodeView(ref.getValue());
			addComponent(definition, view, builder);
		});
	}

	private void addComponent(NodeDefinition definition, NodeViewProperty viewProperty, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("component");
		if (definition.getType() != null) result.add(definition.getType().name());
		result.add("name", nameOf(definition));
		result.add("view", nameOf(viewProperty));
		result.add("viewCode", viewProperty.getCode());
		builder.add("component", result);
	}

}
