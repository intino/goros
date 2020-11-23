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

public class RolesTableTypeItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public Rol_46_52_0217462986 rol_46_52_0217462986;
	public RolesTableTypeItem.Rol_46_52_0217462986. Type type;

    public RolesTableTypeItem(UnitBox box) {
        super(box);
        id("a1140630920");
    }

    @Override
	public void init() {
		super.init();
		if (rol_46_52_0217462986 == null) rol_46_52_0217462986 = register(new Rol_46_52_0217462986(box()).<Rol_46_52_0217462986>id("a_292985509").owner(RolesTableTypeItem.this));
		if (rol_46_52_0217462986 != null) type = rol_46_52_0217462986.type;
	}

	public class Rol_46_52_0217462986 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public RolesTableTypeItem.Rol_46_52_0217462986. Type type;

		public Rol_46_52_0217462986(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (type == null) type = register(new Type(box()).<Type>id("a270682561").owner(RolesTableTypeItem.this));
		}

		public class Type extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

			public Type(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}