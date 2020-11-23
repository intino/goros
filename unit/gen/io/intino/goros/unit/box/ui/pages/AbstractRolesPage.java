package io.intino.goros.unit.box.ui.pages;

import io.intino.goros.unit.box.UnitBox;
import io.intino.alexandria.exceptions.*;
import java.util.*;

public abstract class AbstractRolesPage extends io.intino.alexandria.ui.spark.pages.Page {
	public UnitBox box;

	public AbstractRolesPage() { super("unit-elements"); }

	public String execute() {
		return super.template("roles");
	}

	@Override
	protected String title() {
		return "";
	}

	@Override
	protected java.net.URL favicon() {
		return this.getClass().getResource("");
	}
}