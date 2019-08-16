package org.siani.goros.box;

import java.util.Map;
import java.util.HashMap;

public class GorosConfiguration extends io.intino.alexandria.core.BoxConfiguration {

	public GorosConfiguration(String[] args) {
		super(args);
	}

	public String port() {
		return get("port");
	}
}