package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.FieldViewNotifier;

public abstract class AbstractFieldView<DN extends FieldViewNotifier, B extends Box> extends View<DN, B> {

    public AbstractFieldView(B box) {
        super(box);
        id("jRR");
    }

    @Override
	public void init() {
		super.init();
	}
}