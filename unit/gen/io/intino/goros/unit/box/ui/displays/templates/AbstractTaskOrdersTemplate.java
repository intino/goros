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

public abstract class AbstractTaskOrdersTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;

    public AbstractTaskOrdersTemplate(B box) {
        super(box);
        id("taskOrdersTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a32615864").owner(AbstractTaskOrdersTemplate.this));
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Label(B box) {
			super(box);
			_value("Orders");
		}

		@Override
		public void init() {
			super.init();
		}
	}
}