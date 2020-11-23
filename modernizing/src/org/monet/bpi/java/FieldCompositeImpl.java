package org.monet.bpi.java;

import org.monet.bpi.Field;
import org.monet.bpi.FieldComposite;

import java.util.List;

public class FieldCompositeImpl extends FieldImpl<List<Field<?>>> implements FieldComposite {

	public FieldCompositeImpl() {
	}

	public <T, F extends Field<V>, V> T getField(String key) {
		return null;
	}

	@SuppressWarnings("unchecked")
	protected <T, F extends Field<V>, V> T getField(String definitionName, String name) {
		return null;
	}

	@Override
	public List<Field<?>> get() {
		return null;
	}

	@Override
	public void set(List<Field<?>> value) {
	}

	@Override
	public boolean equals(Object value) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public void setEnabled(boolean value) {
	}

	@Override
	public boolean isExtended() {
		return false;
	}

	@Override
	public void setExtended(boolean value) {
	}

}