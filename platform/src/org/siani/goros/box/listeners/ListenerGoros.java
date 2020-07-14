package org.siani.goros.box.listeners;

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
		notifier.notifyStateChange((Task) event.getSender());
	}

}