package io.intino.goros.box.ui.datasources.model;

public class Column {
	private String code;
	private String label;
	private boolean isDate;

	public String code() {
		return code;
	}

	public Column code(String code) {
		this.code = code;
		return this;
	}

	public String label() {
		return label;
	}

	public Column label(String label) {
		this.label = label;
		return this;
	}

	public boolean isDate() {
		return isDate;
	}

	public Column isDate(boolean date) {
		isDate = date;
		return this;
	}
}
