package org.monet.bpi.java;

import org.monet.bpi.FieldBoolean;

public class FieldBooleanImpl extends FieldImpl<Boolean> implements FieldBoolean {
	@Override
	public boolean isChecked() {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public Boolean get() {
		return null;
	}

	@Override
	public void set(Boolean value) {

	}
}