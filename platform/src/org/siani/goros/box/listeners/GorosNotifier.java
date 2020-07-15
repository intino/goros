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
		taskCreatedListeners.put(display.id(), listener);
		return this;
	}

	public GorosNotifier unTaskCreated(Display display) {
		if (!taskCreatedListeners.containsKey(display.id())) return this;
		taskCreatedListeners.remove(display.id());
		return this;
	}

	public GorosNotifier onTaskStateChange(Display display, Consumer<Task> listener) {
		taskStateChangeListeners.put(display.id(), listener);
		return this;
	}

	public GorosNotifier unTaskStateChange(Display display) {
		if (!taskStateChangeListeners.containsKey(display.id())) return this;
		taskStateChangeListeners.remove(display.id());
		return this;
	}

	public void notifyTaskCreated(Task task) {
		Task loadedTask = ComponentPersistence.getInstance().getTaskLayer().loadTask(task.getId());
		taskCreatedListeners.values().forEach(l -> l.accept(loadedTask));
	}

	public void notifyTaskStateChange(Task task) {
		Task loadedTask = ComponentPersistence.getInstance().getTaskLayer().loadTask(task.getId());
		taskStateChangeListeners.values().forEach(l -> l.accept(loadedTask));
	}

}