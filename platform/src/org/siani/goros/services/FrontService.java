package org.siani.goros.services;

import org.monet.space.kernel.model.DataRequest;
import org.monet.space.kernel.model.TermList;

import java.io.InputStream;
import java.time.Instant;

public interface FrontService {
	BusinessServiceInfo businessService(String sourceUnit, String serviceName, String replyMailbox, Instant startDate, Instant endDate, String comments, boolean urgent);
	void mailbox(String mailbox, String signaling, InputStream message, String messageCode, String messageType, String messageHash);
	TermList loadSource(DataRequest request);
	TermList searchSource(DataRequest request);
	TermList synchronizeSource(DataRequest request);

	interface BusinessServiceInfo {
		String mailbox();
		String signature();
	}
}
