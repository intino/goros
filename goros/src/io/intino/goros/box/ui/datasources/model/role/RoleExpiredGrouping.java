package io.intino.goros.box.ui.datasources.model.role;

import java.util.stream.Stream;

public enum RoleExpiredGrouping {
	Expired("Expired", false), NonExpired("Non expired", true);

	private String title;
	private boolean value;

	RoleExpiredGrouping(String title, boolean value) {
		this.title = title;
		this.value = value;
	}

	public String title() {
		return title;
	}

	public boolean value() {
		return value;
	}

	public static RoleExpiredGrouping from(String value) {
		return Stream.of(values()).filter(v -> v.name().equals(value) || v.title().equals(value)).findFirst().orElse(null);
	}
}
