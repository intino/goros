package org.monet.bpi.java;

import org.monet.bpi.ClientService;
import org.monet.bpi.MonetLink;
import org.monet.bpi.User;
import org.monet.bpi.types.File;

public class ClientServiceImpl extends ClientService {

	@Override
	protected void redirectUserToImpl(MonetLink monetLink) {

	}

	@Override
	protected void sendMessageToUserImpl(String message) {

	}

	@Override
	protected void sendFileToUserImpl(File file) {

	}

	@Override
	protected User discoverUserInSessionImpl() {
		return null;
	}
}
