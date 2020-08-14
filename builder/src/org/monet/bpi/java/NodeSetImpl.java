package org.monet.bpi.java;

import org.monet.bpi.Expression;
import org.monet.bpi.NodeSet;

import java.util.Map;

public abstract class NodeSetImpl extends NodeImpl implements NodeSet {

	@Override
	public long getCount(Expression where) {
		return -1;
	}

	@Override
	public Map<String, String> getParameters() {
		return null;
	}

	@Override
	public void addParameter(String name, String value) {
	}

	@Override
	public void deleteParameter(String name) {
	}
}
