package org.siani.goros.box.listeners;

import io.intino.alexandria.ui.displays.Display;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.model.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GorosNotifier {
	private Map<String, Consumer<Task>> taskCreatedListeners = new HashMap<>();
	private Map<String, Consumer<Task>> taskStateChangeListeners = new HashMap<>();

	public GorosNotifier onTaskCreated(Display display, Consumer<Task> listener) {
		taskCreatedListeners.put(idOf(display), listener);
		return this;
	}

	public GorosNotifier unTaskCreated(Display display) {
		if (!taskCreatedListeners.containsKey(idOf(display))) return this;
		taskCreatedListeners.remove(idOf(display));
		return this;
	}

	public GorosNotifier onTaskStateChange(Display display, Consumer<Task> listener) {
		taskStateChangeListeners.put(idOf(display), listener);
		return this;
	}

	public GorosNotifier unTaskStateChange(Display display) {
		String id = idOf(display);
		if (!taskStateChangeListeners.containsKey(id)) return this;
		taskStateChangeListeners.remove(id);
		return this;
	}

	public void notifyTaskCreated(Task task) {
		Task loadedTask = ComponentPersistence.getInstance().getTaskLayer().loadTask(task.getId());
		taskCreatedListeners.values().forEach(l -> l.accept(loadedTask));
	}

	public void notifyTaskStateChange(Task task) {
		notifyTaskStateChange(task.getId());
	}

	public void notifyTaskStateChange(String task) {
		Task loadedTask = ComponentPersistence.getInstance().getTaskLayer().loadTask(task);
		taskStateChangeListeners.values().forEach(l -> l.accept(loadedTask));
	}

	private String idOf(Display display) {
		String id = display.id();
		return display.owner() != null ? id + display.owner().path() : id + display.hashCode();
	}

}