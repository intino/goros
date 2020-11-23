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

public class LinksOutTableLabelItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public Label label;

    public LinksOutTableLabelItem(UnitBox box) {
        super(box);
        id("a95169672");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a1768327293").owner(LinksOutTableLabelItem.this));
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, UnitBox> implements io.intino.alexandria.ui.displays.components.addressable.Addressed<Label> {

		public Label(UnitBox box) {
			super(box);
			_title("Loading...");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
			_path("");
		}

		@Override
		public void init() {
			super.init();
		}
		@Override
		public Label address(java.util.function.Function<String, String> addressFromPathResolver) {
		    address(addressFromPathResolver.apply(path()));
		    return this;
		}
	}
}