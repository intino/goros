package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.RendererHelper;
import io.intino.goros.builder.renderers.templates.java.SetTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.internal.DescriptorDefinition;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;

public abstract class SetRenderer<D extends SetDefinition> extends NodeRenderer<D> {

	public SetRenderer(Dictionary dictionary, Modernization modernization, D definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeJava(builder);
		writeKonos(builder);
		writeViewsTemplate();
		writeToolbarTemplate();
		writeFiltersTemplates();
	}

	@Override
	protected FrameBuilder buildFrame() {
		return super.buildFrame().add("setdefinition");
	}

	@Override
	protected boolean isVisibleOnRevision(NodeViewProperty viewProperty) {
		return false;
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.SetTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new SetTemplate();
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

	@Override
	protected boolean hasTemplate(NodeViewProperty viewProperty) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty = ((SetDefinition.SetViewProperty)viewProperty).getShow();
		if (showProperty.getItems() != null) return true;
		if (showProperty.getIndex() != null) return true;
		return showProperty.getLocations() != null;
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
		IndexDefinitionBase.IndexViewProperty indexView = definition.getView(withView.getValue());
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = indexView.getShow();
		int countAttributes = RendererHelper.countAttributes(indexView);
		if (show.getTitle() != null) addIndexViewAttribute("title", attributeFrame(viewProperty, definition, show.getTitle(), countAttributes), builder);
		if (show.getPicture() != null) addIndexViewAttribute("picture", attributeFrame(viewProperty, definition, show.getPicture(), countAttributes), builder);
		if (show.getIcon() != null) addIndexViewAttribute("icon", attributeFrame(viewProperty, definition, show.getIcon(), countAttributes), builder);
		show.getHighlight().forEach(h -> addIndexViewAttribute("highlight", attributeFrame(viewProperty, definition, h, countAttributes), builder));
		show.getLine().forEach(l -> addIndexViewAttribute("line", attributeFrame(viewProperty, definition, l, countAttributes), builder));
		show.getLineBelow().forEach(lb -> addIndexViewAttribute("lineBelow", attributeFrame(viewProperty, definition, lb, countAttributes), builder));
		show.getFooter().forEach(f -> addIndexViewAttribute("footer", attributeFrame(viewProperty, definition, f, countAttributes), builder));
	}

	private void addIndexViewAttribute(String section, FrameBuilder attributeFrame, FrameBuilder builder) {
		builder.add(section, attributeFrame.add(section));
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
		result.add("type", RendererHelper.dimensionTypeOf(attributeProperty));
		return result;
	}

	private FrameBuilder attributeFrame(SetDefinition.SetViewProperty viewProperty, IndexDefinition definition, Ref attribute, int countAttributes) {
		AttributeProperty attributeProperty = definition.getAttribute(attribute.getValue());
		FrameBuilder result = baseFrame().add("attribute");
		result.add(attributeProperty.getType().name().toLowerCase());
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		result.add("name", normalize(attributeProperty.getName()));
		result.add("code", attributeProperty.getCode());
		result.add("label", attributeProperty.getLabel());
		result.add("type", RendererHelper.attributeTypeOf(attributeProperty));
		result.add("width", countAttributes > 0 ? Math.round(100.0/countAttributes) : 0);
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

	private void writeToolbarTemplate() {
		resetAddedDisplays();
		FrameBuilder builder = buildFrame().add("toolbar");
		File file = new File(javaPackage() + nameOf(definition()) + "ToolbarTemplate.java");
		writeFrame(file, javaTemplate().render(builder.toFrame()));
	}

	private void writeFiltersTemplates() {
		definition().getViewDefinitionList().stream().filter(this::hasTemplate).forEach(this::writeFiltersTemplate);
	}

	private void writeFiltersTemplate(NodeViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view).add("filter");
		File file = new File(javaPackage() + nameOf(definition()) + nameOf(view) + "FiltersTemplate.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}
}
