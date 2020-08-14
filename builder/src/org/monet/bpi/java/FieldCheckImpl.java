package org.monet.bpi.java;

import org.monet.bpi.FieldCheck;
import org.monet.bpi.types.Check;
import org.monet.bpi.types.CheckList;
import org.monet.bpi.types.TermList;

public class FieldCheckImpl extends FieldImpl<CheckList> implements FieldCheck {

	@Override
	public CheckList get() {
		return null;
	}

	@Override
	public CheckList getChecked() {
		return null;
	}

	@Override
	public TermList getCheckedAsTermList() {
		TermList termList = new TermList();

		for (Check check : this.get().getAll()) {
			if (check.isChecked())
				termList.add(check.toTerm());
		}

		return termList;
	}

	@Override
	public void set(CheckList value) {
	}

	@Override
	public void fill(CheckList value) {
	}

	@Override
	public void fillFromTermList(TermList termList) {
		this.fill(termList.toCheckList());
	}

	@Override
	public String getFrom() {
		return null;
	}

	@Override
	public String getSource() {
		return null;
	}

	@Override
	public void setFrom(String from) {
	}

	@Override
	public boolean equals(Object value) {
		return value instanceof CheckList && this.get().equals((CheckList) value);
	}

	@Override
	public void clear() {
		this.set(new CheckList());
	}

}