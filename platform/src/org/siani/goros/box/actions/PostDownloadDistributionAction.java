package org.siani.goros.box.actions;

import org.monet.space.backservice.control.actions.ActionDownloadDistribution;
import org.monet.space.backservice.control.constants.Parameter;
import org.siani.goros.box.GorosBox;
import io.intino.alexandria.exceptions.*;
import java.time.*;
import java.util.*;


public class PostDownloadDistributionAction extends Action {
	public String execute() {
		return setup(new ActionDownloadDistribution()).execute();
	}

	@Override
	Map<String, Object> parameters() {
		return new HashMap<>();
	}
}