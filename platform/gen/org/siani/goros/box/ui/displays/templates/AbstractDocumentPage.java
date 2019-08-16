package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.DocumentPageNotifier;

public abstract class AbstractDocumentPage<DN extends DocumentPageNotifier, B extends Box> extends NodePage<DN, B> {

    public AbstractDocumentPage(B box) {
        super(box);
        id("YK");
    }

    @Override
	public void init() {
		super.init();
	}
}