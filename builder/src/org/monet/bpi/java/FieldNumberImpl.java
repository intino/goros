package org.monet.bpi.java;

import org.monet.bpi.FieldNumber;
import org.monet.bpi.types.Number;

public class FieldNumberImpl extends FieldImpl<Number> implements FieldNumber {

	@Override
	public Number get() {
		return null;
	}

	@Override
	public void set(Number value) {
	}

	@Override
	public boolean equals(Object value) {
		if (value instanceof Number)
			return this.get().equals(value);
		else
			return false;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public void clear() {
		this.set(new Number(0));
	}

}