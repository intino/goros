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

public abstract class AbstractCheckFilterTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Selector selector;

    public AbstractCheckFilterTemplate(B box) {
        super(box);
        id("checkFilterTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (selector == null) selector = register(new Selector(box()).<Selector>id("a_1907610845").owner(AbstractCheckFilterTemplate.this));
	}

	public class Selector extends io.intino.alexandria.ui.displays.components.SelectorCheckBox<io.intino.alexandria.ui.displays.notifiers.SelectorCheckBoxNotifier, B>  {

		public Selector(B box) {
			super(box);
			_multipleSelection(false);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}