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

public abstract class AbstractNodeRevisionsTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public NodeRevisionsTable nodeRevisionsTable;

    public AbstractNodeRevisionsTemplate(B box) {
        super(box);
        id("nodeRevisionsTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (nodeRevisionsTable == null) nodeRevisionsTable = register(new NodeRevisionsTable(box()).<NodeRevisionsTable>id("a249683110").owner(AbstractNodeRevisionsTemplate.this));
	}

	public class NodeRevisionsTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.Revision> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public NodeRevisionsTable(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}
		public void onSelect(io.intino.alexandria.ui.displays.events.SelectionListener listener) {
			super.addSelectionListener(listener);
		}

		public NodeRevisionsTableRow create(org.monet.space.kernel.model.Revision item) {
			NodeRevisionsTableRow row = new NodeRevisionsTableRow((UnitBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class NodeRevisionsTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public NodeRevisionsTemplate.NodeRevisionsTable.NodeRevisionsTableLabelHeading. Nodvie_32_44_11182118849 nodvie_32_44_11182118849;

			public NodeRevisionsTableLabelHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_32_44_11182118849 == null) nodvie_32_44_11182118849 = register(new Nodvie_32_44_11182118849(box()).<Nodvie_32_44_11182118849>id("a_1909596289").owner(AbstractNodeRevisionsTemplate.this));
			}

			public class Nodvie_32_44_11182118849 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Nodvie_32_44_11182118849(B box) {
					super(box);
					_value("Título");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class NodeRevisionsTableOperationsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public NodeRevisionsTemplate.NodeRevisionsTable.NodeRevisionsTableOperationsHeading. Nodvie_35_49_170396901 nodvie_35_49_170396901;

			public NodeRevisionsTableOperationsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_35_49_170396901 == null) nodvie_35_49_170396901 = register(new Nodvie_35_49_170396901(box()).<Nodvie_35_49_170396901>id("a1491908672").owner(AbstractNodeRevisionsTemplate.this));
			}

			public class Nodvie_35_49_170396901 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public NodeRevisionsTemplate.NodeRevisionsTable.NodeRevisionsTableOperationsHeading.Nodvie_35_49_170396901. Nodvie_35_89_11274849166 nodvie_35_89_11274849166;

				public Nodvie_35_49_170396901(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (nodvie_35_89_11274849166 == null) nodvie_35_89_11274849166 = register(new Nodvie_35_89_11274849166(box()).<Nodvie_35_89_11274849166>id("a1995188418").owner(AbstractNodeRevisionsTemplate.this));
				}

				public class Nodvie_35_89_11274849166 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Nodvie_35_89_11274849166(B box) {
						super(box);
						_value("Operaciones");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}
	}
}