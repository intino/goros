package io.intino.goros.unit.graph;

public enum PostType {
	ServiceOrder("Service order"), ServiceResponse("Service response"), Info("Info"),
	BusinessModelUpdated("Business model updated"), BusinessModelInstalled("Business model installed"),
	UserPost("User post");

	private String label;

	PostType(String label) {
		this.label = label;
	}

	public String label() {
		return label;
	}

	public static PostType from(int value) {
		return PostType.values()[value];
	}
}
