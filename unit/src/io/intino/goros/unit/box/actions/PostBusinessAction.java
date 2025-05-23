package io.intino.goros.unit.box.actions;

import io.intino.alexandria.exceptions.Forbidden;
import io.intino.goros.unit.box.UnitBox;
import org.monet.space.frontservice.control.actions.ActionBusinessService;
import org.monet.space.frontservice.control.constants.Parameter;

import java.util.HashMap;
import java.util.Map;


public class PostBusinessAction extends FrontServiceAction {
	public String service;
	public UnitBox box;
	public String replyMailbox;
	public String sourceUnit;
	public String startDate;
	public String endDate;
	public String comments;
	public String urgent;

	public java.lang.String execute() {
		return executeServiceAction(new ActionBusinessService());
	}

	@Override
	Map<String, Object> parameters() {
		HashMap<String, Object> paramMap = new HashMap<>();
		if (sourceUnit != null) paramMap.put(Parameter.SOURCE_UNIT, sourceUnit);
		if (service != null) paramMap.put(Parameter.SERVICE_NAME, service);
		if (replyMailbox != null) paramMap.put(Parameter.REPLY_MAILBOX, replyMailbox);
		if (startDate != null) paramMap.put(Parameter.START_DATE, startDate);
		if (endDate != null) paramMap.put(Parameter.END_DATE, endDate);
		if (comments != null) paramMap.put(Parameter.COMMENTS, comments);
		if (urgent != null) paramMap.put(Parameter.URGENT, urgent);
		return paramMap;
	}
}