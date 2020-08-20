package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.FormTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty.ShowProperty;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.intino.goros.builder.util.StringUtil.firstUpperCase;

public abstract class NodeRenderer<D extends NodeDefinition> extends DefinitionRenderer<D> {

	public NodeRenderer(Dictionary dictionary, Modernization modernization, D definition) {
		super(dictionary, modernization, definition);
	}

	protected abstract FrameBuilder viewFrame(NodeViewProperty view);
	protected abstract boolean hasTemplate(NodeViewProperty view);
	protected abstract boolean isVisibleOnRevision(NodeViewProperty view);

	@Override
	public void write() {
		super.write();
		writeEmbeddedTemplate();
		writeRevisionTemplate();
		writeViewsTemplate();
	}

	@Override
	protected FrameBuilder buildFrame() {
		return buildFrame(false);
	}

	protected void addParent(FrameBuilder builder) {
		NodeDefinition parent = findParentDefinition();
		if (parent == null) return;
		FrameBuilder result = baseFrame().add("parent");
		result.add("name", nameOf(parent));
		result.add("label", parent.getLabel());
		builder.add("parent", result);
	}

	protected void addDisplayFor(FieldProperty field, FrameBuilder builder) {
		if (field instanceof CompositeFieldProperty) ((CompositeFieldProperty)field).getAllFieldPropertyList().forEach(f -> addDisplayFor(f, builder));
		else if (field instanceof NodeFieldProperty) {
			List<NodeDefinition> nodeDefinitionList = nodeDefinitions(((NodeFieldProperty)field));
			nodeDefinitionList.forEach(definition -> addDisplayFor(definition, (NodeViewProperty)null, builder));
		}
	}

	protected void writeEmbeddedTemplate() {
		resetAddedDisplays();
		FrameBuilder builder = buildFrame().add("embedded");
		File file = new File(javaPackage() + nameOf(definition()) + "EmbeddedTemplate.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	protected void writeRevisionTemplate() {
		resetAddedDisplays();
		FrameBuilder builder = buildFrame(true);
		File file = new File(javaPackage() + nameOf(definition()) + "RevisionTemplate.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	protected void writeViewsTemplate() {
		definition().getViewDefinitionList().stream().filter(this::hasTemplate).forEach(this::writeViewTemplate);
	}

	private FrameBuilder buildFrame(boolean revision) {
		FrameBuilder result = baseDefinitionFrame().add("nodedefinition");
		if (revision) result.add("revision");
		if (definition().isSingleton()) result.add("singleton");
		addParent(result);
		addToolbar(result);
		addViews(result, revision);
		return result;
	}

	private void addToolbar(FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("toolbar");
		result.add("definition", nameOf(definition()));
		if (definition().isSingleton()) result.add("singleton");
		boolean collectable = findParentDefinition() != null;
		if (collectable) result.add("collectable");
		builder.add("toolbar", result);
	}

	private NodeDefinition findParentDefinition() {
		return dictionary.getCollectionDefinitionList().stream().filter(c -> {
			ArrayList<Ref> refList = c.getAdd().getNode();
			return refList.stream().anyMatch(ref -> dictionary.getNodeDefinition(ref.getValue()).getCode().equals(definition().getCode()));
		}).findFirst().orElse(null);
	}

	private void addViews(FrameBuilder builder, boolean revision) {
		definition().getViewDefinitionList().stream().filter(v -> !revision || isVisibleOnRevision(v)).forEach(v -> addView(v, builder));
	}

	private void addView(NodeViewProperty viewProperty, FrameBuilder builder) {
		builder.add("view", viewFrame(viewProperty));
	}

	private void writeViewTemplate(NodeViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view);
		File file = new File(javaPackage() + nameOf(definition()) + nameOf(view) + "ViewTemplate.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}

	private List<NodeDefinition> nodeDefinitions(NodeFieldProperty field) {
		List<NodeDefinition> result = new ArrayList<>();
		if (field.getContain() != null) result.add(dictionary.getNodeDefinition(field.getContain().getNode().getValue()));
		if (field.getAdd() != null) field.getAdd().getNode().forEach(ref -> result.add(dictionary.getNodeDefinition(ref.getValue())));
		return result;
	}

}
