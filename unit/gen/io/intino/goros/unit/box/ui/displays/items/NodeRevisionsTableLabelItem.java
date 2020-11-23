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

public class NodeRevisionsTableLabelItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Revision, UnitBox> {
	public Label label;

    public NodeRevisionsTableLabelItem(UnitBox box) {
        super(box);
        id("a1423086964");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a_1872916375").owner(NodeRevisionsTableLabelItem.this));
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

		public Label(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}