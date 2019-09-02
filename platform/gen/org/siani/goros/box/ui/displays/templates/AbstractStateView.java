package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.StateViewNotifier;

public abstract class AbstractStateView<DN extends StateViewNotifier, B extends Box> extends TaskView<DN, B> {

    public AbstractStateView(B box) {
        super(box);
        id("jRR");
    }

    @Override
	public void init() {
		super.init();
	}
}