package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.TaskPageNotifier;

public abstract class AbstractTaskPage<DN extends TaskPageNotifier, B extends Box> extends Page<DN, B> {

    public AbstractTaskPage(B box) {
        super(box);
        id("_2K");
    }

    @Override
	public void init() {
		super.init();
	}
}