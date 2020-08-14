package org.monet.bpi.java;

import org.monet.bpi.FieldSelect;
import org.monet.bpi.types.Term;

import java.util.List;

public class FieldSelectImpl extends FieldImpl<Term> implements FieldSelect {

	@Override
	public String getSource() {
		return null;
	}

	@Override
	public String getSourceDefinitionCode() {
		return null;
	}

	@Override
	public void setInlineTerms(List<Term> termList) {

	}

	@Override
	public void clear() {

	}

	@Override
	public Term get() {
		return null;
	}

	@Override
	public void set(Term value) {

	}
}