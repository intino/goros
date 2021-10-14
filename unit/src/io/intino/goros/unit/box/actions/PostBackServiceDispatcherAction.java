package io.intino.goros.unit.box.actions;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;

public class PostBackServiceDispatcherAction {
	public UnitBox box;
	public io.intino.alexandria.http.spark.SparkContext context;
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