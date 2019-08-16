package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.NodeViewNotifier;

public abstract class AbstractNodeView<DN extends NodeViewNotifier, B extends Box> extends View<DN, B> {

    public AbstractNodeView(B box) {
        super(box);
        id("_5B");
    }

    @Override
	public void init() {
		super.init();
	}
}