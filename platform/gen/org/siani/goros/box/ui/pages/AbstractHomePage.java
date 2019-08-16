package org.siani.goros.box.ui.pages;

import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.util.*;

public abstract class AbstractHomePage extends io.intino.alexandria.ui.spark.pages.Page {
	public GorosBox box;

	public AbstractHomePage() { super("platform-ui"); }

	public String execute() {
		return super.template("home");
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