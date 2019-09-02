package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import org.siani.goros.box.ui.*;

import org.siani.goros.box.GorosBox;

import org.siani.goros.box.ui.displays.templates.*;



import org.siani.goros.box.ui.displays.notifiers.DesktopPageNotifier;

public abstract class AbstractDesktopPage<DN extends DesktopPageNotifier, B extends Box> extends NodePage<DN, B> {
	public DesktopPage0 desktopPage0;
	public DesktopPage.DesktopPage0. Drawer drawer;
	public DesktopPage.DesktopPage0.Drawer. DesktopPage000 desktopPage000;
	public DesktopPage.DesktopPage0.Drawer.DesktopPage000. DesktopPage0000 desktopPage0000;
	public DesktopPage.DesktopPage0.Drawer.DesktopPage000. DesktopPage0001 desktopPage0001;
	public DesktopPage.DesktopPage0.Drawer. DesktopPage001 desktopPage001;
	public DesktopPage.DesktopPage0.Drawer. Links links;
	public DesktopPage.DesktopPage0.Drawer.Links. SetupOption setupOption;
	public DesktopPage.DesktopPage0.Drawer.Links.SetupOption. DesktopPage00200 desktopPage00200;
	public DesktopPage.DesktopPage0.Drawer.Links.SetupOption. DesktopPage00201 desktopPage00201;
	public DesktopPage.DesktopPage0. DesktopPage01 desktopPage01;
	public DesktopPage.DesktopPage0.DesktopPage01. DesktopPage012 desktopPage012;
	public Header desktopPage0120;
	public DesktopPage.DesktopPage0.DesktopPage01. Block1 block1;
	public DesktopPage.DesktopPage0.DesktopPage01.Block1. ViewSelector viewSelector;
	public DesktopPage.DesktopPage0.DesktopPage01.Block1. Views views;
	public DesktopPage.DesktopPage0.DesktopPage01. DesktopPage011 desktopPage011;
	public Footer desktopPage0110;

    public AbstractDesktopPage(B box) {
        super(box);
        id("vm");
    }

    @Override
	public void init() {
		super.init();
		if (desktopPage0 == null) desktopPage0 = register(new DesktopPage0(box()).<DesktopPage0>id("wR").owner(AbstractDesktopPage.this));
		if (desktopPage0 != null) drawer = desktopPage0.drawer;
		if (drawer != null) desktopPage000 = desktopPage0.drawer.desktopPage000;
		if (desktopPage000 != null) desktopPage0000 = desktopPage0.drawer.desktopPage000.desktopPage0000;
		if (desktopPage000 != null) desktopPage0001 = desktopPage0.drawer.desktopPage000.desktopPage0001;
		if (drawer != null) desktopPage001 = desktopPage0.drawer.desktopPage001;
		if (drawer != null) links = desktopPage0.drawer.links;
		if (links != null) setupOption = desktopPage0.drawer.links.setupOption;
		if (setupOption != null) desktopPage00200 = desktopPage0.drawer.links.setupOption.desktopPage00200;
		if (setupOption != null) desktopPage00201 = desktopPage0.drawer.links.setupOption.desktopPage00201;
		if (desktopPage0 != null) desktopPage01 = desktopPage0.desktopPage01;
		if (desktopPage01 != null) desktopPage012 = desktopPage0.desktopPage01.desktopPage012;
		if (desktopPage012 != null) desktopPage0120 = desktopPage0.desktopPage01.desktopPage012.desktopPage0120;
		if (desktopPage01 != null) block1 = desktopPage0.desktopPage01.block1;
		if (block1 != null) viewSelector = desktopPage0.desktopPage01.block1.viewSelector;
		if (block1 != null) views = desktopPage0.desktopPage01.block1.views;
		if (desktopPage01 != null) desktopPage011 = desktopPage0.desktopPage01.desktopPage011;
		if (desktopPage011 != null) desktopPage0110 = desktopPage0.desktopPage01.desktopPage011.desktopPage0110;



		if (desktopPage0000 != null) desktopPage0000.bindTo(drawer);
		if (desktopPage0001 != null) desktopPage0001.bindTo(drawer);
	}

	public class DesktopPage0 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public DesktopPage.DesktopPage0. Drawer drawer;
		public DesktopPage.DesktopPage0. DesktopPage01 desktopPage01;

		public DesktopPage0(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (drawer == null) drawer = register(new Drawer(box()).<Drawer>id("x9").owner(AbstractDesktopPage.this));
			if (desktopPage01 == null) desktopPage01 = register(new DesktopPage01(box()).<DesktopPage01>id("KR").owner(AbstractDesktopPage.this));
		}

		public class Drawer extends io.intino.alexandria.ui.displays.components.BlockDrawer<io.intino.alexandria.ui.displays.notifiers.BlockDrawerNotifier, B>  {
			public DesktopPage.DesktopPage0.Drawer. DesktopPage000 desktopPage000;
			public DesktopPage.DesktopPage0.Drawer. DesktopPage001 desktopPage001;
			public DesktopPage.DesktopPage0.Drawer. Links links;

			public Drawer(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (desktopPage000 == null) desktopPage000 = register(new DesktopPage000(box()).<DesktopPage000>id("y7").owner(AbstractDesktopPage.this));
				if (desktopPage001 == null) desktopPage001 = register(new DesktopPage001(box()).<DesktopPage001>id("BX").owner(AbstractDesktopPage.this));
				if (links == null) links = register(new Links(box()).<Links>id("Dx").owner(AbstractDesktopPage.this));
			}

			public class DesktopPage000 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public DesktopPage.DesktopPage0.Drawer.DesktopPage000. DesktopPage0000 desktopPage0000;
				public DesktopPage.DesktopPage0.Drawer.DesktopPage000. DesktopPage0001 desktopPage0001;

				public DesktopPage000(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (desktopPage0000 == null) desktopPage0000 = register(new DesktopPage0000(box()).<DesktopPage0000>id("zY").owner(AbstractDesktopPage.this));
					if (desktopPage0001 == null) desktopPage0001 = register(new DesktopPage0001(box()).<DesktopPage0001>id("AO").owner(AbstractDesktopPage.this));
				}

				public class DesktopPage0000 extends io.intino.alexandria.ui.displays.components.OpenDrawer<io.intino.alexandria.ui.displays.notifiers.OpenDrawerNotifier, B>  {

					public DesktopPage0000(B box) {
						super(box);
						_title("open menu");
						_mode(io.intino.alexandria.ui.displays.components.Operation.Mode.valueOf("MaterialIconButton"));
						_icon("ChevronRight");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class DesktopPage0001 extends io.intino.alexandria.ui.displays.components.CloseDrawer<io.intino.alexandria.ui.displays.notifiers.CloseDrawerNotifier, B>  {

					public DesktopPage0001(B box) {
						super(box);
						_title("minimize");
						_mode(io.intino.alexandria.ui.displays.components.Operation.Mode.valueOf("MaterialIconButton"));
						_icon("ChevronLeft");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class DesktopPage001 extends io.intino.alexandria.ui.displays.components.Divider<io.intino.alexandria.ui.displays.notifiers.DividerNotifier, B>  {

				public DesktopPage001(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Links extends io.intino.alexandria.ui.displays.components.SelectorListBox<io.intino.alexandria.ui.displays.notifiers.SelectorListBoxNotifier, B>  {
				public DesktopPage.DesktopPage0.Drawer.Links. SetupOption setupOption;

				public Links(B box) {
					super(box);
					_multipleSelection(false);
				}

				@Override
				public void init() {
					super.init();
					if (setupOption == null) setupOption = register(new SetupOption(box()).<SetupOption>id("Ev").owner(AbstractDesktopPage.this));
				}

				public class SetupOption extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {
					public DesktopPage.DesktopPage0.Drawer.Links.SetupOption. DesktopPage00200 desktopPage00200;
					public DesktopPage.DesktopPage0.Drawer.Links.SetupOption. DesktopPage00201 desktopPage00201;

					public SetupOption(B box) {
						super(box);

						name("setupOption");
					}

					@Override
					public void init() {
						super.init();
						if (desktopPage00200 == null) desktopPage00200 = register(new DesktopPage00200(box()).<DesktopPage00200>id("G7").owner(AbstractDesktopPage.this));
						if (desktopPage00201 == null) desktopPage00201 = register(new DesktopPage00201(box()).<DesktopPage00201>id("J2").owner(AbstractDesktopPage.this));
					}

					public class DesktopPage00200 extends io.intino.alexandria.ui.displays.components.MaterialIcon<io.intino.alexandria.ui.displays.notifiers.MaterialIconNotifier, B>  {

						public DesktopPage00200(B box) {
							super(box);
							_icon("Build");
						}

						@Override
						public void init() {
							super.init();
						}
					}

					public class DesktopPage00201 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

						public DesktopPage00201(B box) {
							super(box);
							_value("setup");
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}
			}
		}

		public class DesktopPage01 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public DesktopPage.DesktopPage0.DesktopPage01. DesktopPage012 desktopPage012;
			public DesktopPage.DesktopPage0.DesktopPage01. Block1 block1;
			public DesktopPage.DesktopPage0.DesktopPage01. DesktopPage011 desktopPage011;

			public DesktopPage01(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (desktopPage012 == null) desktopPage012 = register(new DesktopPage012(box()).<DesktopPage012>id("Lw").owner(AbstractDesktopPage.this));
				if (block1 == null) block1 = register(new Block1(box()).<Block1>id("N6").owner(AbstractDesktopPage.this));
				if (desktopPage011 == null) desktopPage011 = register(new DesktopPage011(box()).<DesktopPage011>id("Ql").owner(AbstractDesktopPage.this));
			}

			public class DesktopPage012 extends io.intino.alexandria.ui.displays.components.Header<io.intino.alexandria.ui.displays.notifiers.HeaderNotifier, B>  {
				public Header desktopPage0120;

				public DesktopPage012(B box) {
					super(box);

					_color("white");
				}

				@Override
				public void init() {
					super.init();
					if (desktopPage0120 == null) desktopPage0120 = register(new Header((GorosBox)box()).id("MA"));
				}
			}

			public class Block1 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public DesktopPage.DesktopPage0.DesktopPage01.Block1. ViewSelector viewSelector;
				public DesktopPage.DesktopPage0.DesktopPage01.Block1. Views views;

				public Block1(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (viewSelector == null) viewSelector = register(new ViewSelector(box()).<ViewSelector>id("Op").owner(AbstractDesktopPage.this));
					if (views == null) views = register(new Views((GorosBox)box()).<Views>id("Pw").owner(AbstractDesktopPage.this));
				}

				public class ViewSelector extends io.intino.alexandria.ui.displays.components.SelectorTabs<io.intino.alexandria.ui.displays.notifiers.SelectorTabsNotifier, B>  {

					public ViewSelector(B box) {
						super(box);
						_multipleSelection(false);
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class Views extends io.intino.alexandria.ui.displays.components.Multiple<GorosBox, View, java.lang.Void>  {

					public Views(GorosBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
					}
					@Override
					public View add(java.lang.Void value) {
						View child = new View(box());
						child.id(java.util.UUID.randomUUID().toString());
						add(child, "views");
						return child;
					}
					public void clear() {
					    super.clear("views");
					}
				}
			}

			public class DesktopPage011 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public Footer desktopPage0110;

				public DesktopPage011(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (desktopPage0110 == null) desktopPage0110 = register(new Footer((GorosBox)box()).id("Rq"));
				}
			}
		}
	}
}