package org.monet.bpi.java;

import org.monet.bpi.EventService;
import org.monet.bpi.types.Event;

public class EventServiceImpl extends EventService {

	@Override
	protected void registerEventImpl(Event event) {

	}

	@Override
	protected Event loadEventImpl(String name) {
		return null;
	}

	@Override
	protected boolean cancelEventImpl(String name) {
		return false;
	}
}
