package org.monet.bpi.java;

import org.monet.bpi.DimensionComponent;
import org.monet.bpi.types.Number;
import org.monet.bpi.types.Term;

import java.util.ArrayList;

public class DimensionComponentImpl implements DimensionComponent {

	@Override
	public Object getFeatureValue(String key) {
		return null;
	}

	@Override
	public ArrayList<Object> getFeatureValues(String key) {
		return null;
	}

	@Override
	public void addFeature(String key, Number value) {

	}

	@Override
	public void addFeature(String key, Boolean value) {

	}

	@Override
	public void addFeature(String key, String value) {

	}

	@Override
	public void addFeature(String key, Term value, ArrayList<Term> ancestors) {

	}

	@Override
	public void save() {

	}
}
