package org.monet.bpi.java;

import org.monet.bpi.FieldSummation;
import org.monet.bpi.types.SummationItem;

import java.util.Observable;
import java.util.Observer;

public class FieldSummationImpl extends FieldNumberImpl implements FieldSummation, Observer {

	@Override
	public void update(Observable o, Object arg) {

	}

	@Override
	public SummationItem getItem(String itemKey) {
		return null;
	}

	@Override
	public SummationItem addNew(String key) {
		return null;
	}

	@Override
	public void delete(SummationItem item) {

	}

	@Override
	public void commitChanges() throws Exception {

	}

	@Override
	public void discardChanges() {

	}
}