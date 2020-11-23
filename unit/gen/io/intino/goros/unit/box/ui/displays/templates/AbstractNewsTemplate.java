package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.TemplateNotifier;

public abstract class AbstractNewsTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Header header;
	public NewsTemplate.Header. New_13_2_1564250382 new_13_2_1564250382;
	public NewsTemplate.Header.New_13_2_1564250382. New_14_3_01781972043 new_14_3_01781972043;
	public NewsTemplate.Header.New_13_2_1564250382.New_14_3_01781972043. Label label;
	public NewsTemplate.Header.New_13_2_1564250382. Count count;
	public New_18_1_0567363289 new_18_1_0567363289;
	public NewsTemplate.New_18_1_0567363289. New_19_2_11165882933 new_19_2_11165882933;
	public NewsTemplate.New_18_1_0567363289.New_19_2_11165882933. New_20_3_0877223381 new_20_3_0877223381;
	public NewsTemplate.New_18_1_0567363289.New_19_2_11165882933.New_20_3_0877223381. New_20_50_01883493309 new_20_50_01883493309;

    public AbstractNewsTemplate(B box) {
        super(box);
        id("newsTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (header == null) header = register(new Header(box()).<Header>id("a488525792").owner(AbstractNewsTemplate.this));
		if (header != null) new_13_2_1564250382 = header.new_13_2_1564250382;
		if (new_13_2_1564250382 != null) new_14_3_01781972043 = header.new_13_2_1564250382.new_14_3_01781972043;
		if (new_14_3_01781972043 != null) label = header.new_13_2_1564250382.new_14_3_01781972043.label;
		if (new_13_2_1564250382 != null) count = header.new_13_2_1564250382.count;
		if (new_18_1_0567363289 == null) new_18_1_0567363289 = register(new New_18_1_0567363289(box()).<New_18_1_0567363289>id("a5511773").owner(AbstractNewsTemplate.this));
		if (new_18_1_0567363289 != null) new_19_2_11165882933 = new_18_1_0567363289.new_19_2_11165882933;
		if (new_19_2_11165882933 != null) new_20_3_0877223381 = new_18_1_0567363289.new_19_2_11165882933.new_20_3_0877223381;
		if (new_20_3_0877223381 != null) new_20_50_01883493309 = new_18_1_0567363289.new_19_2_11165882933.new_20_3_0877223381.new_20_50_01883493309;
	}

	public class Header extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NewsTemplate.Header. New_13_2_1564250382 new_13_2_1564250382;

		public Header(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (new_13_2_1564250382 == null) new_13_2_1564250382 = register(new New_13_2_1564250382(box()).<New_13_2_1564250382>id("a_1663999730").owner(AbstractNewsTemplate.this));
		}

		public class New_13_2_1564250382 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NewsTemplate.Header.New_13_2_1564250382. New_14_3_01781972043 new_14_3_01781972043;
			public NewsTemplate.Header.New_13_2_1564250382. Count count;

			public New_13_2_1564250382(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (new_14_3_01781972043 == null) new_14_3_01781972043 = register(new New_14_3_01781972043(box()).<New_14_3_01781972043>id("a1006337503").owner(AbstractNewsTemplate.this));
				if (count == null) count = register(new Count(box()).<Count>id("a_420855183").owner(AbstractNewsTemplate.this));
			}

			public class New_14_3_01781972043 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public NewsTemplate.Header.New_13_2_1564250382.New_14_3_01781972043. Label label;

				public New_14_3_01781972043(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (label == null) label = register(new Label(box()).<Label>id("a_1332929896").owner(AbstractNewsTemplate.this));
				}

				public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Label(B box) {
						super(box);
						_value("News");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class Count extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Count(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class New_18_1_0567363289 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NewsTemplate.New_18_1_0567363289. New_19_2_11165882933 new_19_2_11165882933;

		public New_18_1_0567363289(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (new_19_2_11165882933 == null) new_19_2_11165882933 = register(new New_19_2_11165882933(box()).<New_19_2_11165882933>id("a_1849841940").owner(AbstractNewsTemplate.this));
		}

		public class New_19_2_11165882933 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NewsTemplate.New_18_1_0567363289.New_19_2_11165882933. New_20_3_0877223381 new_20_3_0877223381;

			public New_19_2_11165882933(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (new_20_3_0877223381 == null) new_20_3_0877223381 = register(new New_20_3_0877223381(box()).<New_20_3_0877223381>id("a_824234697").owner(AbstractNewsTemplate.this));
			}

			public class New_20_3_0877223381 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public NewsTemplate.New_18_1_0567363289.New_19_2_11165882933.New_20_3_0877223381. New_20_50_01883493309 new_20_50_01883493309;

				public New_20_3_0877223381(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (new_20_50_01883493309 == null) new_20_50_01883493309 = register(new New_20_50_01883493309(box()).<New_20_50_01883493309>id("a1996904669").owner(AbstractNewsTemplate.this));
				}

				public class New_20_50_01883493309 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public New_20_50_01883493309(B box) {
						super(box);
						_value("Pendiente de implementar");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}
	}
}