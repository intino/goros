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

public class TrashTableOperationsItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public Tra_45_4_01055490174 tra_45_4_01055490174;
	public TrashTableOperationsItem.Tra_45_4_01055490174. Restore restore;

    public TrashTableOperationsItem(UnitBox box) {
        super(box);
        id("a_1980355300");
    }

    @Override
	public void init() {
		super.init();
		if (tra_45_4_01055490174 == null) tra_45_4_01055490174 = register(new Tra_45_4_01055490174(box()).<Tra_45_4_01055490174>id("a476650536").owner(TrashTableOperationsItem.this));
		if (tra_45_4_01055490174 != null) restore = tra_45_4_01055490174.restore;
	}

	public class Tra_45_4_01055490174 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public TrashTableOperationsItem.Tra_45_4_01055490174. Restore restore;

		public Tra_45_4_01055490174(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (restore == null) restore = register(new Restore(box()).<Restore>id("a2091042572").owner(TrashTableOperationsItem.this));
		}

		public class Restore extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, UnitBox>  {

			public Restore(UnitBox box) {
				super(box);
				_title("Restore");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
				_icon("RestoreFromTrash");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}