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

public abstract class AbstractNodeLocationTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Location location;

    public AbstractNodeLocationTemplate(B box) {
        super(box);
        id("nodeLocationTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (location == null) location = register(new Location(box()).<Location>id("a1932760772").owner(AbstractNodeLocationTemplate.this));
	}

	public class Location extends io.intino.alexandria.ui.displays.components.LocationEditable<io.intino.alexandria.ui.displays.notifiers.LocationEditableNotifier, B>  {

		public Location(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}