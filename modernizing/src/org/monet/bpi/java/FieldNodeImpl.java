package org.monet.bpi.java;

import org.monet.bpi.FieldNode;
import org.monet.bpi.Node;
import org.monet.bpi.types.Link;
import org.monet.bpi.types.Term;

public class FieldNodeImpl extends FieldImpl<Link> implements FieldNode {

	private Node containedNode;

	@Override
	public Link get() {
		return null;
	}

	@Override
	public Term getAsTerm() {
		Link link = this.get();
		if (link == null)
			return null;
		return new Term(link.getId(), link.getLabel());
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Node> T getNode() {
		return null;
	}

	@Override
	public void set(Link value) {
	}

	@Override
	public boolean equals(Object value) {
		if (value instanceof Link)
			return this.get().equals(value);
		else
			return false;
	}

	@Override
	public void clear() {
		this.set(new Link("", ""));
	}

	private Link emptyLink() {
		Link result = new Link();
		result.setId("");
		result.setLabel("");
		return result;
	}

}