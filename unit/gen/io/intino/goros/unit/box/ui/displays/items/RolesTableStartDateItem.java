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

public class RolesTableStartDateItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public Rol_52_57_01804178925 rol_52_57_01804178925;
	public RolesTableStartDateItem.Rol_52_57_01804178925. StartDate startDate;

    public RolesTableStartDateItem(UnitBox box) {
        super(box);
        id("a_1586706557");
    }

    @Override
	public void init() {
		super.init();
		if (rol_52_57_01804178925 == null) rol_52_57_01804178925 = register(new Rol_52_57_01804178925(box()).<Rol_52_57_01804178925>id("a1553111070").owner(RolesTableStartDateItem.this));
		if (rol_52_57_01804178925 != null) startDate = rol_52_57_01804178925.startDate;
	}

	public class Rol_52_57_01804178925 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public RolesTableStartDateItem.Rol_52_57_01804178925. StartDate startDate;

		public Rol_52_57_01804178925(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (startDate == null) startDate = register(new StartDate(box()).<StartDate>id("a_1298093421").owner(RolesTableStartDateItem.this));
		}

		public class StartDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

			public StartDate(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}