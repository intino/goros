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

public class NodeNotesTableOperationsItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, io.intino.goros.unit.box.ui.datasources.model.Note, UnitBox> {
	public Nodvie_54_5_01483733402 nodvie_54_5_01483733402;
	public NodeNotesTableOperationsItem.Nodvie_54_5_01483733402. Remove remove;

    public NodeNotesTableOperationsItem(UnitBox box) {
        super(box);
        id("a_633608022");
    }

    @Override
	public void init() {
		super.init();
		if (nodvie_54_5_01483733402 == null) nodvie_54_5_01483733402 = register(new Nodvie_54_5_01483733402(box()).<Nodvie_54_5_01483733402>id("a_660615266").owner(NodeNotesTableOperationsItem.this));
		if (nodvie_54_5_01483733402 != null) remove = nodvie_54_5_01483733402.remove;
	}

	public class Nodvie_54_5_01483733402 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public NodeNotesTableOperationsItem.Nodvie_54_5_01483733402. Remove remove;

		public Nodvie_54_5_01483733402(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (remove == null) remove = register(new Remove(box()).<Remove>id("a_1673783525").owner(NodeNotesTableOperationsItem.this));
		}

		public class Remove extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, UnitBox>  {

			public Remove(UnitBox box) {
				super(box);
				_title("Eliminar nota");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
				_icon("Clear");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}