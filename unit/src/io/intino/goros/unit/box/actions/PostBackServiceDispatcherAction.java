package io.intino.goros.unit.box.actions;

public class PostBackServiceDispatcherAction extends Action {
	public String op;
	public String username;

	public String execute() {
		if (op.equalsIgnoreCase("haspermissions")) {
			PostHasPermissionsAction action = new PostHasPermissionsAction();
			action.box = box;
			action.context = context;
			action.username = username;
			return action.execute();
		}
		return null;
	}
}