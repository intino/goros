package org.siani.goros.box.ui.datasources.model;

public class Note {
	private String name;
	private String value;

	public String name() {
		return name;
	}

	public Note name(String name) {
		this.name = name;
		return this;
	}

	public String value() {
		return value;
	}

	public Note value(String value) {
		this.value = value;
		return this;
	}
}
