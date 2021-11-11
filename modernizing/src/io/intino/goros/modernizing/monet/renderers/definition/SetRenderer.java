package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.RendererHelper;
import io.intino.goros.modernizing.monet.renderers.templates.konos.SetTemplate;
import io.intino.goros.modernizing.monet.util.StringUtil;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.SetDefinitionBase.SetViewPropertyBase.ShowProperty.LocationsProperty;
import org.monet.metamodel.internal.DescriptorDefinition;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class SetRenderer<D extends SetDefinition> extends NodeRenderer<D> {

	public SetRenderer(Dictionary dictionary, Modernization modernization, D definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		FrameBuilder builder = buildFrame();
		writeJava(builder);
		writeKonos(builder);
		writeEmbeddedTemplate();
		writeViewsTemplate();
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
		return new SetTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.SetTemplate();
	}

	@Override
	protected FrameBuilder viewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseViewFrame(viewProperty).add("collectionview");
		result.add("materialIcon", materialIcon(viewProperty));
		result.add("height", calculateHeight((SetDefinition.SetViewProperty)viewProperty));
		addFacets((SetDefinition.SetViewProperty) viewProperty, result);
		addShow((SetDefinition.SetViewProperty) viewProperty, result);
		addAttributes((SetDefinition.SetViewProperty)viewProperty, result);
		addAnalyze((SetDefinition.SetViewProperty)viewProperty, result);
		return result;
	}

	protected void addFacets(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		LocationsProperty locations = viewProperty.getShow().getLocations();
		if (locations == null) return;
		if (locations.getLayer() == LocationsProperty.LayerEnumeration.HEAT) builder.add("heatmap", "Heatmap");
		else builder.add("clustermap", "Cluster");
	}

	private int calculateHeight(SetDefinition.SetViewProperty viewProperty) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty show = viewProperty.getShow();
		if (show.getItems() != null) return 50;
		if (show.getIndex() != null) return calculateIndexHeight(viewProperty);
		if (show.getLocations() != null) return calculateLocationsHeight(viewProperty);
		return 124;
	}

	private int calculateIndexHeight(SetDefinition.SetViewProperty viewProperty) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty.IndexProperty index = viewProperty.getShow().getIndex();
		return calculateAttributesHeight(viewProperty, index.getWithView(), false);
	}

	private int calculateLocationsHeight(SetDefinition.SetViewProperty viewProperty) {
		LocationsProperty locations = viewProperty.getShow().getLocations();
		return calculateAttributesHeight(viewProperty, locations.getWithView(), true);
	}

	private static final int LineHeight = 7;
	protected int calculateAttributesHeight(SetDefinition.SetViewProperty viewProperty, Ref withView, boolean full) {
		IndexDefinition definition = dictionary.getIndexDefinition(withView.getDefinition());
		IndexDefinitionBase.IndexViewProperty indexView = definition.getView(withView.getValue());
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = indexView.getShow();
		if (show.getPicture() != null) return 124;
		int size = 60;
		size += show.getLine().size() > 0 ? (LineHeight*countLines(show.getLine().size())) : 0;
		if (full) size += show.getLineBelow().size() > 0 ? (LineHeight*countLines(show.getLineBelow().size())) : 0;
		size += show.getHighlight().size() > 0 ? (LineHeight*countLines(show.getHighlight().size())) : 0;
		if (full) size += show.getFooter().size() > 0 ? (LineHeight*countLines(show.getFooter().size())) : 0;
		return size;
	}

	protected int countLines(int size) {
		if (size <= 3) return 1;
		return Math.round(size/3);
	}

	@Override
	protected boolean hasTemplate(NodeViewProperty viewProperty) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty = ((SetDefinition.SetViewProperty)viewProperty).getShow();
		if (showProperty.getItems() != null) return true;
		if (showProperty.getIndex() != null) return true;
		if (showProperty.getLocations() != null) return true;
		if (showProperty.getSharedPrototypes() != null) return true;
		if (showProperty.getOwnedPrototypes() != null) return true;
		return false;
	}

	private void addShow(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinition.SetViewProperty.ShowProperty showProperty = viewProperty.getShow();
		FrameBuilder result = baseFrame().add("show");
		result.add(typeOf(showProperty));
		result.add("view", nameOf(viewProperty));
		result.add("definition", nameOf(definition()));
		result.add("componentType", componentTypeFrame(viewProperty));
		result.add("datasourceType", datasourceType(showProperty));
		result.add("datasourceAddType", datasourceAddType(showProperty));
		if (showProperty.getItems() != null) addItemsShow(viewProperty, showProperty, result);
		else if (showProperty.getIndex() != null) addIndexShow(viewProperty, showProperty, result);
		else if (showProperty.getOwnedPrototypes() != null) addIndexOwnedPrototypes(viewProperty, showProperty, result);
		else if (showProperty.getLocations() != null) addLocationsShow(viewProperty, showProperty, result);
		addAttributes(viewProperty, result);
		builder.add("show", result);
	}

	private String datasourceType(SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty) {
		if (showProperty.getLocations() != null) return "CollectionMapDatasource";
		else if (showProperty.getOwnedPrototypes() != null) return "NodeOwnedPrototypesDatasource";
		else if (showProperty.getSharedPrototypes() != null) return "NodeSharedPrototypesDatasource";
		return "CollectionDatasource";
	}

	private FrameBuilder datasourceAddType(SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty) {
		FrameBuilder result = new FrameBuilder("datasourceAddType");
		if (showProperty.getLocations() != null) result.add("map");
		return result;
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

	private void addIndexOwnedPrototypes(SetDefinition.SetViewProperty viewProperty, SetDefinitionBase.SetViewPropertyBase.ShowProperty showProperty, FrameBuilder builder) {
		builder.add("reference", DescriptorDefinition.CODE);
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
		else if (show.getOwnedPrototypes() != null) addDescriptorAttributes(viewProperty, builder);
		else if (show.getLocations() != null) addLocationsAttributes(viewProperty, builder);
		if (!hasDetails(show)) builder.add("hasDetails", "false");
	}

	protected boolean hasDetails(SetDefinitionBase.SetViewPropertyBase.ShowProperty showDefinition) {
		if (showDefinition.getIndex() == null) return false;
		Ref withView = showDefinition.getIndex().getWithView();
		IndexDefinition definition = dictionary.getIndexDefinition(withView.getDefinition());
		IndexDefinitionBase.IndexViewProperty indexView = definition.getView(withView.getValue());
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = indexView.getShow();
		return show != null && (!show.getFooter().isEmpty() || !show.getLineBelow().isEmpty());
	}

	private void addItemsAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		builder.add("attribute", attributeTitleFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_LABEL, "Título", 30, "row"));
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_DESCRIPTION, "Descripción", 30, "row"));
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_CREATE_DATE, "Fecha creación", 15, "row"));
		builder.add("attribute", attributeFrame(viewProperty, DescriptorDefinition.ATTRIBUTE_UPDATE_DATE, "Fecha actualización", 15, "row"));
	}

	private boolean isLocations(SetDefinition.SetViewProperty viewProperty) {
		return viewProperty.getShow().getLocations() != null;
	}

	private void addDescriptorAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		DescriptorDefinition definition = new DescriptorDefinition();
		addIndexViewAttribute("title", attributeTitleFrame(viewProperty, definition, new Ref("label"), 1, "item"), builder);
		addIndexViewAttribute("line", attributeFrame(viewProperty, definition, new Ref("create_date"), 1, "item"), builder);
	}

	private void addIndexAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinitionBase.SetViewPropertyBase.ShowProperty.IndexProperty index = viewProperty.getShow().getIndex();
		addIndexViewAttributes(viewProperty, index.getWithView(), builder, true);
	}

	private void addLocationsAttributes(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		LocationsProperty locations = viewProperty.getShow().getLocations();
		addIndexViewAttributes(viewProperty, locations.getWithView(), builder, false);
		builder.add("locations");
	}

	private void addIndexViewAttributes(SetDefinition.SetViewProperty viewProperty, Ref withView, FrameBuilder builder, boolean useNullScope) {
		IndexDefinition definition = dictionary.getIndexDefinition(withView.getDefinition());
		IndexDefinitionBase.IndexViewProperty indexView = definition.getView(withView.getValue());
		IndexDefinitionBase.IndexViewProperty.ShowProperty show = indexView.getShow();
		int countAttributes = RendererHelper.countAttributes(indexView);
		addIndexViewAttribute("title", show.getTitle() != null ? attributeTitleFrame(viewProperty, definition, show.getTitle(), countAttributes, "item") : attributeFrame(viewProperty, definition, new Ref("label"), countAttributes, "item"), builder);
		if (show.getPicture() != null) addIndexViewAttribute("picture", attributeFrame(viewProperty, definition, show.getPicture(), countAttributes, "item"), builder);
		if (show.getIcon() != null) addIndexViewAttribute("icon", attributeFrame(viewProperty, definition, show.getIcon(), countAttributes, "item"), builder);
		show.getHighlight().forEach(h -> addIndexViewAttribute("highlight", attributeFrame(viewProperty, definition, h, countAttributes, "item"), builder));
		show.getLine().forEach(l -> addIndexViewAttribute("line", attributeFrame(viewProperty, definition, l, countAttributes, "item"), builder));
		show.getLineBelow().forEach(lb -> addIndexViewAttribute("lineBelow", attributeFrame(viewProperty, definition, lb, countAttributes, useNullScope ? null : "item"), builder));
		show.getFooter().forEach(f -> addIndexViewAttribute("footer", attributeFrame(viewProperty, definition, f, countAttributes, useNullScope ? null : "item"), builder));
	}

	private void addIndexViewAttribute(String section, FrameBuilder attributeFrame, FrameBuilder builder) {
		builder.add(section, attributeFrame.add(section));
		builder.add("attribute", attributeFrame);
	}

	private void addAnalyze(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		if (viewProperty.getAnalyze() == null) return;
		addDimensions(viewProperty, builder);
		addSortings(viewProperty, builder);
	}

	protected void addDimensions(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinitionBase.SetViewPropertyBase.AnalyzePropertyBase.DimensionProperty dimension = viewProperty.getAnalyze().getDimension();
		if (dimension == null) return;
		Collection<Ref> dimensionList = dimension.getAttribute().stream().collect(Collectors.toMap(Ref::getValue, a -> a, (a1, a2) -> a1)).values();
		dimensionList.forEach(d -> addDimension(d, builder));
	}

	private void addDimension(Ref dimension, FrameBuilder builder) {
		IndexDefinition definition = dictionary.getIndexDefinition(dimension.getDefinition());
		AttributeProperty attributeProperty = definition.getAttribute(dimension.getValue());
		builder.add("dimension", attributeFrame(attributeProperty, "dimension"));
	}

	protected void addSortings(SetDefinition.SetViewProperty viewProperty, FrameBuilder builder) {
		SetDefinitionBase.SetViewPropertyBase.AnalyzePropertyBase.SortingProperty sorting = viewProperty.getAnalyze().getSorting();
		if (sorting == null) return;
		Collection<Ref> sortingList = sorting.getAttribute().stream().collect(Collectors.toMap(Ref::getValue, a -> a, (a1, a2) -> a1)).values();
		sortingList.forEach(d -> addSorting(viewProperty, d, builder));
	}

	private void addSorting(SetDefinition.SetViewProperty viewProperty, Ref sorting, FrameBuilder builder) {
		IndexDefinition definition = dictionary.getIndexDefinition(sorting.getDefinition());
		AttributeProperty attributeProperty = definition.getAttribute(sorting.getValue());
		builder.add("sorting", attributeFrame(attributeProperty, "sorting").add("view", nameOf(viewProperty)));
	}

	private FrameBuilder attributeFrame(AttributeProperty attributeProperty, String type) {
		FrameBuilder result = baseFrame().add(type);
		result.add("name", attributeProperty.getName());
		result.add("code", attributeProperty.getCode());
		result.add("label", clean(attributeProperty.getLabel()));
		result.add("type", RendererHelper.dimensionTypeOf(attributeProperty));
		return result;
	}

	private FrameBuilder attributeFrame(SetDefinition.SetViewProperty viewProperty, IndexDefinition definition, Ref attribute, int countAttributes, String scope) {
		AttributeProperty attributeProperty = definition.getAttribute(attribute.getValue());
		FrameBuilder result = baseFrame().add("attribute");
		result.add("reference", attributeProperty != null ? "reference" : "node.getReference()");
		if (attributeProperty == null) attributeProperty = new DescriptorDefinition().getAttribute(attribute.getValue());
		result.add(attributeProperty.getType().name().toLowerCase());
		if (scope != null) result.add("scope", scope);
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		result.add("name", normalize(attributeProperty.getName()));
		result.add("shortName", shortName(viewProperty, attributeProperty));
		result.add("code", attributeProperty.getCode());
		result.add("label", clean(attributeProperty.getLabel()));
		result.add("type", RendererHelper.attributeTypeOf(attributeProperty));
		result.add("width", countAttributes > 0 ? Math.round(100.0/countAttributes) : 0);
		if (RendererHelper.attributeTypeOf(attributeProperty).equalsIgnoreCase("Text")) result.add("cropWithEllipsis",140);
		return result;
	}

	private FrameBuilder attributeTitleFrame(SetDefinition.SetViewProperty viewProperty, IndexDefinition definition, Ref attribute, int countAttributes, String scope) {
		FrameBuilder result = attributeFrame(viewProperty, definition, attribute, countAttributes, scope);
		if (isLocations(viewProperty)) result.add("location");
		return result;
	}

	private FrameBuilder attributeFrame(NodeViewProperty viewProperty, String key, String label, int width, String scope) {
		FrameBuilder result = baseFrame().add("attribute");
		result.add(typeOf(viewProperty));
		if (scope != null) result.add("scope", scope);
		result.add("reference", !viewProperty.getCode().equals(DescriptorDefinition.CODE) ? "reference" : "node.getReference()");
		result.add("definition", nameOf(definition()));
		result.add("view", nameOf(viewProperty));
		result.add("name", normalize(key));
		result.add("shortName", shortName(viewProperty, normalize(key)));
		result.add("code", key);
		result.add("label", clean(label));
		result.add("width", width);
		return result;
	}

	private FrameBuilder attributeTitleFrame(NodeViewProperty viewProperty, String key, String label, int width, String scope) {
		FrameBuilder result = attributeFrame(viewProperty, key, label, width, scope);
		if (!(viewProperty instanceof SetDefinition.SetViewProperty)) return result;
		if (isLocations((SetDefinition.SetViewProperty) viewProperty)) result.add("location");
		return result;
	}

	private String shortName(SetDefinition.SetViewProperty viewProperty, AttributeProperty attributeProperty) {
		return shortName(viewProperty, normalize(attributeProperty.getName()));
	}

	private String shortName(NodeViewProperty viewProperty, String attributeName) {
		String name = nameOf(definition());
		String viewName = nameOf(viewProperty);
		return RendererHelper.shortName(name) + RendererHelper.shortName(viewName) + attributeName;
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

	private void writeFiltersTemplates() {
		definition().getViewDefinitionList().stream().filter(this::hasTemplate).forEach(this::writeFiltersTemplate);
	}

	private void writeFiltersTemplate(NodeViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view).add("filter");
		File file = new File(javaPackage() + nameOf(definition()) + StringUtil.firstUpperCase(nameOf(view)) + "FiltersTemplate.java");
		writeFrame(file, javaTemplate().render(viewFrame.toFrame()));
	}
}
