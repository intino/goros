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

public class NodeRevisionsTableOperationsItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Revision, UnitBox> {
	public Nodvie_37_4_01974563943 nodvie_37_4_01974563943;
	public NodeRevisionsTableOperationsItem.Nodvie_37_4_01974563943. Restore restore;

    public NodeRevisionsTableOperationsItem(UnitBox box) {
        super(box);
        id("a_1811963633");
    }

    @Override
	public void init() {
		super.init();
		if (nodvie_37_4_01974563943 == null) nodvie_37_4_01974563943 = register(new Nodvie_37_4_01974563943(box()).<Nodvie_37_4_01974563943>id("a584140661").owner(NodeRevisionsTableOperationsItem.this));
		if (nodvie_37_4_01974563943 != null) restore = nodvie_37_4_01974563943.restore;
	}

	public class Nodvie_37_4_01974563943 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public NodeRevisionsTableOperationsItem.Nodvie_37_4_01974563943. Restore restore;

		public Nodvie_37_4_01974563943(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (restore == null) restore = register(new Restore(box()).<Restore>id("a111404379").owner(NodeRevisionsTableOperationsItem.this));
		}

		public class Restore extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, UnitBox>  {

			public Restore(UnitBox box) {
				super(box);
				_title("Restaurar");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
				_icon("Restore");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}