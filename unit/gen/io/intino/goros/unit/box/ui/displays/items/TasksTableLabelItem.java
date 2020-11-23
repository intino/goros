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

public class TasksTableLabelItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Label label;
	public State state;

    public TasksTableLabelItem(UnitBox box) {
        super(box);
        id("a2000043949");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a_954405918").owner(TasksTableLabelItem.this));
		if (state == null) state = register(new State(box()).<State>id("a_947375745").owner(TasksTableLabelItem.this));
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public Label(UnitBox box) {
			super(box);
			_value("Loading...");
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class State extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public State(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
		public State textColor(String color) {
		    this._textColor(color);
		    this._refreshHighlight();
		    return this;
		}

		public State backgroundColor(String color) {
		    this._backgroundColor(color);
		    this._refreshHighlight();
		    return this;
		}
	}
}