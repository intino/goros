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

public class AssignTaskDialogTableFullnameItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.User, UnitBox> {
	public FullName fullName;

    public AssignTaskDialogTableFullnameItem(UnitBox box) {
        super(box);
        id("a_997855662");
    }

    @Override
	public void init() {
		super.init();
		if (fullName == null) fullName = register(new FullName(box()).<FullName>id("a1552183559").owner(AssignTaskDialogTableFullnameItem.this));
	}

	public class FullName extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public FullName(UnitBox box) {
			super(box);
			_value("Loading...");
		}

		@Override
		public void init() {
			super.init();
		}
	}
}