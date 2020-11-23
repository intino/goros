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

public abstract class AbstractNodeLinksInTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public LinksInTable linksInTable;

    public AbstractNodeLinksInTemplate(B box) {
        super(box);
        id("nodeLinksInTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (linksInTable == null) linksInTable = register(new LinksInTable(box()).<LinksInTable>id("a_1124382024").owner(AbstractNodeLinksInTemplate.this));
	}

	public class LinksInTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.Node>  {

		public LinksInTable(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}


		public LinksInTableRow create(org.monet.space.kernel.model.Node item) {
			LinksInTableRow row = new LinksInTableRow((UnitBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class LinksInTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public NodeLinksInTemplate.LinksInTable.LinksInTableLabelHeading. Nodvie_12_38_11182118849 nodvie_12_38_11182118849;

			public LinksInTableLabelHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_12_38_11182118849 == null) nodvie_12_38_11182118849 = register(new Nodvie_12_38_11182118849(box()).<Nodvie_12_38_11182118849>id("a165999372").owner(AbstractNodeLinksInTemplate.this));
			}

			public class Nodvie_12_38_11182118849 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Nodvie_12_38_11182118849(B box) {
					super(box);
					_value("Título");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class LinksInTableDescriptionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public NodeLinksInTemplate.LinksInTable.LinksInTableDescriptionHeading. Nodvie_15_44_11718484075 nodvie_15_44_11718484075;

			public LinksInTableDescriptionHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_15_44_11718484075 == null) nodvie_15_44_11718484075 = register(new Nodvie_15_44_11718484075(box()).<Nodvie_15_44_11718484075>id("a1107571963").owner(AbstractNodeLinksInTemplate.this));
			}

			public class Nodvie_15_44_11718484075 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Nodvie_15_44_11718484075(B box) {
					super(box);
					_value("Descripción");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}
}