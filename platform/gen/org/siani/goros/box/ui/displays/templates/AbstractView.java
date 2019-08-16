package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.ViewNotifier;

public abstract class AbstractView<DN extends ViewNotifier, B extends Box> extends io.intino.alexandria.ui.displays.Component<DN, B> {
	public Label label;

    public AbstractView(B box) {
        super(box);
        id("_3M");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("_41").owner(AbstractView.this));
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
}