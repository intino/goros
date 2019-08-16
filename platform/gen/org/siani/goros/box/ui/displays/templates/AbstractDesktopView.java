package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.DesktopViewNotifier;

public abstract class AbstractDesktopView<DN extends DesktopViewNotifier, B extends Box> extends NodeView<DN, B> {

    public AbstractDesktopView(B box) {
        super(box);
        id("_6n");
    }

    @Override
	public void init() {
		super.init();
	}
}