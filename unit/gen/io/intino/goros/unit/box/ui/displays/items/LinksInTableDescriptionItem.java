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

public class LinksInTableDescriptionItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public Description description;

    public LinksInTableDescriptionItem(UnitBox box) {
        super(box);
        id("a_2069332951");
    }

    @Override
	public void init() {
		super.init();
		if (description == null) description = register(new Description(box()).<Description>id("a_420714266").owner(LinksInTableDescriptionItem.this));
	}

	public class Description extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

		public Description(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}