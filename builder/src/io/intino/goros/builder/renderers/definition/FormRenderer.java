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
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.intino.goros.builder.util.StringUtil.firstUpperCase;

public class FormRenderer extends DefinitionRenderer<FormDefinition> {

	public FormRenderer(Dictionary dictionary, Modernization modernization, FormDefinition definition) {
		super(dictionary, modernization, definition);
	}

	@Override
	public void write() {
		super.write();
		writeEmbeddedTemplate();
		writeViewsTemplate();
		writeCompositeFieldsTemplate();
	}

	@Override
	protected FrameBuilder buildFrame() {
		FrameBuilder result = baseDefinitionFrame().add("form");
		if (definition().isSingleton()) result.add("singleton");
		addViews(result);
		addCompositeViews(result);
		return result;
	}

	private void writeEmbeddedTemplate() {
		resetAddedDisplays();
		FrameBuilder builder = buildFrame().add("embedded");
		File file = new File(javaPackage() + nameOf(definition()) + "EmbeddedTemplate.java");
		writeFrame(file, new FormTemplate().render(builder.toFrame()));
	}

	private void writeViewsTemplate() {
		definition().getViewList().stream().filter(this::hasTemplate).forEach(this::writeViewTemplate);
	}

	private boolean hasTemplate(FormDefinitionBase.FormViewProperty viewProperty) {
		ShowProperty showProperty = viewProperty.getShow();
		if (showProperty.getField() != null) return true;
		else if (showProperty.getAttachments() != null) return true;
		else if (showProperty.getRecentTask() != null) return true;
		else if (showProperty.getLayout() != null) return true;
		else if (showProperty.getLayoutExtended() != null) return true;
		else if (showProperty.getTasks() != null) return true;
		return false;
	}

	private void writeViewTemplate(FormDefinitionBase.FormViewProperty view) {
		resetAddedDisplays();
		FrameBuilder viewFrame = viewFrame(view);
		File file = new File(javaPackage() + nameOf(definition()) + nameOf(view) + "ViewTemplate.java");
		writeFrame(file, new FormTemplate().render(viewFrame.toFrame()));
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

	private void addViews(FrameBuilder builder) {
		definition().getViewList().forEach(v -> addView(v, builder));
	}

	private void addCompositeViews(FrameBuilder builder) {
		definition().getViewList().stream().filter(v -> v.getShow().getField() != null).forEach(v -> {
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
			addField(f, result);
		});
		return result;
	}

	private void addView(FormDefinitionBase.FormViewProperty viewProperty, FrameBuilder builder) {
		builder.add("view", viewFrame(viewProperty));
	}

	private FrameBuilder viewFrame(FormDefinitionBase.FormViewProperty viewProperty) {
		FrameBuilder result = baseFrame().add("nodeview");
		result.add(typeOf(viewProperty));
		FormDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", viewProperty.getLabel());
		result.add("name", nameOf(viewProperty));
		addShow(viewProperty, result);
		addDisplayProvider(viewProperty, result);
		return result;
	}

	private void addDisplayProvider(FormDefinitionBase.FormViewProperty viewProperty, FrameBuilder builder) {
		resetAddedDisplays();
		if (!isDisplayProvider(viewProperty)) return;
		FrameBuilder result = new FrameBuilder("displayProvider");
		List<FieldProperty> fieldList = viewProperty.getShow().getField().stream().map(this::fieldProperty).filter(field -> field.isComposite() || field.isNode()).collect(Collectors.toList());
		fieldList.forEach(f -> addDisplayFor(f, result));
		builder.add("implements", "io.intino.goros.box.ui.DisplayProvider");
		builder.add("displayProvider", result);
	}

	private void addDisplayFor(FieldProperty field, FrameBuilder builder) {
		if (field instanceof CompositeFieldProperty) ((CompositeFieldProperty)field).getAllFieldPropertyList().forEach(f -> addDisplayFor(f, builder));
		else if (field instanceof NodeFieldProperty) {
			List<NodeDefinition> nodeDefinitionList = nodeDefinitions(((NodeFieldProperty)field));
			nodeDefinitionList.forEach(definition -> addDisplayFor(definition, (NodeViewProperty)null, builder));
		}
	}

	private List<NodeDefinition> nodeDefinitions(NodeFieldProperty field) {
		List<NodeDefinition> result = new ArrayList<>();
		if (field.getContain() != null) result.add(dictionary.getNodeDefinition(field.getContain().getNode().getValue()));
		if (field.getAdd() != null) field.getAdd().getNode().forEach(ref -> result.add(dictionary.getNodeDefinition(ref.getValue())));
		return result;
	}

	private boolean isDisplayProvider(FormDefinitionBase.FormViewProperty viewProperty) {
		ShowProperty showProperty = viewProperty.getShow();
		if (showProperty.getField() == null || showProperty.getField().size() <= 0) return false;
		return showProperty.getField().stream().anyMatch(ref -> fieldProperty(ref).isComposite() || fieldProperty(ref).isNode());
	}

	private void addShow(FormDefinitionBase.FormViewProperty viewProperty, FrameBuilder builder) {
		ShowProperty showProperty = viewProperty.getShow();
		FrameBuilder result = new FrameBuilder("show");
		result.add(typeOf(showProperty));
		if (showProperty.getRecentTask() != null) addRecentTaskShow(viewProperty, showProperty, result);
		else if (showProperty.getField() != null) addFieldShow(viewProperty, showProperty, result);
		builder.add("show", result);
	}

	private void addRecentTaskShow(FormDefinitionBase.FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> taskList = showProperty.getRecentTask().getTask();
		if (taskList.size() <= 0) return;
		TaskDefinition definition = dictionary.getTaskDefinition(taskList.get(0).getValue());
		builder.add("taskName", nameOf(definition));
		builder.add("taskCode", definition.getCode());
	}

	private void addFieldShow(FormDefinitionBase.FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> fieldList = showProperty.getField();
		fieldList.forEach(ref -> addField(fieldProperty(ref), builder));
	}

	private void addField(FieldProperty fieldProperty, FrameBuilder builder) {
		builder.add("field", new FieldRenderer(dictionary, modernization, fieldProperty).buildFrame().add("definition", nameOf(definition())));
	}

	private FieldProperty fieldProperty(Ref ref) {
		return definition().getAllFieldPropertyList().stream().filter(fd -> {
			String key = ref.getValue();
			return fd.getCode().equals(key) || fd.getName().equals(key);
		}).findFirst().orElse(null);
	}

	@Override
	protected Template konosTemplate() {
		return new io.intino.goros.builder.renderers.templates.konos.FormTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.builder.renderers.templates.java.FormTemplate();
	}

}
