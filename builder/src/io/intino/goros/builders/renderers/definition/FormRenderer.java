package io.intino.goros.builders.renderers.definition;

import io.intino.goros.builders.Modernization;
import io.intino.goros.builders.monet.Dictionary;
import io.intino.goros.builders.renderers.templates.java.FormTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.bpi.java.ActivityImpl;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty.ShowProperty;
import org.monet.metamodel.internal.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.intino.goros.builders.util.StringUtil.firstUpperCase;

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
		addCompositeViews(result);
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
		return new io.intino.goros.builders.renderers.templates.konos.FormTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.builders.renderers.templates.java.FormTemplate();
	}

	private void writeCompositeFieldsTemplate() {
		definition().getViewList().stream().filter(view -> {
			ArrayList<Ref> field = view.getShow().getField();
			return field != null && field.stream().anyMatch(ref -> fieldProperty(ref) instanceof CompositeFieldProperty);
		}).forEach(view -> {
			Stream<FieldProperty> compositeStream = view.getShow().getField().stream().map(this::fieldProperty).filter(f -> f instanceof CompositeFieldProperty);
			compositeStream.forEach(composite -> writeCompositeFieldTemplate((CompositeFieldProperty) composite));
		});
	}

	private void writeCompositeFieldTemplate(CompositeFieldProperty field) {
		resetAddedDisplays();
		FrameBuilder viewFrame = compositeViewFrame(field, new FrameBuilder());
		File file = new File(javaPackage() + nameOf(definition()) + firstUpperCase(field.getName()) + "Template.java");
		writeFrame(file, new FormTemplate().render(viewFrame.toFrame()));
		field.getAllFieldPropertyList().stream().filter(FieldProperty::isComposite).forEach(f -> writeCompositeFieldTemplate((CompositeFieldProperty) f));
	}

	private void addCompositeViews(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow().getField().size() > 0).forEach(v -> {
			ArrayList<Ref> fieldList = v.getShow().getField();
			fieldList.stream().filter(r -> fieldProperty(r) instanceof CompositeFieldProperty).map(this::fieldProperty).forEach(f -> addCompositeView((CompositeFieldProperty) f, builder));
		});
	}

	private void addCompositeView(CompositeFieldProperty fieldProperty, FrameBuilder builder) {
		builder.add("compositeview", compositeViewFrame(fieldProperty, builder));
	}

	private FrameBuilder compositeViewFrame(CompositeFieldProperty fieldProperty, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("compositeview");
		FormDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", fieldProperty.getLabel());
		result.add("name", fieldProperty.getName());
		if (fieldProperty.isMultiple()) {
			result.add("implements", "io.intino.alexandria.ui.displays.components.editable.Editable");
			result.add("editable", new FrameBuilder("editable"));
		}
		addDisplayFor(fieldProperty, builder);
		fieldProperty.getAllFieldPropertyList().forEach(f -> {
			if (f instanceof CompositeFieldProperty) addCompositeView((CompositeFieldProperty) f, builder);
			addField(f, fieldProperty, result);
		});
		return result;
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
		else if (showProperty.getLayout() != null) {
			builder.add("updateFields", baseFrame().add("updateFields"));
			addLayoutShow(viewProperty, showProperty, result);
		}
		else if (showProperty.getField().size() > 0) {
			builder.add("updateFields", baseFrame().add("updateFields"));
			addFieldShow(viewProperty, showProperty, result);
		}
		builder.add("show", result);
	}

	private void addDisplayProvider(FormViewProperty viewProperty, FrameBuilder builder) {
		resetAddedDisplays();
		if (!isDisplayProvider(viewProperty)) return;
		FrameBuilder result = new FrameBuilder("displayProvider");
		List<FieldProperty> fieldList = viewProperty.getShow().getField().stream().map(this::fieldProperty).filter(field -> field.isComposite() || field.isNode()).collect(Collectors.toList());
		fieldList.forEach(f -> addDisplayFor(f, result));
		builder.add("implements", "io.intino.goros.box.ui.DisplayProvider");
		builder.add("displayProvider", result);
	}

	private boolean isDisplayProvider(FormViewProperty viewProperty) {
		ShowProperty showProperty = viewProperty.getShow();
		if (showProperty.getField().size() <= 0) return false;
		return showProperty.getField().stream().anyMatch(ref -> fieldProperty(ref).isComposite() || fieldProperty(ref).isNode());
	}

	private void addRecentTaskShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> taskList = showProperty.getRecentTask().getTask();
		List<TaskDefinition> definitionList = taskList.size() <= 0 ? findTaskDefinitionsWith(definition()) : taskList.stream().map(ref -> dictionary.getTaskDefinition(ref.getValue())).collect(Collectors.toList());
		definitionList.forEach(d -> addRecentTaskType(d, builder));
	}

	private void addFieldShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> fieldList = showProperty.getField();
		fieldList.forEach(ref -> addField(fieldProperty(ref), null, builder));
	}

	private void addLayoutShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		LayoutDefinition definition = this.dictionary.getLayoutDefinition(showProperty.getLayout());
		String width = definition.getWidth();
		String height = definition.getHeight();
		if (width == null && height == null) builder.add("relativeFacet", sizeFacetFrame("relative", "90", null));
		else if (isUnitRelative(width) || isUnitRelative(height)) builder.add("relativeFacet", relativeFacetFrame(definition));
		else builder.add("absoluteFacet", absoluteFacetFrame(definition));
		builder.add("width", definition.getWidth() != null ? definition.getWidth() : "100%");
		rowsOf(definition.getElements()).forEach(row -> addLayoutRow(row, null, builder));
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

	private void addLayoutRow(List<LayoutElementDefinition> row, CompositeFieldProperty composite, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("layoutRow");
		row.forEach(e -> addLayoutElement(e, composite, result));
		builder.add("row", result);
	}

	private void addLayoutElement(LayoutElementDefinition element, CompositeFieldProperty composite, FrameBuilder builder) {
		FrameBuilder result = baseFrame().add("layoutElement");
		result.add(typeOf(element));
		addLayoutSizeToElement(element, result);
		if (element.isSection()) {
			LayoutElementSectionDefinition section = (LayoutElementSectionDefinition) element;
			result.add("label", section.getLabel());
			rowsOf(section.getElements()).forEach(r -> addLayoutRow(r, composite, result));
		}
		else if (element.isBox()) {
			LayoutElementBoxDefinition box = (LayoutElementBoxDefinition) element;
			result.add("field", renderer(definition().getField(box.getLink()), composite).buildFrame().add("definition", nameOf(definition())));
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

	private void addField(FieldProperty fieldProperty, CompositeFieldProperty composite, FrameBuilder builder) {
		builder.add("field", renderer(fieldProperty, composite).buildFrame().add("definition", nameOf(definition())));
	}

	private FieldRenderer renderer(FieldProperty fieldProperty, CompositeFieldProperty composite) {
		FieldRenderer renderer = new FieldRenderer(dictionary, modernization, fieldProperty);
		renderer.parent(composite);
		return renderer;
	}

}
