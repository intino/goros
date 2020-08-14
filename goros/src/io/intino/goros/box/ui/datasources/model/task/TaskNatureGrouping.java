package io.intino.goros.box.ui.datasources.model.task;

import java.util.stream.Stream;

public enum TaskNatureGrouping {
	All("Todas las tareas", 0), System("Sólo las tareas de sistema", 1);

	private String title;
	private int value;

	TaskNatureGrouping(String title, int value) {
		this.title = title;
		this.value = value;
	}

	public String title() {
		return title;
	}

	public int value() { return value; }

	public static TaskNatureGrouping from(String value) {
		return Stream.of(values()).filter(v -> v.name().equals(value) || v.title().equals(value)).findFirst().orElse(null);
	}
}
