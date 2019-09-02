package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.FormViewNotifier;

public abstract class AbstractFormView<DN extends FormViewNotifier, B extends Box> extends NodeView<DN, B> {
	public FormView0 formView0;

    public AbstractFormView(B box) {
        super(box);
        id("_9x");
    }

    @Override
	public void init() {
		super.init();
		if (formView0 == null) formView0 = register(new FormView0((GorosBox)box()).<FormView0>id("_0v").owner(AbstractFormView.this));
	}

	public class FormView0 extends io.intino.alexandria.ui.displays.components.Multiple<GorosBox, FieldView, java.lang.Void>  {

		public FormView0(GorosBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
		@Override
		public FieldView add(java.lang.Void value) {
			FieldView child = new FieldView(box());
			child.id(java.util.UUID.randomUUID().toString());
			add(child, "formView0");
			return child;
		}
		public void clear() {
		    super.clear("formView0");
		}
	}
}