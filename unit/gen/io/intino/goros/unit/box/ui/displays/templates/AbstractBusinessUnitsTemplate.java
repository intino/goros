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

public abstract class AbstractBusinessUnitsTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Ui_12_1_1366840210 ui_12_1_1366840210;
	public Units units;

    public AbstractBusinessUnitsTemplate(B box) {
        super(box);
        id("businessUnitsTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (ui_12_1_1366840210 == null) ui_12_1_1366840210 = register(new Ui_12_1_1366840210(box()).<Ui_12_1_1366840210>id("a_1002728907").owner(AbstractBusinessUnitsTemplate.this));
		if (units == null) units = register(new Units((UnitBox)box()).<Units>id("a1896342810").owner(AbstractBusinessUnitsTemplate.this));
	}

	public class Ui_12_1_1366840210 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Ui_12_1_1366840210(B box) {
			super(box);
			_value("Business units");
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Units extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,BusinessUnitTemplate, java.lang.Void>  {

		public Units(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}

		@Override
		public BusinessUnitTemplate add(java.lang.Void value) {
			BusinessUnitTemplate child = new BusinessUnitTemplate(box());
			child.id(java.util.UUID.randomUUID().toString());
			add(child, "units");
		    notifyAdd(child);
			return child;
		}
		@Override
		public void remove(BusinessUnitTemplate child) {
			removeChild(child, "units");
		}
		public void clear() {
		    super.clear("units");
		}
	}
}