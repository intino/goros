package org.siani.goros.box.listeners;

import io.intino.alexandria.ui.displays.Display;
import org.monet.space.kernel.components.ComponentPersistence;
import org.monet.space.kernel.model.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GorosNotifier {
	private Map<String, Consumer<Task>> stateChangeListeners = new HashMap<>();

	public GorosNotifier onStateChange(Display display, Consumer<Task> listener) {
		stateChangeListeners.put(display.id(), listener);
		return this;
	}

	public GorosNotifier unStateChange(Display display) {
		if (!stateChangeListeners.containsKey(display.id())) return this;
		stateChangeListeners.remove(display.id());
		return this;
	}

	public void notifyStateChange(Task task) {
		Task loadedTask = ComponentPersistence.getInstance().getTaskLayer().loadTask(task.getId());
		stateChangeListeners.values().forEach(l -> l.accept(loadedTask));
	}

}