package io.intino.goros.unit.box.ui.displays.items;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.ItemNotifier;

public class TasksTableOperationsItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Urgent urgent;

    public TasksTableOperationsItem(UnitBox box) {
        super(box);
        id("a_428043685");
    }

    @Override
	public void init() {
		super.init();
		if (urgent == null) urgent = register(new Urgent(box()).<Urgent>id("a_567021147").owner(TasksTableOperationsItem.this));
	}

	public class Urgent extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, UnitBox>  {

		public Urgent(UnitBox box) {
			super(box);
			_title("Marcar/Desmarcar como urgente");
			_color("#ddd");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
			_icon("Alarm");
		}

		@Override
		public void init() {
			super.init();
		}
	}
}