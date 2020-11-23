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

public abstract class AbstractPublishTermsDialog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Sou_48_1_02122042136 sou_48_1_02122042136;
	public PublishTermsDialog.Sou_48_1_02122042136. Sou_49_2_11326649646 sou_49_2_11326649646;
	public PublishTermsDialog.Sou_48_1_02122042136. Sou_50_2_11109752714 sou_50_2_11109752714;
	public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714. NewTerms newTerms;
	public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714. Sou_52_3_1996802294 sou_52_3_1996802294;
	public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294. Sou_53_4_1818621729 sou_53_4_1818621729;
	public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294.Sou_53_4_1818621729. Publish publish;
	public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294. Sou_54_4_1520741086 sou_54_4_1520741086;
	public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294.Sou_54_4_1520741086. PublishAll publishAll;

    public AbstractPublishTermsDialog(B box) {
        super(box);
        id("publishTermsDialog");
    }

    @Override
	public void init() {
		super.init();
		if (sou_48_1_02122042136 == null) sou_48_1_02122042136 = register(new Sou_48_1_02122042136(box()).<Sou_48_1_02122042136>id("a864934770").owner(AbstractPublishTermsDialog.this));
		if (sou_48_1_02122042136 != null) sou_49_2_11326649646 = sou_48_1_02122042136.sou_49_2_11326649646;
		if (sou_48_1_02122042136 != null) sou_50_2_11109752714 = sou_48_1_02122042136.sou_50_2_11109752714;
		if (sou_50_2_11109752714 != null) newTerms = sou_48_1_02122042136.sou_50_2_11109752714.newTerms;
		if (sou_50_2_11109752714 != null) sou_52_3_1996802294 = sou_48_1_02122042136.sou_50_2_11109752714.sou_52_3_1996802294;
		if (sou_52_3_1996802294 != null) sou_53_4_1818621729 = sou_48_1_02122042136.sou_50_2_11109752714.sou_52_3_1996802294.sou_53_4_1818621729;
		if (sou_53_4_1818621729 != null) publish = sou_48_1_02122042136.sou_50_2_11109752714.sou_52_3_1996802294.sou_53_4_1818621729.publish;
		if (sou_52_3_1996802294 != null) sou_54_4_1520741086 = sou_48_1_02122042136.sou_50_2_11109752714.sou_52_3_1996802294.sou_54_4_1520741086;
		if (sou_54_4_1520741086 != null) publishAll = sou_48_1_02122042136.sou_50_2_11109752714.sou_52_3_1996802294.sou_54_4_1520741086.publishAll;
	}

	public class Sou_48_1_02122042136 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public PublishTermsDialog.Sou_48_1_02122042136. Sou_49_2_11326649646 sou_49_2_11326649646;
		public PublishTermsDialog.Sou_48_1_02122042136. Sou_50_2_11109752714 sou_50_2_11109752714;

		public Sou_48_1_02122042136(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_49_2_11326649646 == null) sou_49_2_11326649646 = register(new Sou_49_2_11326649646(box()).<Sou_49_2_11326649646>id("a_64378376").owner(AbstractPublishTermsDialog.this));
			if (sou_50_2_11109752714 == null) sou_50_2_11109752714 = register(new Sou_50_2_11109752714(box()).<Sou_50_2_11109752714>id("a1563167354").owner(AbstractPublishTermsDialog.this));
		}

		public class Sou_49_2_11326649646 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_49_2_11326649646(B box) {
				super(box);
				_value("New terms added recently that are not published yet");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Sou_50_2_11109752714 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714. NewTerms newTerms;
			public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714. Sou_52_3_1996802294 sou_52_3_1996802294;

			public Sou_50_2_11109752714(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (newTerms == null) newTerms = register(new NewTerms(box()).<NewTerms>id("a_1452060588").owner(AbstractPublishTermsDialog.this));
				if (sou_52_3_1996802294 == null) sou_52_3_1996802294 = register(new Sou_52_3_1996802294(box()).<Sou_52_3_1996802294>id("a916123763").owner(AbstractPublishTermsDialog.this));
			}

			public class NewTerms extends io.intino.alexandria.ui.displays.components.SelectorCheckBox<io.intino.alexandria.ui.displays.notifiers.SelectorCheckBoxNotifier, B>  {

				public NewTerms(B box) {
					super(box);
					_multipleSelection(false);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Sou_52_3_1996802294 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294. Sou_53_4_1818621729 sou_53_4_1818621729;
				public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294. Sou_54_4_1520741086 sou_54_4_1520741086;

				public Sou_52_3_1996802294(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (sou_53_4_1818621729 == null) sou_53_4_1818621729 = register(new Sou_53_4_1818621729(box()).<Sou_53_4_1818621729>id("a1415005011").owner(AbstractPublishTermsDialog.this));
					if (sou_54_4_1520741086 == null) sou_54_4_1520741086 = register(new Sou_54_4_1520741086(box()).<Sou_54_4_1520741086>id("a1005060311").owner(AbstractPublishTermsDialog.this));
				}

				public class Sou_53_4_1818621729 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294.Sou_53_4_1818621729. Publish publish;

					public Sou_53_4_1818621729(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (publish == null) publish = register(new Publish(box()).<Publish>id("a504803623").owner(AbstractPublishTermsDialog.this));
					}

					public class Publish extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

						public Publish(B box) {
							super(box);
							_title("Publish");
							_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}

				public class Sou_54_4_1520741086 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public PublishTermsDialog.Sou_48_1_02122042136.Sou_50_2_11109752714.Sou_52_3_1996802294.Sou_54_4_1520741086. PublishAll publishAll;

					public Sou_54_4_1520741086(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (publishAll == null) publishAll = register(new PublishAll(box()).<PublishAll>id("a1418736793").owner(AbstractPublishTermsDialog.this));
					}

					public class PublishAll extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

						public PublishAll(B box) {
							super(box);
							_title("Publish all");
							_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
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
}