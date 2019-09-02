package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.NumberViewNotifier;

public abstract class AbstractNumberView<DN extends NumberViewNotifier, B extends Box> extends FieldView<DN, B> {
	public Number number;

    public AbstractNumberView(B box) {
        super(box);
        id("n5R");
    }

    @Override
	public void init() {
		super.init();
		if (number == null) number = register(new Number(box()).<Number>id("o2j").owner(AbstractNumberView.this));
	}

	public class Number extends io.intino.alexandria.ui.displays.components.NumberEditable<io.intino.alexandria.ui.displays.notifiers.NumberEditableNotifier, B>  {

		public Number(B box) {
			super(box);
			_value(0.0);
			_min(-1.0);
			_max(-1.0);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}