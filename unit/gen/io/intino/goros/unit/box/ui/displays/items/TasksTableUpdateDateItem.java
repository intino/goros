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

public class TasksTableUpdateDateItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Tas_28_58_1472241048 tas_28_58_1472241048;
	public TasksTableUpdateDateItem.Tas_28_58_1472241048. UpdateDate updateDate;

    public TasksTableUpdateDateItem(UnitBox box) {
        super(box);
        id("a1938290177");
    }

    @Override
	public void init() {
		super.init();
		if (tas_28_58_1472241048 == null) tas_28_58_1472241048 = register(new Tas_28_58_1472241048(box()).<Tas_28_58_1472241048>id("a1646625725").owner(TasksTableUpdateDateItem.this));
		if (tas_28_58_1472241048 != null) updateDate = tas_28_58_1472241048.updateDate;
	}

	public class Tas_28_58_1472241048 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public TasksTableUpdateDateItem.Tas_28_58_1472241048. UpdateDate updateDate;

		public Tas_28_58_1472241048(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (updateDate == null) updateDate = register(new UpdateDate(box()).<UpdateDate>id("a_246632021").owner(TasksTableUpdateDateItem.this));
		}

		public class UpdateDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

			public UpdateDate(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}