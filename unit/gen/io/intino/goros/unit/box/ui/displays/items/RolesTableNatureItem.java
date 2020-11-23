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

public class RolesTableNatureItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public Rol_49_54_1772043657 rol_49_54_1772043657;
	public RolesTableNatureItem.Rol_49_54_1772043657. Nature nature;

    public RolesTableNatureItem(UnitBox box) {
        super(box);
        id("a_1102436782");
    }

    @Override
	public void init() {
		super.init();
		if (rol_49_54_1772043657 == null) rol_49_54_1772043657 = register(new Rol_49_54_1772043657(box()).<Rol_49_54_1772043657>id("a798951597").owner(RolesTableNatureItem.this));
		if (rol_49_54_1772043657 != null) nature = rol_49_54_1772043657.nature;
	}

	public class Rol_49_54_1772043657 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public RolesTableNatureItem.Rol_49_54_1772043657. Nature nature;

		public Rol_49_54_1772043657(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nature == null) nature = register(new Nature(box()).<Nature>id("a328868719").owner(RolesTableNatureItem.this));
		}

		public class Nature extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

			public Nature(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}