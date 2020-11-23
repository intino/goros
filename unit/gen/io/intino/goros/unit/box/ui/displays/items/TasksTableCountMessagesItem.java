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

public class TasksTableCountMessagesItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Tas_31_61_11449374513 tas_31_61_11449374513;
	public TasksTableCountMessagesItem.Tas_31_61_11449374513. CountMessages countMessages;

    public TasksTableCountMessagesItem(UnitBox box) {
        super(box);
        id("a675688538");
    }

    @Override
	public void init() {
		super.init();
		if (tas_31_61_11449374513 == null) tas_31_61_11449374513 = register(new Tas_31_61_11449374513(box()).<Tas_31_61_11449374513>id("a_2051326049").owner(TasksTableCountMessagesItem.this));
		if (tas_31_61_11449374513 != null) countMessages = tas_31_61_11449374513.countMessages;
	}

	public class Tas_31_61_11449374513 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public TasksTableCountMessagesItem.Tas_31_61_11449374513. CountMessages countMessages;

		public Tas_31_61_11449374513(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (countMessages == null) countMessages = register(new CountMessages(box()).<CountMessages>id("a_680303001").owner(TasksTableCountMessagesItem.this));
		}

		public class CountMessages extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, UnitBox>  {

			public CountMessages(UnitBox box) {
				super(box);
				_value(0.0);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}