package io.intino.goros.box.ui.datasources.model.task;

import java.util.stream.Stream;

public enum TaskFolderGrouping {
	All("Todas"), Alive("En ejecución"), Active("Pendientes"), Pending("En espera"), Finished("Finalizadas");

	private String title;

	TaskFolderGrouping(String title) {
		this.title = title;
	}

	public String title() {
		return title;
	}

	public static TaskFolderGrouping from(String value) {
		return Stream.of(values()).filter(v -> v.name().equals(value) || v.title.equals(value)).findFirst().orElse(null);
	}
}
