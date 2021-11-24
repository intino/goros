package io.intino.goros.unit.box.listeners;

import io.intino.goros.unit.util.DisplayHelper;
import org.monet.space.kernel.listeners.Listener;
import org.monet.space.kernel.model.MonetEvent;
import org.monet.space.kernel.model.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class ListenerGoros extends Listener {
	private GorosUnitNotifier notifier;

	private static Map<String, Timer> taskStateUpdatedTimers = new HashMap<>();

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
	public void taskAssigned(MonetEvent event) {
		try {
			notifier.notifyTaskAssigned((Task) event.getSender());
		}
		catch (Throwable ignored) {
		}
	}

	@Override
	public void taskUnAssigned(MonetEvent event) {
		try {
			notifier.notifyTaskUnAssigned((Task) event.getSender());
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