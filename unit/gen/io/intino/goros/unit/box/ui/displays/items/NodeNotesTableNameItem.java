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

public class NodeNotesTableNameItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, io.intino.goros.unit.box.ui.datasources.model.Note, UnitBox> {
	public Name name;

    public NodeNotesTableNameItem(UnitBox box) {
        super(box);
        id("a749380548");
    }

    @Override
	public void init() {
		super.init();
		if (name == null) name = register(new Name(box()).<Name>id("a_1486403034").owner(NodeNotesTableNameItem.this));
	}

	public class Name extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public Name(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}