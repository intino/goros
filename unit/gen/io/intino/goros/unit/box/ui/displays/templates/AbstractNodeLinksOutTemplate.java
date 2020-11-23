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

public abstract class AbstractNodeLinksOutTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public LinksOutTable linksOutTable;

    public AbstractNodeLinksOutTemplate(B box) {
        super(box);
        id("nodeLinksOutTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (linksOutTable == null) linksOutTable = register(new LinksOutTable(box()).<LinksOutTable>id("a_1667404950").owner(AbstractNodeLinksOutTemplate.this));
	}

	public class LinksOutTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.Node>  {

		public LinksOutTable(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}


		public LinksOutTableRow create(org.monet.space.kernel.model.Node item) {
			LinksOutTableRow row = new LinksOutTableRow((UnitBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class LinksOutTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public NodeLinksOutTemplate.LinksOutTable.LinksOutTableLabelHeading. Nodvie_22_39_11182118849 nodvie_22_39_11182118849;

			public LinksOutTableLabelHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_22_39_11182118849 == null) nodvie_22_39_11182118849 = register(new Nodvie_22_39_11182118849(box()).<Nodvie_22_39_11182118849>id("a_1080800904").owner(AbstractNodeLinksOutTemplate.this));
			}

			public class Nodvie_22_39_11182118849 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Nodvie_22_39_11182118849(B box) {
					super(box);
					_value("Título");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class LinksOutTableDescriptionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public NodeLinksOutTemplate.LinksOutTable.LinksOutTableDescriptionHeading. Nodvie_25_45_11718484075 nodvie_25_45_11718484075;

			public LinksOutTableDescriptionHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_25_45_11718484075 == null) nodvie_25_45_11718484075 = register(new Nodvie_25_45_11718484075(box()).<Nodvie_25_45_11718484075>id("a1756819393").owner(AbstractNodeLinksOutTemplate.this));
			}

			public class Nodvie_25_45_11718484075 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Nodvie_25_45_11718484075(B box) {
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