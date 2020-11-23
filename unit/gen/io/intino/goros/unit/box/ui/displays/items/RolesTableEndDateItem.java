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

public class RolesTableEndDateItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public Rol_55_55_1108760474 rol_55_55_1108760474;
	public RolesTableEndDateItem.Rol_55_55_1108760474. EndDate endDate;

    public RolesTableEndDateItem(UnitBox box) {
        super(box);
        id("a_1725386241");
    }

    @Override
	public void init() {
		super.init();
		if (rol_55_55_1108760474 == null) rol_55_55_1108760474 = register(new Rol_55_55_1108760474(box()).<Rol_55_55_1108760474>id("a1790548920").owner(RolesTableEndDateItem.this));
		if (rol_55_55_1108760474 != null) endDate = rol_55_55_1108760474.endDate;
	}

	public class Rol_55_55_1108760474 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public RolesTableEndDateItem.Rol_55_55_1108760474. EndDate endDate;

		public Rol_55_55_1108760474(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (endDate == null) endDate = register(new EndDate(box()).<EndDate>id("a_53864089").owner(RolesTableEndDateItem.this));
		}

		public class EndDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

			public EndDate(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}