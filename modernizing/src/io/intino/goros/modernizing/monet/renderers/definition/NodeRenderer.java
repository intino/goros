package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.DefinitionRenderer;
import io.intino.goros.modernizing.monet.renderers.templates.java.TasksTemplate;
import io.intino.goros.modernizing.monet.util.StringUtil;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
		writeViewsTemplate();
	}

	@Override
	protected FrameBuilder buildFrame() {
		return buildFrame(false);
	}

	protected FrameBuilder baseViewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("nodeview");
		NodeDefinition definition = definition();
		result.add(typeOf(viewProperty));
		result.add("definition", nameOf(definition));
		result.add("code", viewProperty.getCode());
		result.add("name", nameOf(viewProperty));
		result.add("label", clean(labelOf(viewProperty)));
		if (viewProperty.isVisibleWhenEmbedded()) result.add("visibleWhenEmbedded");
		if (!isVisibleOnRevision(viewProperty)) result.add("notVisibleOnRevision");
		return result;
	}

	protected void addParent(FrameBuilder builder) {
		NodeDefinition parent = findParentDefinition();
		if (parent == null) return;
		FrameBuilder result = baseFrame().add("parent");
		result.add("name", nameOf(parent));
		result.add("label", clean(parent.getLabel()));
		if (parent.isSingleton()) result.add("singleton");
		addResourceType(parent, result);
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

	protected void writeViewsTemplate() {
		definition().getViewDefinitionList().stream().filter(this::hasTemplate).forEach(this::writeViewTemplate);
	}

	private FrameBuilder buildFrame(boolean revision) {
		FrameBuilder result = baseDefinitionFrame().add("nodedefinition");
		if (revision) result.add("revision");
		if (definition().isSingleton()) {
			result.add("singleton");
			result.add("singleton", definition().getCode());
		}
		result.add("readonly", definition().isReadonly() ? "true" : "readonly");
		addDesktop(result);
		addParent(result);
		addToolbar(result);
		addViews(result, revision);
		return result;
	}

	private void addToolbar(FrameBuilder builder) {
		builder.add("toolbar", toolbarFrame());
	}

	protected FrameBuilder toolbarFrame() {
		FrameBuilder result = baseFrame().add("toolbar");
		result.add("definition", nameOf(definition()));
		if (definition().isSingleton()) result.add("singleton");
		boolean collectable = findParentDefinition() != null;
		if (collectable) result.add("collectable");
		if (definition().isSet()) result.add("collection");
		addOperations(definition(), result);
		addResourceType(definition(), result);
		return result;
	}

	protected void addOperations(D definition, FrameBuilder result) {
		definition.getOperationList().forEach(o -> addOperation(o, result));
	}

	protected void addOperation(NodeDefinitionBase.OperationProperty operation, FrameBuilder builder) {
		FrameBuilder result = new FrameBuilder("operation");
		if (isDownloadOperation(operation)) result.add("download");
		if (operation.getConfirmation() != null) result.add("confirmation");
		result.add("name", operation.getName());
		result.add("label", clean(operation.getLabel()));
		if (operation.getConfirmation() != null) result.add("confirmText", operation.getConfirmation().getDescription());
		builder.add("operation", result);
	}

	protected boolean isDownloadOperation(NodeDefinitionBase.OperationProperty operation) {
		String name = operation.getName().toLowerCase();
		String label = ((String) operation.getLabel()).toLowerCase();
		return name.contains("descargar") || name.contains("download") ||
				label.contains("descargar") || label.contains("download");
	}

	private NodeDefinition findParentDefinition() {
		return dictionary.getCollectionDefinitionList().stream().filter(c -> {
			ArrayList<Ref> refList = c.getAdd().getNode();
			return refList.stream().map(ref -> dictionary.getAllImplementersOfNodeDefinition(ref.getValue())).flatMap(Collection::stream).anyMatch(def -> def.getCode().equals(definition().getCode()));
		}).findFirst().orElse(null);
	}

	private void addViews(FrameBuilder builder, boolean revision) {
		definition().getViewDefinitionList().stream().filter(v -> (!revision || isVisibleOnRevision(v))).forEach(v -> addView(v, builder));
	}

	private void addView(NodeViewProperty viewProperty, FrameBuilder builder) {
		if (typeOf(viewProperty) == null) return;
		builder.add("view", viewFrame(viewProperty));
	}

	private void writeViewTemplate(NodeViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view);
		File file = new File(javaPackage() + nameOf(definition()) + StringUtil.firstUpperCase(nameOf(view)) + "ViewTemplate.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}

	private List<NodeDefinition> nodeDefinitions(NodeFieldProperty field) {
		List<NodeDefinition> result = new ArrayList<>();
		if (field.getContain() != null) result.add(dictionary.getNodeDefinition(field.getContain().getNode().getValue()));
		if (field.getAdd() != null) field.getAdd().getNode().forEach(ref -> result.add(dictionary.getNodeDefinition(ref.getValue())));
		return result;
	}

}
