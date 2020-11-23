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

public class TrashTableDeleteDateItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public DeleteDate deleteDate;

    public TrashTableDeleteDateItem(UnitBox box) {
        super(box);
        id("a993587649");
    }

    @Override
	public void init() {
		super.init();
		if (deleteDate == null) deleteDate = register(new DeleteDate(box()).<DeleteDate>id("a_983003849").owner(TrashTableDeleteDateItem.this));
	}

	public class DeleteDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

		public DeleteDate(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}