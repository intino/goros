package io.intino.goros.box.ui.datasources.model.role;

import java.util.stream.Stream;

public enum RoleTypeGrouping {
	User("Usuario"), Service("Servicio"), Feeder("Feeder");

	private String title;

	RoleTypeGrouping(String title) {
		this.title = title;
	}

	public String title() {
		return title;
	}

	public static RoleTypeGrouping from(String value) {
		return Stream.of(values()).filter(v -> v.name().equals(value) || v.title().equals(value)).findFirst().orElse(null);
	}
}
