package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.FooterNotifier;

public class Footer extends io.intino.alexandria.ui.displays.components.Template<FooterNotifier, java.lang.Void, GorosBox> {
	public Footer0 footer0;

    public Footer(GorosBox box) {
        super(box);
        id("p2");
    }

    @Override
	public void init() {
		super.init();
		if (footer0 == null) footer0 = register(new Footer0(box()).<Footer0>id("q2").owner(Footer.this));
	}

	public class Footer0 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, GorosBox>  {

		public Footer0(GorosBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}
}