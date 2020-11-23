package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractTrashTableCatalog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public TrashTable trashTable;

    public AbstractTrashTableCatalog(B box) {
        super(box);
        id("trashTableCatalog");
    }

    @Override
	public void init() {
		super.init();
		if (trashTable == null) trashTable = register(new TrashTable(box()).<TrashTable>id("a1332160849").owner(AbstractTrashTableCatalog.this));
	}

	public class TrashTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.Node>  {

		public TrashTable(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}


		public TrashTableRow create(org.monet.space.kernel.model.Node item) {
			TrashTableRow row = new TrashTableRow((UnitBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class TrashTableTypeHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TrashTableCatalog.TrashTable.TrashTableTypeHeading. Tra_34_35_11837729171 tra_34_35_11837729171;

			public TrashTableTypeHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tra_34_35_11837729171 == null) tra_34_35_11837729171 = register(new Tra_34_35_11837729171(box()).<Tra_34_35_11837729171>id("a_717572068").owner(AbstractTrashTableCatalog.this));
			}

			public class Tra_34_35_11837729171 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tra_34_35_11837729171(B box) {
					super(box);
					_value("Type");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class TrashTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TrashTableCatalog.TrashTable.TrashTableLabelHeading. Tra_37_36_0143668709 tra_37_36_0143668709;

			public TrashTableLabelHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tra_37_36_0143668709 == null) tra_37_36_0143668709 = register(new Tra_37_36_0143668709(box()).<Tra_37_36_0143668709>id("a1952730974").owner(AbstractTrashTableCatalog.this));
			}

			public class Tra_37_36_0143668709 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tra_37_36_0143668709(B box) {
					super(box);
					_value("Title");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class TrashTableDeleteDateHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TrashTableCatalog.TrashTable.TrashTableDeleteDateHeading. Tra_40_41_02138657774 tra_40_41_02138657774;

			public TrashTableDeleteDateHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tra_40_41_02138657774 == null) tra_40_41_02138657774 = register(new Tra_40_41_02138657774(box()).<Tra_40_41_02138657774>id("a613792618").owner(AbstractTrashTableCatalog.this));
			}

			public class Tra_40_41_02138657774 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tra_40_41_02138657774(B box) {
					super(box);
					_value("Delete date");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class TrashTableOperationsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {

			public TrashTableOperationsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}