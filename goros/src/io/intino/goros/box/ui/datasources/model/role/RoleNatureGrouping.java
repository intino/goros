package io.intino.goros.box.ui.datasources.model.role;

import java.util.stream.Stream;

public enum RoleNatureGrouping {
	Both("Ambos"), Internal("Interno"), External("Externo");

	private String title;

	RoleNatureGrouping(String title) {
		this.title = title;
	}

	public String title() {
		return title;
	}

	public static RoleNatureGrouping from(String value) {
		return Stream.of(values()).filter(v -> v.name().equals(value) || v.title().equals(value)).findFirst().orElse(null);
	}
}
