package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.templates.konos.FormTemplate;
import io.intino.goros.modernizing.monet.util.StringUtil;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty.ShowProperty;
import org.monet.metamodel.internal.*;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FormRenderer extends NodeRenderer<FormDefinition> {

	public FormRenderer(Dictionary dictionary, Modernization modernization, FormDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		super.write();
		writeCompositeFieldsTemplate();
	}

	@Override
	protected FrameBuilder buildFrame() {
		FrameBuilder result = super.buildFrame().add("formdefinition");
		addCompositeFieldsTemplates(result);
		return result;
	}

	@Override
	protected FrameBuilder viewFrame(NodeViewProperty viewProperty) {
		FrameBuilder result = baseViewFrame(viewProperty);
		addShow((FormViewProperty) viewProperty, result);
		addDisplayProvider((FormViewProperty) viewProperty, result);
		return result;
	}

	@Override
	protected boolean hasTemplate(NodeViewProperty viewProperty) {
		ShowProperty showProperty = ((FormViewProperty)viewProperty).getShow();
		if (showProperty.getField().size() > 0) return true;
		else if (showProperty.getAttachments() != null) return true;
		else if (showProperty.getRecentTask() != null) return true;
		else if (showProperty.getLayout() != null) return true;
		else if (showProperty.getRevisions() != null) return true;
		else if (showProperty.getLocation() != null) return true;
		else return showProperty.getLayoutExtended() != null;
	}

	@Override
	protected boolean isVisibleOnRevision(NodeViewProperty viewProperty) {
		ShowProperty showProperty = ((FormViewProperty)viewProperty).getShow();
		return showProperty.getLayout() != null || showProperty.getLayoutExtended() != null ||
				showProperty.getAttachments() != null || showProperty.getField().size() > 0;
	}

	@Override
	protected Template konosTemplate() {
		return new FormTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.modernizing.monet.renderers.templates.java.FormTemplate();
	}

	private void writeCompositeFieldsTemplate() {
//		definition().getViewList().stream().filter(view -> {
//			ArrayList<Ref> field = view.getShow().getField();
//			return field != null && field.stream().anyMatch(ref -> fieldProperty(ref) instanceof CompositeFieldProperty);
//		}).forEach(view -> {
//			Stream<FieldProperty> compositeStream = view.getShow().getField().stream().map(this::fieldProperty).filter(f -> f instanceof CompositeFieldProperty);
//			compositeStream.forEach(composite -> writeCompositeFieldTemplate((CompositeFieldProperty) composite));
//		});
		definition().getCompositeFieldPropertyList().forEach(this::writeCompositeFieldTemplate);
	}

	private void writeCompositeFieldTemplate(CompositeFieldProperty field) {
		resetAddedDisplays();
		FrameBuilder viewFrame = compositeViewFrame(field, new FrameBuilder());
		File file = new File(javaPackage() + nameOf(definition()) + StringUtil.firstUpperCase(field.getName()) + "Template.java");
		writeFrame(file, new io.intino.goros.modernizing.monet.renderers.templates.java.FormTemplate().render(viewFrame.toFrame()));
		field.getCompositeFieldPropertyList().forEach(this::writeCompositeFieldTemplate);
	}

	private void addCompositeFieldsTemplates(FrameBuilder builder) {
		definition().getCompositeFieldPropertyList().forEach(f -> addCompositeView(f, builder));
	}

	private void addCompositeView(CompositeFieldProperty fieldProperty, FrameBuilder builder) {
		builder.add("compositeview", compositeViewFrame(fieldProperty, builder));
	}

	private FrameBuilder compositeViewFrame(CompositeFieldProperty fieldProperty, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("compositeview");
		FormDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", clean(fieldProperty.getLabel()));
		result.add("name", fieldProperty.getName());
		addDisplayProvider(fieldProperty, result);
		if (fieldProperty.isMultiple()) {
			result.add("implements", "io.intino.alexandria.ui.displays.components.editable.Editable");
			result.add("editable", new FrameBuilder("editable"));
		}
		addDisplayFor(fieldProperty, builder);
		addShow(fieldProperty, result);
		fieldProperty.getAllFieldPropertyList().forEach(f -> {
			if (f instanceof CompositeFieldProperty) addCompositeView((CompositeFieldProperty) f, builder);
			addField(f, fieldProperty, null, result);
		});
		return result;
	}

	private FieldProperty fieldProperty(Ref ref, CompositeFieldProperty field) {
		return field.getAllFieldPropertyList().stream().filter(fd -> {
			String key = ref.getValue();
			return fd.getCode().equals(key) || fd.getName().equals(key);
		}).findFirst().orElse(null);
	}

	private FieldProperty fieldProperty(Ref ref) {
		return definition().getAllFieldPropertyList().stream().filter(fd -> {
			String key = ref.getValue();
			return fd.getCode().equals(key) || fd.getName().equals(key);
		}).findFirst().orElse(null);
	}

	private void addShow(FormViewProperty viewProperty, FrameBuilder builder) {
		ShowProperty showProperty = viewProperty.getShow();
		FrameBuilder result = baseFrame().add("show");
		result.add(typeOf(showProperty));
		result.add("view", nameOf(viewProperty));
		result.add("definition", nameOf(definition()));
		if (showProperty.getRecentTask() != null) addRecentTaskShow(viewProperty, showProperty, result);
		else if (showProperty.getLocation() != null) addLocationShow(viewProperty, showProperty, result);
		else if (showProperty.getLayout() != null) {
			builder.add("updateFields", baseFrame().add("updateFields"));
			addLayoutShow(viewProperty, result);
		}
		else if (showProperty.getField().size() > 0) {
			builder.add("updateFields", baseFrame().add("updateFields"));
			addFieldShow(viewProperty, result);
		}
		builder.add("show", result);
	}

	private void addShow(CompositeFieldProperty field, FrameBuilder builder) {
		CompositeFieldPropertyBase.ViewProperty viewProperty = field.getView();
		CompositeFieldPropertyBase.ViewProperty.ShowProperty showProperty = viewProperty != null ? viewProperty.getShow() : null;
		FrameBuilder result = baseFrame().add("show").add("composite");
		result.add(typeOf(showProperty));
		result.add("view", nameOf(definition()));
		result.add("definition", nameOf(definition()));
		builder.add("updateFields", baseFrame().add("updateFields"));
		if (showProperty == null) addFieldShow(field.getAllFieldPropertyList(), field, result);
		else if (showProperty.getLayout() != null) addLayoutShow(viewProperty, result);
		else if (fields(showProperty).size() > 0) addFieldShow(field, viewProperty, result);
		builder.add("show", result);
	}

	private List<Ref> fields(CompositeFieldPropertyBase.ViewProperty.ShowProperty showProperty) {
		List<Ref> fieldList = showProperty.getField();
		Map<String, Ref> result = new LinkedHashMap<>();
		fieldList.forEach(f -> result.put(f.getValue(), f));
		return new ArrayList<>(result.values());
	}

	private void addDisplayProvider(CompositeFieldProperty fieldProperty, FrameBuilder builder) {
		resetAddedDisplays();
		if (!isDisplayProvider(fieldProperty)) return;
		FrameBuilder result = new FrameBuilder("displayProvider");
		List<FieldProperty> fieldList = fieldProperty.getAllFieldPropertyList().stream().filter(field -> field.isComposite() || field.isNode()).collect(Collectors.toList());
		fieldList.forEach(f -> addDisplayFor(f, result));
		builder.add("implements", "io.intino.goros.unit.box.ui.DisplayProvider");
		builder.add("displayProvider", result);
	}

	private void addDisplayProvider(FormViewProperty viewProperty, FrameBuilder builder) {
		resetAddedDisplays();
		if (!isDisplayProvider(viewProperty)) return;
		FrameBuilder result = new FrameBuilder("displayProvider");
		List<FieldProperty> fieldList = viewProperty.getShow().getField().stream().map(this::fieldProperty).filter(field -> field.isComposite() || field.isNode()).collect(Collectors.toList());
		fieldList.forEach(f -> addDisplayFor(f, result));
		builder.add("implements", "io.intino.goros.unit.box.ui.DisplayProvider");
		builder.add("displayProvider", result);
	}

	private boolean isDisplayProvider(FormViewProperty viewProperty) {
		ShowProperty showProperty = viewProperty.getShow();
		if (showProperty.getField().size() <= 0) return false;
		return showProperty.getField().stream().anyMatch(ref -> fieldProperty(ref).isComposite() || fieldProperty(ref).isNode());
	}

	private boolean isDisplayProvider(CompositeFieldProperty fieldProperty) {
		return fieldProperty.getAllFieldPropertyList().stream().anyMatch(field -> field.isComposite() || field.isNode());
	}

	private void addRecentTaskShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> taskList = showProperty.getRecentTask().getTask();
		List<TaskDefinition> definitionList = taskList.size() <= 0 ? findTaskDefinitionsWith(definition()) : taskList.stream().map(ref -> dictionary.getTaskDefinition(ref.getValue())).collect(Collectors.toList());
		definitionList.forEach(d -> addRecentTaskType(d, builder));
	}

	private void addLocationShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		// TODO
	}

	private void addFieldShow(FormViewProperty viewProperty, FrameBuilder builder) {
		viewProperty.getShow().getField().forEach(ref -> addField(fieldProperty(ref), null, viewProperty, builder));
	}

	private void addFieldShow(CompositeFieldProperty field, CompositeFieldPropertyBase.ViewProperty viewProperty, FrameBuilder builder) {
		fields(viewProperty.getShow()).forEach(ref -> addField(fieldProperty(ref, field), field, null, builder));
	}

	private void addFieldShow(List<FieldProperty> fieldList, CompositeFieldProperty compositeField, FrameBuilder builder) {
		fieldList.forEach(field -> addField(field, compositeField, null, builder));
	}

	private void addLayoutShow(FormViewProperty viewProperty, FrameBuilder builder) {
		addLayoutShow(this.dictionary.getLayoutDefinition(viewProperty.getShow().getLayout()), viewProperty, builder);
	}

	private void addLayoutShow(CompositeFieldPropertyBase.ViewProperty viewProperty, FrameBuilder builder) {
		addLayoutShow(this.dictionary.getLayoutDefinition(viewProperty.getShow().getLayout()), null, builder);
	}

	private void addLayoutShow(LayoutDefinition definition, FormDefinition.FormViewProperty viewProperty, FrameBuilder builder) {
		String width = definition.getWidth();
		String height = definition.getHeight();
		if (width == null && height == null) builder.add("relativeFacet", sizeFacetFrame("relative", "90", null));
		else if (isUnitRelative(width) || isUnitRelative(height)) builder.add("relativeFacet", relativeFacetFrame(definition));
		else builder.add("absoluteFacet", absoluteFacetFrame(definition));
		builder.add("width", definition.getWidth() != null ? definition.getWidth() : "100%");
		rowsOf(definition.getElements()).forEach(row -> addLayoutRow(row, null, viewProperty, builder));
	}

	private List<List<LayoutElementDefinition>> rowsOf(List<LayoutElementDefinition> elements) {
		List<List<LayoutElementDefinition>> result = new ArrayList<>();
		int index = -1;
		for (LayoutElementDefinition element : elements) {
			if (element.isBreak() || index == -1) index++;
			if (result.size() <= index) result.add(new ArrayList<>());
			if (element.isBreak()) continue;
			result.get(index).add(element);
		}
		return result;
	}

	private void addLayoutRow(List<LayoutElementDefinition> row, CompositeFieldProperty composite, FormDefinition.FormViewProperty viewProperty, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("layoutRow");
		row.forEach(e -> addLayoutElement(e, composite, viewProperty, result));
		builder.add("row", result);
	}

	private void addLayoutElement(LayoutElementDefinition element, CompositeFieldProperty composite, FormDefinition.FormViewProperty viewProperty, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("layoutElement");
		result.add(typeOf(element));
		addLayoutSizeToElement(element, result);
		if (element.isSection()) {
			LayoutElementSectionDefinition section = (LayoutElementSectionDefinition) element;
			result.add("label", clean(section.getLabel()));
			rowsOf(section.getElements()).forEach(r -> addLayoutRow(r, composite, viewProperty, result));
		}
		else if (element.isBox()) {
			LayoutElementBoxDefinition box = (LayoutElementBoxDefinition) element;
			FormDefinition definition = definition();
			FieldProperty field = definition.getField(box.getLink());
			if (field != null) result.add("field", renderer(definition, definition.getField(box.getLink()), composite).view(viewProperty).buildFrame().add("definition", nameOf(definition)));
		}
		builder.add("element", result);
	}

	private void addLayoutSizeToElement(LayoutElementDefinition element, FrameBuilder builder) {
		float width = element.getWidth();
		float height = element.getHeight();
		if (width == 0 && height == 0) return;
		boolean relative = isUnitRelative(element.getHeightUnit()) || isUnitRelative(element.getWidthUnit());
		FrameBuilder result = sizeFacetFrame(relative ? "relative" : "absolute", toString(element.getWidth()), toString(element.getHeight()));
		builder.add(relative ? "relativeFacet" : "absoluteFacet", result);
	}

	private boolean isUnitRelative(String unit) {
		return unit != null && (unit.isEmpty() || unit.contains("%"));
	}

	private String toString(float value) {
		return value != 0 ? String.valueOf(value) : null;
	}

	private String typeOf(LayoutElementDefinition element) {
		if (element.isSection()) return "section";
		if (element.isSpace()) return "space";
		return "box";
	}

	private FrameBuilder absoluteFacetFrame(LayoutDefinition definition) {
		return sizeFacetFrame("absolute", definition.getWidth(), definition.getHeight());
	}

	private FrameBuilder relativeFacetFrame(LayoutDefinition definition) {
		return sizeFacetFrame("relative", definition.getWidth(), definition.getHeight());
	}

	private FrameBuilder sizeFacetFrame(String type, String width, String height) {
		FrameBuilder result = baseFrame().add(type + "Facet");
		if (width != null) result.add("width", clean(width));
		if (height != null) result.add("height", clean(height));
		return result;
	}

	private String clean(String size) {
		return size.replace("px", "").replace("%", "");
	}

	private void addField(FieldProperty fieldProperty, CompositeFieldProperty composite, FormDefinition.FormViewProperty viewProperty, FrameBuilder builder) {
		builder.add("field", renderer(definition(), fieldProperty, composite).view(viewProperty).buildFrame().add("definition", nameOf(definition())));
	}

}
