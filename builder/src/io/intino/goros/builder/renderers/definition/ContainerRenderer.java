package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.ContainerTemplate;
import io.intino.goros.builder.renderers.templates.java.FormTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty.ShowProperty;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.intino.goros.builder.util.StringUtil.firstUpperCase;

public class ContainerRenderer extends NodeRenderer<ContainerDefinition> {

	public ContainerRenderer(Dictionary dictionary, Modernization modernization, ContainerDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	protected FrameBuilder viewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("nodeview");
		result.add(typeOf(viewProperty));
		NodeDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", viewProperty.getLabel());
		result.add("name", nameOf(viewProperty));
		result.add("code", viewProperty.getCode());
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
		return new io.intino.goros.builder.renderers.templates.konos.ContainerTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new ContainerTemplate();
	}

	private void addContain(ContainerDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ContainerDefinitionBase.ViewProperty.ShowProperty showProperty = viewProperty.getShow();
		if (showProperty.getComponent().size() <= 0) return;
		NodeDefinition containDefinition = dictionary.getNodeDefinition(showProperty.getComponent().get(0).getDefinition());
		FrameBuilder result = baseFrame().add("contain");
		result.add("name", nameOf(viewProperty));
		result.add("contain", containDefinition.getCode());
		builder.add("contain", result);
	}

	private void addShow(ContainerDefinitionBase.ViewProperty viewProperty, FrameBuilder builder) {
		ContainerDefinitionBase.ViewProperty.ShowProperty showProperty = viewProperty.getShow();
		FrameBuilder result = baseFrame().add("show");
		result.add(typeOf(showProperty));
		result.add("view", nameOf(viewProperty));
		result.add("definition", nameOf(definition()));
		if (showProperty.getComponent().size() > 0) addComponentShow(viewProperty, showProperty, result);
		builder.add("show", result);
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
		result.add("name", nameOf(definition));
		result.add("view", nameOf(viewProperty));
		builder.add("component", result);
	}

}