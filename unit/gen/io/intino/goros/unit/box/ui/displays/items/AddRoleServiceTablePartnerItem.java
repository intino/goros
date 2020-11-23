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

public class AddRoleServiceTablePartnerItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.FederationUnitService, UnitBox> {
	public Partner partner;

    public AddRoleServiceTablePartnerItem(UnitBox box) {
        super(box);
        id("a254293905");
    }

    @Override
	public void init() {
		super.init();
		if (partner == null) partner = register(new Partner(box()).<Partner>id("a1930467866").owner(AddRoleServiceTablePartnerItem.this));
	}

	public class Partner extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public Partner(UnitBox box) {
			super(box);
			_value("Loading...");
		}

		@Override
		public void init() {
			super.init();
		}
	}
}