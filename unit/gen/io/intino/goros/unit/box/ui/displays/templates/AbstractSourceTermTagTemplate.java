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

public abstract class AbstractSourceTermTagTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Name name;
	public Value value;
	public Delete delete;

    public AbstractSourceTermTagTemplate(B box) {
        super(box);
        id("sourceTermTagTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (name == null) name = register(new Name(box()).<Name>id("a_1153554788").owner(AbstractSourceTermTagTemplate.this));
		if (value == null) value = register(new Value(box()).<Value>id("a_1393072256").owner(AbstractSourceTermTagTemplate.this));
		if (delete == null) delete = register(new Delete(box()).<Delete>id("a_747212420").owner(AbstractSourceTermTagTemplate.this));
	}

	public class Name extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

		public Name(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Value extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

		public Value(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Delete extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public Delete(B box) {
			super(box);
			_title("Remove");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
			_icon("Clear");
		}

		@Override
		public void init() {
			super.init();
		}
	}
}