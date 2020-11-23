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

public abstract class AbstractComboFilterTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public Options options;

    public AbstractComboFilterTemplate(B box) {
        super(box);
        id("comboFilterTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a1152908214").owner(AbstractComboFilterTemplate.this));
		if (options == null) options = register(new Options(box()).<Options>id("a_1343038752").owner(AbstractComboFilterTemplate.this));
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

	public class Options extends io.intino.alexandria.ui.displays.components.SelectorComboBox<io.intino.alexandria.ui.displays.notifiers.SelectorComboBoxNotifier, B>  {

		public Options(B box) {
			super(box);
			_multipleSelection(true);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}