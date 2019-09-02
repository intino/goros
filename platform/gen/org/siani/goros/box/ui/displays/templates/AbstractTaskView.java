package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.TaskViewNotifier;

public abstract class AbstractTaskView<DN extends TaskViewNotifier, B extends Box> extends View<DN, B> {

    public AbstractTaskView(B box) {
        super(box);
        id("gJY");
    }

    @Override
	public void init() {
		super.init();
	}
}