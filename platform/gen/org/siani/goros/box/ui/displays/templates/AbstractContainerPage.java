package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.ContainerPageNotifier;

public abstract class AbstractContainerPage<DN extends ContainerPageNotifier, B extends Box> extends NodePage<DN, B> {

    public AbstractContainerPage(B box) {
        super(box);
        id("VM");
    }

    @Override
	public void init() {
		super.init();
	}
}