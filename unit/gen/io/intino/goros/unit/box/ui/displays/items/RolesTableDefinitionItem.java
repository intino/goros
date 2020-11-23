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

public class RolesTableDefinitionItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public Rol_43_58_0731311139 rol_43_58_0731311139;
	public RolesTableDefinitionItem.Rol_43_58_0731311139. Definition definition;

    public RolesTableDefinitionItem(UnitBox box) {
        super(box);
        id("a1064485060");
    }

    @Override
	public void init() {
		super.init();
		if (rol_43_58_0731311139 == null) rol_43_58_0731311139 = register(new Rol_43_58_0731311139(box()).<Rol_43_58_0731311139>id("a287885616").owner(RolesTableDefinitionItem.this));
		if (rol_43_58_0731311139 != null) definition = rol_43_58_0731311139.definition;
	}

	public class Rol_43_58_0731311139 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public RolesTableDefinitionItem.Rol_43_58_0731311139. Definition definition;

		public Rol_43_58_0731311139(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (definition == null) definition = register(new Definition(box()).<Definition>id("a1145196561").owner(RolesTableDefinitionItem.this));
		}

		public class Definition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

			public Definition(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}