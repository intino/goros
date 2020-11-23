package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractTasksListCatalog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public TasksList tasksList;

    public AbstractTasksListCatalog(B box) {
        super(box);
        id("tasksListCatalog");
    }

    @Override
	public void init() {
		super.init();
		if (tasksList == null) tasksList = register(new TasksList(box()).<TasksList>id("a2103281753").owner(AbstractTasksListCatalog.this));
	}

	public class TasksList extends io.intino.alexandria.ui.displays.components.List<B, TasksListItem, org.monet.space.kernel.model.Task> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public TasksList(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}
		public void onSelect(io.intino.alexandria.ui.displays.events.SelectionListener listener) {
			super.addSelectionListener(listener);
		}
		public TasksListItem create(org.monet.space.kernel.model.Task element) {
			TasksListItem result = new TasksListItem((UnitBox)box());
			result.id(java.util.UUID.randomUUID().toString());
			result.item(element);
			return result;
		}
	}
}