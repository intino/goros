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

public class TasksTableOwnerItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Tas_22_53_0393878755 tas_22_53_0393878755;
	public TasksTableOwnerItem.Tas_22_53_0393878755. Owner owner;

    public TasksTableOwnerItem(UnitBox box) {
        super(box);
        id("a68884553");
    }

    @Override
	public void init() {
		super.init();
		if (tas_22_53_0393878755 == null) tas_22_53_0393878755 = register(new Tas_22_53_0393878755(box()).<Tas_22_53_0393878755>id("a_658457044").owner(TasksTableOwnerItem.this));
		if (tas_22_53_0393878755 != null) owner = tas_22_53_0393878755.owner;
	}

	public class Tas_22_53_0393878755 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public TasksTableOwnerItem.Tas_22_53_0393878755. Owner owner;

		public Tas_22_53_0393878755(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (owner == null) owner = register(new Owner(box()).<Owner>id("a962778528").owner(TasksTableOwnerItem.this));
		}

		public class Owner extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

			public Owner(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}