package io.intino.goros.box.listeners;

import org.monet.space.kernel.listeners.Listener;
import org.monet.space.kernel.model.MonetEvent;
import org.monet.space.kernel.model.Task;

public class ListenerGoros extends Listener {
	private GorosNotifier notifier;

	public ListenerGoros inject(GorosNotifier notifier) {
		this.notifier = notifier;
		return this;
	}

	@Override
	public void taskStateUpdated(MonetEvent event) {
		notifier.notifyTaskStateChange((Task) event.getSender());
	}

	@Override
	public void taskCreated(MonetEvent event) {
		notifier.notifyTaskCreated((Task) event.getSender());
	}

	@Override
	public void taskFinished(MonetEvent event) {
		notifier.notifyTaskStateChange((Task) event.getSender());
	}

	@Override
	public void taskAborted(MonetEvent event) {
		notifier.notifyTaskStateChange((String) event.getSender());
	}

}