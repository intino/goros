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

public class NodeNotesTableValueItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, io.intino.goros.unit.box.ui.datasources.model.Note, UnitBox> {
	public Value value;

    public NodeNotesTableValueItem(UnitBox box) {
        super(box);
        id("a_1633743967");
    }

    @Override
	public void init() {
		super.init();
		if (value == null) value = register(new Value(box()).<Value>id("a_1115749549").owner(NodeNotesTableValueItem.this));
	}

	public class Value extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public Value(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}