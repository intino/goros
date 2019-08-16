package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.PageNotifier;

public abstract class AbstractPage<DN extends PageNotifier, B extends Box> extends io.intino.alexandria.ui.displays.Component<DN, B> {

    public AbstractPage(B box) {
        super(box);
        id("gY");
    }

    @Override
	public void init() {
		super.init();
	}
}