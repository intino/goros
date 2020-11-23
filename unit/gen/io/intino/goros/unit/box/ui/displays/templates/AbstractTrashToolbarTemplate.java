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

public abstract class AbstractTrashToolbarTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public EmptyTrash emptyTrash;

    public AbstractTrashToolbarTemplate(B box) {
        super(box);
        id("trashToolbarTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (emptyTrash == null) emptyTrash = register(new EmptyTrash(box()).<EmptyTrash>id("a71247982").owner(AbstractTrashToolbarTemplate.this));
	}

	public class EmptyTrash extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public EmptyTrash(B box) {
			super(box);
			_title("Empty trash");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
		}

		@Override
		public void init() {
			super.init();
		}
	}
}