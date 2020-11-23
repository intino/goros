package org.monet.bpi.java;

import org.monet.bpi.MailService;
import org.monet.bpi.types.File;

import java.util.List;

public class MailServiceImpl extends MailService {


	@Override
	public void send(String to, String subject, String content, File... attachments) {

	}

	@Override
	public void send(List<String> toList, String subject, String content, File... attachments) {

	}

	@Override
	public void send(String to, String subject, String htmlContent, String textContent, File... attachments) {

	}

	@Override
	public void send(List<String> toList, String subject, String htmlContent, String textContent, File... attachments) {

	}
}
