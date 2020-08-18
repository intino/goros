package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.templates.java.CollectionTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.AttributeProperty.TypeEnumeration;
import org.monet.metamodel.internal.DescriptorDefinition;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;

public class CollectionRenderer extends SetRenderer<CollectionDefinition> {

	public CollectionRenderer(Dictionary dictionary, Modernization modernization, CollectionDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		super.write();
		writeToolbarTemplate();
		writeFilterTemplates();
	}

	@Override
	protected FrameBuilder buildFrame() {
		FrameBuilder result = super.buildFrame().add("collectiondefinition");
		addRefAddList(result);
		return result;
	}

	@Override
	protected FrameBuilder viewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("nodeview").add("collectionview");
		result.add(typeOf(viewProperty));
		NodeDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", viewProperty.getLabel());
		result.add("name", nameOf(viewProperty));
		result.add("code", viewProperty.getCode());
		result.add("materialIcon", materialIcon(viewProperty));
		addShow((SetDefinition.SetViewProperty) viewProperty, result);
		addAttributes((SetDefinition.SetViewProperty)viewProperty, result);
		addAnalyze((SetDefinition.SetViewProperty)viewProperty, result);
		return result;
	}

	private void addShow(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinition.SetViewProperty.ShowProperty showProperty = viewProperty.getShow();
		FrameBuilder result = baseFrame().add("show");
		result.add(typeOf(showProperty));
		result.add("view", nameOf(viewProperty));
		result.add("definition", nameOf(definition()));
		result.add("componentType", componentTypeFrame(viewProperty));
		if (showProperty.getItems() != null) addItemsShow(viewProperty, showProperty, result);
		else if (showProperty.getIndex() != null) addIndexShow(viewProperty, showProperty, result);
		else if (showProperty.getLocations() != null) addLocationsShow(viewProperty, showProperty, result);
		addAttributes(viewProperty, result);
		builder.add("show", result);
	}

	private void addItemsShow(SetDefinition.SetViewProperty viewProperty, SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty, FrameBuilder builder) {
		builder.add("reference", DescriptorDefinition.CODE);
	}

	private FrameBuilder componentTypeFrame(SetDefinition.SetViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("componentType");
		result.add(typeOf(viewProperty));
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		return result;
	}

	private void addIndexShow(SetDefinition.SetViewProperty viewProperty, SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty, FrameBuilder builder) {
		addReferenceShow(showProperty.getIndex().getWithView(), builder);
	}

	private void addLocationsShow(SetDefinition.SetViewProperty viewProperty, SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty, FrameBuilder builder) {
		addReferenceShow(showProperty.getLocations().getWithView(), builder);
	}

	private void addReferenceShow(Ref withView, FrameBuilder builder) {
		IndexDefinition definition = dictionary.getIndexDefinition(withView.getDefinition());
		builder.add("reference", definition.getCode());
	}

	private void addAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty show = viewProperty.getShow();
		if (show.getItems() != null) addItemsAttributes(viewProperty, builder);
		else if (show.getIndex() != null) addIndexAttributes(viewProperty, builder);
		else if (show.getLocations() != null) addLocationsAttributes(viewProperty, builder);
	}

	private void addItemsAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_LABEL, "Título", 20));
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_DESCRIPTION, "Descripción", 20));
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_CREATE_DATE, "Fecha creación", 20));
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_UPDATE_DATE, "Fecha actualización", 20));
	}

	private void addIndexAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty.IndexProperty index = viewProperty.getShow().getIndex();
		addIndexViewAttributes(viewProperty, index.getWithView(), builder);
	}

	private void addLocationsAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty.LocationsProperty locations = viewProperty.getShow().getLocations();
		addIndexViewAttributes(viewProperty, locations.getWithView(), builder);
	}

	private void addIndexViewAttributes(SetDefinition.SetViewProperty viewProperty, Ref withView, FrameBuilder builder) {
		IndexDefinition definition = dictionary.getIndexDefinition(withView.getDefinition());
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = definition.getView(withView.getValue()).getShow();
		if (show.getTitle() != null) addIndexViewAttribute("title", attributeFrame(viewProperty, definition, show.getTitle()), builder);
		if (show.getPicture() != null) addIndexViewAttribute("picture", attributeFrame(viewProperty, definition, show.getPicture()), builder);
		if (show.getIcon() != null) addIndexViewAttribute("icon", attributeFrame(viewProperty, definition, show.getIcon()), builder);
		show.getHighlight().forEach(h -> addIndexViewAttribute("highlight", attributeFrame(viewProperty, definition, h), builder));
		show.getLine().forEach(l -> addIndexViewAttribute("line", attributeFrame(viewProperty, definition, l), builder));
		show.getLineBelow().forEach(lb -> addIndexViewAttribute("lineBelow", attributeFrame(viewProperty, definition, lb), builder));
		show.getFooter().forEach(f -> addIndexViewAttribute("footer", attributeFrame(viewProperty, definition, f), builder));
	}

	private void addIndexViewAttribute(String section, FrameBuilder attributeFrame, FrameBuilder builder) {
		builder.add(section, attributeFrame);
		builder.add("attribute", attributeFrame);
	}

	private void addAnalyze(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		if (viewProperty.getAnalyze() == null) return;
		SetDefinitionBase.SetViewPropertyBase.AnalyzePropertyBase.DimensionProperty dimension = viewProperty.getAnalyze().getDimension();
		ArrayList<Ref> dimensionList = dimension.getAttribute();
		dimensionList.forEach(d -> addDimension(d, builder));
	}

	private void addDimension(Ref dimension, FrameBuilder builder) {
		IndexDefinition definition = dictionary.getIndexDefinition(dimension.getDefinition());
		AttributeProperty attributeProperty = definition.getAttribute(dimension.getValue());
		builder.add("dimension", dimensionFrame(attributeProperty));
	}

	private FrameBuilder dimensionFrame(AttributeProperty attributeProperty) {
		FrameBuilder result = baseFrame().add("dimension");
		result.add("name", attributeProperty.getName());
		result.add("label", attributeProperty.getLabel());
		result.add("type", dimensionTypeOf(attributeProperty));
		return result;
	}

	private FrameBuilder attributeFrame(SetDefinition.SetViewProperty viewProperty, IndexDefinition definition, Ref attribute) {
		AttributeProperty attributeProperty = definition.getAttribute(attribute.getValue());
		FrameBuilder result = baseFrame().add("attribute");
		result.add(attributeProperty.getType().name().toLowerCase());
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		result.add("name", normalize(attributeProperty.getName()));
		result.add("code", attributeProperty.getCode());
		result.add("label", attributeProperty.getLabel());
		result.add("type", attributeTypeOf(attributeProperty));
		return result;
	}

	private FrameBuilder attributeFrame(NodeViewProperty viewProperty, String key, String label, int width) {
		FrameBuilder result = baseFrame().add("attribute");
		result.add(typeOf(viewProperty));
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		result.add("name", normalize(key));
		result.add("code", key);
		result.add("label", label);
		result.add("width", width);
		return result;
	}

	private void addRefAddList(FrameBuilder builder) {
		ArrayList<Ref> addList = definition().getAdd().getNode();
		if (addList.size() > 0) builder.add("defaultAdd", addFrame(dictionary.getNodeDefinition(addList.get(0).getValue())));
		addList.forEach(ref -> addRefAdd(ref, builder));
	}

	private void addRefAdd(Ref ref, FrameBuilder builder) {
		NodeDefinition nodeDefinition = dictionary.getNodeDefinition(ref.getValue());
		builder.add("add", addFrame(nodeDefinition));
	}

	private FrameBuilder addFrame(NodeDefinition nodeDefinition) {
		FrameBuilder result = baseFrame().add("add");
		result.add("name", nameOf(nodeDefinition));
		result.add("code", nodeDefinition.getCode());
		result.add("label", nodeDefinition.getLabel());
		return result;
	}

	private String materialIcon(NodeViewProperty viewProperty) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty show = ((SetDefinition.SetViewProperty)viewProperty).getShow();
		if (show.getItems() != null) return "ViewHeadline";
		else if (show.getIndex() != null) return "ViewList";
		else if (show.getLocations() != null) return "Map";
		else if (show.getOwnedPrototypes() != null) return "AssignmentInd";
		else if (show.getSharedPrototypes() != null) return "Assignment";
		else if (show.getReport() != null) return "Assessment";
		return null;
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.CollectionTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new CollectionTemplate();
	}

	private String attributeTypeOf(AttributeProperty attributeProperty) {
		TypeEnumeration type = attributeProperty.getType();
		if (type == TypeEnumeration.DATE) return "Date";
		else if (type == TypeEnumeration.PICTURE) return "Image";
		else if (type == TypeEnumeration.INTEGER || type == TypeEnumeration.REAL) return "Number";
		return "Text";
	}

	private String dimensionTypeOf(AttributeProperty attributeProperty) {
		TypeEnumeration type = attributeProperty.getType();
		if (type == TypeEnumeration.DATE) return "DateRange";
		if (type == TypeEnumeration.STRING) return "Search";
		if (type == TypeEnumeration.BOOLEAN) return "Check";
		return "Combo";
	}

	private void writeToolbarTemplate() {
		resetAddedDisplays();
		FrameBuilder builder = buildFrame().add("toolbar");
		File file = new File(javaPackage() + nameOf(definition()) + "ToolbarTemplate.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	private void writeFilterTemplates() {
		definition().getViewDefinitionList().stream().filter(this::hasTemplate).forEach(this::writeFilterTemplate);
	}

	private void writeFilterTemplate(NodeViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view).add("filter");
		File file = new File(javaPackage() + nameOf(definition()) + nameOf(view) + "FilterTemplate.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}
}
