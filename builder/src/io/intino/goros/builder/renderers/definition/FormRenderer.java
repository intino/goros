package io.intino.goros.builder.renderers.definition;

import io.intino.goros.builder.Modernization;
import io.intino.goros.builder.monet.Dictionary;
import io.intino.goros.builder.renderers.DefinitionRenderer;
import io.intino.goros.builder.renderers.templates.java.FormTemplate;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.Template;
import org.monet.metamodel.*;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty;
import org.monet.metamodel.FormDefinitionBase.FormViewProperty.ShowProperty;
import org.monet.metamodel.internal.Ref;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.intino.goros.builder.util.StringUtil.firstUpperCase;

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
		FrameBuilder result = baseFrame().add("nodeview");
		result.add(typeOf(viewProperty));
		NodeDefinition definition = definition();
		result.add("definition", nameOf(definition));
		result.add("label", viewProperty.getLabel());
		result.add("name", nameOf(viewProperty));
		result.add("code", viewProperty.getCode());
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
		return new io.intino.goros.builder.renderers.templates.konos.FormTemplate();
	}

	@Override
	protected Template javaTemplate() {
		return new io.intino.goros.builder.renderers.templates.java.FormTemplate();
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
			addField(f, result);
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
		ShowProperty showProperty = ((FormViewProperty)viewProperty).getShow();
		if (showProperty.getField().size() <= 0) return false;
		return showProperty.getField().stream().anyMatch(ref -> fieldProperty(ref).isComposite() || fieldProperty(ref).isNode());
	}

	private void addRecentTaskShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> taskList = showProperty.getRecentTask().getTask();
		if (taskList.size() <= 0) return;
		TaskDefinition definition = dictionary.getTaskDefinition(taskList.get(0).getValue());
		builder.add("taskName", nameOf(definition));
		builder.add("taskCode", definition.getCode());
	}

	private void addFieldShow(FormViewProperty viewProperty, ShowProperty showProperty, FrameBuilder builder) {
		ArrayList<Ref> fieldList = showProperty.getField();
		fieldList.forEach(ref -> addField(fieldProperty(ref), builder));
	}

	private void addField(FieldProperty fieldProperty, FrameBuilder builder) {
		builder.add("field", new FieldRenderer(dictionary, modernization, fieldProperty).buildFrame().add("definition", nameOf(definition())));
	}

}
