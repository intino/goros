package org.monet.bpi.java;

import org.monet.metamodel.*;

import java.util.HashMap;

public class FieldFactory {
	private static FieldFactory instance;
	private HashMap<String, Class<? extends FieldImpl<?>>> fields;

	private FieldFactory() {
		this.fields = new HashMap<String, Class<? extends FieldImpl<?>>>();
		this.registerFields();
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private Boolean registerFields() {

		this.fields.put(BooleanFieldProperty.class.getName(), FieldBooleanImpl.class);
		this.fields.put(CheckFieldProperty.class.getName(), FieldCheckImpl.class);
		this.fields.put(DateFieldProperty.class.getName(), FieldDateImpl.class);
		this.fields.put(FileFieldProperty.class.getName(), FieldFileImpl.class);
		this.fields.put(NodeFieldProperty.class.getName(), (Class) FieldNodeImpl.class);
		this.fields.put(LinkFieldProperty.class.getName(), (Class) FieldLinkImpl.class);
		this.fields.put(NumberFieldProperty.class.getName(), FieldNumberImpl.class);
		this.fields.put(PictureFieldProperty.class.getName(), FieldPictureImpl.class);
		this.fields.put(CompositeFieldProperty.class.getName(), FieldCompositeImpl.class);
		this.fields.put(SelectFieldProperty.class.getName(), FieldSelectImpl.class);
		this.fields.put(TextFieldProperty.class.getName(), FieldTextImpl.class);
		this.fields.put(MemoFieldProperty.class.getName(), FieldMemoImpl.class);
		this.fields.put(SerialFieldProperty.class.getName(), FieldSerialImpl.class);
		this.fields.put(SummationFieldProperty.class.getName(), FieldSummationImpl.class);

		return true;
	}

	public synchronized static FieldFactory getInstance() {
		if (instance == null) instance = new FieldFactory();
		return instance;
	}

}