package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.Renderer;
import io.intino.itrules.FrameBuilder;
import org.monet.metamodel.*;
import org.monet.metamodel.TextFieldProperty.EditionProperty.ModeEnumeration;
import org.monet.metamodel.internal.Ref;

public class FieldRenderer extends Renderer {
	private final FieldProperty fieldProperty;
	private CompositeFieldProperty parentProperty;

	public FieldRenderer(Dictionary dictionary, Modernization modernization, FieldProperty fieldProperty) {
		super(dictionary, modernization);
		this.fieldProperty = fieldProperty;
	}

	public FieldRenderer parent(CompositeFieldProperty composite) {
		this.parentProperty = composite;
		return this;
	}

	@Override
	public void write() {
	}

	protected FrameBuilder buildFrame() {
		FrameBuilder result = baseFrame().add("field");
		result.add("code", fieldProperty.getCode());
		result.add("name", fieldProperty.getName());
		result.add("label", clean(fieldProperty.getLabel()));
		result.add("type", type());
		result.add("readonly", fieldProperty.isReadonly() ? "true" : "readonly");
		addTypes(result);
		addMultipleProperties(result);
		addTextProperties(result);
		addLinkProperties(result);
		addCompositeProperties(result);
		return result;
	}

	private void addTypes(FrameBuilder builder) {
		builder.add(type());
		if (fieldProperty.isMultiple()) builder.add("multiple");
	}

	private void addMultipleProperties(FrameBuilder builder) {
		if (!fieldProperty.isMultiple()) return;
		MultipleableFieldProperty multipleField = (MultipleableFieldProperty) fieldProperty;
		MultipleableFieldProperty.BoundaryProperty boundary = multipleField.getBoundary();
		builder.add("min", boundary != null ? boundary.getMin() : -1L);
		builder.add("max", boundary != null ? boundary.getMax() : -1L);
		builder.add("valueType", valueType(multipleField));
	}

	private String valueType(MultipleableFieldProperty field) {
		if (field instanceof TextFieldProperty || field instanceof MemoFieldProperty) return "java.lang.String";
		if (field instanceof NumberFieldProperty) return "org.monet.bpi.types.Number";
		if (field instanceof DateFieldProperty) return "org.monet.bpi.types.Date";
		if (field instanceof FileFieldProperty) return "org.monet.bpi.types.File";
		if (field instanceof PictureFieldProperty) return "org.monet.bpi.types.Picture";
		if (field instanceof LinkFieldProperty) return "org.monet.bpi.types.Link";
		if (field instanceof SelectFieldProperty) return "org.monet.bpi.types.Term";
		if (field instanceof NodeFieldProperty || field instanceof CompositeFieldProperty) return "java.util.List<org.monet.bpi.Field<?>>";
		return null;
	}

	private void addTextProperties(FrameBuilder builder) {
		if (!fieldProperty.isText()) return;
		TextFieldProperty textField = (TextFieldProperty) fieldProperty;
		TextFieldProperty.EditionProperty edition = textField.getEdition();
		if (edition == null) return;
		ModeEnumeration mode = edition.getMode();
		if (mode == ModeEnumeration.UPPERCASE) builder.add("textMode", "Uppercase");
		else if (mode == ModeEnumeration.LOWERCASE) builder.add("textMode", "Lowercase");
		else if (mode == ModeEnumeration.TITLE) builder.add("textMode", "Capitalize");
	}

	private void addLinkProperties(FrameBuilder builder) {
		if (!fieldProperty.isLink()) return;
		LinkFieldProperty linkField = (LinkFieldProperty) fieldProperty;
		Ref index = linkField.getSource().getIndex();
		Ref view = linkField.getSource().getView();
		IndexDefinition definition = dictionary.getIndexDefinition(index.getValue());
		IndexDefinitionBase.IndexViewProperty viewProperty = view != null ? definition.getView(view.getValue()) : definition.getDefaultView();
		builder.add("index", nameOf(definition));
		builder.add("indexCode", definition.getCode());
		builder.add("indexView", viewProperty != null ? nameOf(viewProperty) : (definition.getDefaultView() != null ? nameOf(definition.getDefaultView()) : ""));
	}

	private void addCompositeProperties(FrameBuilder builder) {
		if (!fieldProperty.isComposite()) return;
		CompositeFieldProperty compositeField = (CompositeFieldProperty) fieldProperty;
		compositeField.getAllFieldPropertyList().forEach(f -> {
			FieldRenderer renderer = renderer(f, compositeField);
			builder.add("field", renderer.buildFrame());
		});
	}

	private String type() {
		if (fieldProperty instanceof TextFieldProperty) return "text";
		if (fieldProperty instanceof NumberFieldProperty) return "number";
		if (fieldProperty instanceof BooleanFieldProperty) return "boolean";
		if (fieldProperty instanceof DateFieldProperty) return "date";
		if (fieldProperty instanceof MemoFieldProperty) return "memo";
		if (fieldProperty instanceof SerialFieldProperty) return "serial";
		if (fieldProperty instanceof FileFieldProperty) return "file";
		if (fieldProperty instanceof PictureFieldProperty) return "picture";
		if (fieldProperty instanceof CheckFieldProperty) return "check";
		if (fieldProperty instanceof LinkFieldProperty) return "link";
		if (fieldProperty instanceof SelectFieldProperty) return "select";
		if (fieldProperty instanceof CompositeFieldProperty) return "composite";
		if (fieldProperty instanceof NodeFieldProperty) return "node";
		if (fieldProperty instanceof SummationFieldProperty) return "summation";
		return "";
	}

}
