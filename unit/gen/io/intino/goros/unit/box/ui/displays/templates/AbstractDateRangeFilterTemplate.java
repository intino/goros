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

public abstract class AbstractDateRangeFilterTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public Catfiltyp_22_1_0946774713 catfiltyp_22_1_0946774713;
	public DateRangeFilterTemplate.Catfiltyp_22_1_0946774713. From from;
	public DateRangeFilterTemplate.Catfiltyp_22_1_0946774713. To to;

    public AbstractDateRangeFilterTemplate(B box) {
        super(box);
        id("dateRangeFilterTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a_929956521").owner(AbstractDateRangeFilterTemplate.this));
		if (catfiltyp_22_1_0946774713 == null) catfiltyp_22_1_0946774713 = register(new Catfiltyp_22_1_0946774713(box()).<Catfiltyp_22_1_0946774713>id("a1745292057").owner(AbstractDateRangeFilterTemplate.this));
		if (catfiltyp_22_1_0946774713 != null) from = catfiltyp_22_1_0946774713.from;
		if (catfiltyp_22_1_0946774713 != null) to = catfiltyp_22_1_0946774713.to;
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Label(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Catfiltyp_22_1_0946774713 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public DateRangeFilterTemplate.Catfiltyp_22_1_0946774713. From from;
		public DateRangeFilterTemplate.Catfiltyp_22_1_0946774713. To to;

		public Catfiltyp_22_1_0946774713(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (from == null) from = register(new From(box()).<From>id("a979259520").owner(AbstractDateRangeFilterTemplate.this));
			if (to == null) to = register(new To(box()).<To>id("a_1393392431").owner(AbstractDateRangeFilterTemplate.this));
		}

		public class From extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

			public From(B box) {
				super(box);
				label("Desde");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class To extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

			public To(B box) {
				super(box);
				label("Hasta");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}