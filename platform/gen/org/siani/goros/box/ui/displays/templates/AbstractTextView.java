package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.TextViewNotifier;

public abstract class AbstractTextView<DN extends TextViewNotifier, B extends Box> extends FieldView<DN, B> {
	public Text text;

    public AbstractTextView(B box) {
        super(box);
        id("lY5");
    }

    @Override
	public void init() {
		super.init();
		if (text == null) text = register(new Text(box()).<Text>id("mZO").owner(AbstractTextView.this));
	}

	public class Text extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

		public Text(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}