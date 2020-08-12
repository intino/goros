package org.siani.goros.box.ui.datasources.model.task;

import java.util.stream.Stream;

public enum TaskUrgentGrouping {
	Urgent("Urgentes", 1), NotUrgent("No urgentes", 0);

	private String title;
	private int value;

	TaskUrgentGrouping(String title, int value) {
		this.title = title;
		this.value = value;
	}

	public String title() {
		return title;
	}

	public int value() {
		return value;
	}

	public static TaskUrgentGrouping from(String value) {
		return Stream.of(values()).filter(v -> v.name().equals(value) || v.title().equals(value)).findFirst().orElse(null);
	}
}
