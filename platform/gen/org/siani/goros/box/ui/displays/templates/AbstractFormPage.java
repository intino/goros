package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.FormPageNotifier;

public abstract class AbstractFormPage<DN extends FormPageNotifier, B extends Box> extends NodePage<DN, B> {
	public FormPage0 formPage0;

    public AbstractFormPage(B box) {
        super(box);
        id("ZJ");
    }

    @Override
	public void init() {
		super.init();
		if (formPage0 == null) formPage0 = register(new FormPage0((GorosBox)box()).<FormPage0>id("_1R").owner(AbstractFormPage.this));
	}

	public class FormPage0 extends io.intino.alexandria.ui.displays.components.Multiple<GorosBox, FieldView, java.lang.Void>  {

		public FormPage0(GorosBox box) {
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
			add(child, "formPage0");
			return child;
		}
		public void clear() {
		    super.clear("formPage0");
		}
	}
}