package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.NodePageNotifier;

public abstract class AbstractNodePage<DN extends NodePageNotifier, B extends Box> extends Page<DN, B> {

    public AbstractNodePage(B box) {
        super(box);
        id("rE");
    }

    @Override
	public void init() {
		super.init();
	}
}