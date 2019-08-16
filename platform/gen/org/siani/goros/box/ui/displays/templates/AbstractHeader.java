package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.HeaderNotifier;

public abstract class AbstractHeader<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<HeaderNotifier, java.lang.Void, B> {
	public Header0 header0;
	public Header.Header0. Header00 header00;
	public Header.Header0.Header00. Header000 header000;
	public Header1 header1;
	public Header.Header1. Header10 header10;

    public AbstractHeader(B box) {
        super(box);
        id("jR");
    }

    @Override
	public void init() {
		super.init();
		if (header0 == null) header0 = register(new Header0(box()).<Header0>id("k5").owner(AbstractHeader.this));
		if (header0 != null) header00 = header0.header00;
		if (header00 != null) header000 = header0.header00.header000;
		if (header1 == null) header1 = register(new Header1(box()).<Header1>id("nR").owner(AbstractHeader.this));
		if (header1 != null) header10 = header1.header10;
	}

	public class Header0 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public Header.Header0. Header00 header00;

		public Header0(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (header00 == null) header00 = register(new Header00(box()).<Header00>id("l5").owner(AbstractHeader.this));
		}

		public class Header00 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public Header.Header0.Header00. Header000 header000;

			public Header00(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (header000 == null) header000 = register(new Header000(box()).<Header000>id("mO").owner(AbstractHeader.this));
			}

			public class Header000 extends io.intino.alexandria.ui.displays.components.Image<io.intino.alexandria.ui.displays.notifiers.ImageNotifier, B>  {

				public Header000(B box) {
					super(box);
					value(AbstractHeader.class.getResource("/images/logo.png"));
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class Header1 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public Header.Header1. Header10 header10;

		public Header1(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (header10 == null) header10 = register(new Header10(box()).<Header10>id("oj").owner(AbstractHeader.this));
		}

		public class Header10 extends io.intino.alexandria.ui.displays.components.User<io.intino.alexandria.ui.displays.notifiers.UserNotifier, B>  {

			public Header10(B box) {
				super(box);

				color("grey");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}