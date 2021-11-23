package io.intino.goros.unit.box.listeners;

import org.monet.space.kernel.listeners.Listener;
import org.monet.space.kernel.model.MonetEvent;
import org.monet.space.kernel.model.Task;

public class ListenerGoros extends Listener {
	private GorosUnitNotifier notifier;

	public ListenerGoros inject(GorosUnitNotifier notifier) {
		this.notifier = notifier;
		return this;
	}

	@Override
	public void taskStateUpdated(MonetEvent event) {
		try {
			notifier.notifyTaskStateChange((Task) event.getSender());
		}
		catch (Throwable ignored) {
		}
	}

	@Override
	public void taskCreated(MonetEvent event) {
		try {
			notifier.notifyTaskCreated((Task) event.getSender());
		}
		catch (Throwable ignored) {
		}
	}

	@Override
	public void taskFinished(MonetEvent event) {
		try {
			notifier.notifyTaskStateChange((Task) event.getSender());
		}
		catch (Throwable ignored) {
		}
	}

	@Override
	public void taskAborted(MonetEvent event) {
		try {
			notifier.notifyTaskStateChange((String) event.getSender());
		}
		catch (Throwable ignored) {
		}
	}

}