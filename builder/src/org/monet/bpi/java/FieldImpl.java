package org.monet.bpi.java;

import org.monet.bpi.Field;
import org.monet.metamodel.FieldProperty;

public abstract class FieldImpl<V> implements Field<V> {

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public FieldProperty getDefinition() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}
}
