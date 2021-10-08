package io.intino.goros.modernizing.monet.renderers.definition;

import io.intino.goros.modernizing.Modernization;
import io.intino.goros.modernizing.monet.Dictionary;
import io.intino.goros.modernizing.monet.renderers.Renderer;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import org.monet.bpi.FieldSelect;
import org.monet.metamodel.*;
import org.monet.metamodel.DateFieldPropertyBase.PrecisionEnumeration;
import org.monet.metamodel.TextFieldProperty.EditionProperty.ModeEnumeration;
import org.monet.metamodel.internal.Ref;

import java.util.List;
import java.util.stream.Collectors;

public class FieldRenderer extends Renderer {
	private final FieldProperty fieldProperty;
	private FormDefinition formDefinition;
	private CompositeFieldProperty parentProperty;

	public FieldRenderer(Dictionary dictionary, Modernization modernization, FieldProperty fieldProperty) {
		super(dictionary, modernization);
		this.fieldProperty = fieldProperty;
	}

	public FieldRenderer definition(FormDefinition definition) {
		this.formDefinition = definition;
		return this;
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
		result.add("univocal", baseFrame().add("univocal").add(fieldProperty.isUnivocal() ? "prototype" : ""));
		addTypes(result);
		addMultipleProperties(result);
		addTextProperties(result);
		addDateProperties(result);
		addLinkProperties(result);
		addCompositeProperties(result);
		addSelectProperties(result);
		return result;
	}

	private void addSelectProperties(FrameBuilder result) {
		dependantFields().forEach(f -> result.add("dependant", dependantFrameOf(f)));
	}

	private FrameBuilder dependantFrameOf(FieldProperty field) {
		FrameBuilder result = baseFrame();
		result.add("dependant");
		if (field.isMultiple()) result.add("multiple");
		result.add("anchorCode", fieldProperty.getCode());
		result.add("anchorName", fieldProperty.getName());
		result.add("code", field.getCode());
		result.add("name", field.getName());
		return result;
	}

	private List<FieldProperty> dependantFields() {
		List<FieldProperty> fieldPropertyList = parentProperty != null ? parentProperty.getAllFieldPropertyList() : formDefinition.getAllFieldPropertyList();
		return fieldPropertyList.stream().filter(this::isDependantField).collect(Collectors.toList());
	}

	private boolean isDependantField(FieldProperty f) {
		if (!f.isSelect()) return false;
		SelectFieldProperty field = (SelectFieldProperty) f;
		SelectFieldPropertyBase.SelectProperty select = field.getSelect();
		if (select == null) return false;
		Object ref = select.getRoot() != null ? select.getRoot() : null;
		if (ref == null) ref = select.getContext() != null ? select.getContext() : null;
		if (ref == null) return false;
		if (!(ref instanceof Ref)) return false;
		return ((Ref) ref).getValue().equals(fieldProperty.getName());
	}

	private void addTypes(FrameBuilder builder) {
		builder.add(type());
		if (fieldProperty.isMultiple()) {
			builder.add("multiple");
			FrameBuilder addProperties = addPropertiesFrame(fieldProperty);
			if (addProperties != null) builder.add("addProperties", addProperties);
		}
	}

	private FrameBuilder addPropertiesFrame(FieldProperty fieldProperty) {
		if (!(fieldProperty instanceof CompositeFieldProperty)) return null;
		CompositeFieldProperty compositeField = (CompositeFieldProperty)fieldProperty;
		CompositeFieldPropertyBase.ViewProperty view = compositeField.getView();
		if (view == null || view.getMode() != CompositeFieldPropertyBase.ViewProperty.ModeEnumeration.COMPACT) return null;
		FrameBuilder result = new FrameBuilder().add("addProperties");
		view.getSummary().getField().forEach(f -> result.add("add", addPropertiesItemFrame(((CompositeFieldProperty) fieldProperty).getField(f.getValue()))));
		return result;
	}

	private FrameBuilder addPropertiesItemFrame(FieldProperty fieldProperty) {
		FrameBuilder result = new FrameBuilder("addPropertiesItem").add(type(fieldProperty));
		result.add("label", fieldProperty.getLabel());
		result.add("type", type(fieldProperty));
		result.add("code", fieldProperty.getCode());
		return result;
	}

	private void addMultipleProperties(FrameBuilder builder) {
		if (!fieldProperty.isMultiple()) return;
		MultipleableFieldProperty multipleField = (MultipleableFieldProperty) fieldProperty;
		MultipleableFieldProperty.BoundaryProperty boundary = multipleField.getBoundary();
		builder.add("min", boundary != null ? boundary.getMin() : -1L);
		builder.add("max", boundary != null ? boundary.getMax() : -1L);
		builder.add("valueType", valueType(multipleField));
		builder.add("collapsed", collapsed(multipleField));
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

	private boolean collapsed(MultipleableFieldProperty field) {
		if (field instanceof CompositeFieldProperty) {
			CompositeFieldPropertyBase.ViewProperty view = ((CompositeFieldProperty) field).getView();
			return view != null && view.getMode() == CompositeFieldPropertyBase.ViewProperty.ModeEnumeration.COMPACT;
		}
		return false;
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

	private void addDateProperties(FrameBuilder builder) {
		if (!fieldProperty.isDate()) return;
		DateFieldProperty dateField = (DateFieldProperty) fieldProperty;
		builder.add("pattern", pattern(dateField));
		if (isDateTime(dateField)) builder.add("timePicker", "true");
	}

	private String pattern(DateFieldProperty dateField) {
		PrecisionEnumeration precision = dateField.getPrecision();
		if (precision == null) return "DD/MM/YYYY";
		if (precision == PrecisionEnumeration.YEARS) return "YYYY";
		else if (precision == PrecisionEnumeration.MONTHS) return "MM/YYYY";
		else if (precision == PrecisionEnumeration.DAYS) return "DD/MM/YYYY";
		else if (precision == PrecisionEnumeration.HOURS) return "DD/MM/YYYY HH";
		else if (precision == PrecisionEnumeration.MINUTES) return "DD/MM/YYYY HH:mm";
		return "DD/MM/YYYY HH:mm:ss";
	}

	private boolean isDateTime(DateFieldProperty dateField) {
		PrecisionEnumeration precision = dateField.getPrecision();
		return precision == PrecisionEnumeration.HOURS || precision == PrecisionEnumeration.MINUTES || precision == PrecisionEnumeration.SECONDS;
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
		builder.add("indexView", indexView(definition, viewProperty));
	}

	private String indexView(IndexDefinition definition, IndexDefinitionBase.IndexViewProperty viewProperty) {
		if (viewProperty != null) return nameOf(viewProperty);
		IndexDefinitionBase.IndexViewProperty defaultView = definition.getDefaultView();
		if (defaultView != null) return nameOf(defaultView);
		return definition.getViewList().size() > 0 ? nameOf(definition.getViewList().iterator().next()) : "";
	}

	private void addCompositeProperties(FrameBuilder builder) {
		if (!fieldProperty.isComposite()) return;
		CompositeFieldProperty compositeField = (CompositeFieldProperty) fieldProperty;
		compositeField.getAllFieldPropertyList().forEach(f -> {
			FieldRenderer renderer = renderer(formDefinition, f, compositeField);
			builder.add("field", renderer.buildFrame());
		});
	}

	private String type() {
		return type(fieldProperty);
	}

	private String type(FieldProperty fieldProperty) {
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
