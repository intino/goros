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

public abstract class AbstractSourceLegendTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Sou_43_1_01300019320 sou_43_1_01300019320;
	public SourceLegendTemplate.Sou_43_1_01300019320. Sou_43_58_11953754543 sou_43_58_11953754543;
	public SourceLegendTemplate.Sou_43_1_01300019320. Sou_43_181_0845344845 sou_43_181_0845344845;
	public Sou_44_1_0862779871 sou_44_1_0862779871;
	public SourceLegendTemplate.Sou_44_1_0862779871. Sou_44_58_11647597214 sou_44_58_11647597214;
	public SourceLegendTemplate.Sou_44_1_0862779871. Sou_44_181_0604353253 sou_44_181_0604353253;
	public Sou_45_1_11332481393 sou_45_1_11332481393;
	public SourceLegendTemplate.Sou_45_1_11332481393. Sou_45_58_11593277622 sou_45_58_11593277622;
	public SourceLegendTemplate.Sou_45_1_11332481393. Sou_45_181_12119083845 sou_45_181_12119083845;

    public AbstractSourceLegendTemplate(B box) {
        super(box);
        id("sourceLegendTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (sou_43_1_01300019320 == null) sou_43_1_01300019320 = register(new Sou_43_1_01300019320(box()).<Sou_43_1_01300019320>id("a10049985").owner(AbstractSourceLegendTemplate.this));
		if (sou_43_1_01300019320 != null) sou_43_58_11953754543 = sou_43_1_01300019320.sou_43_58_11953754543;
		if (sou_43_1_01300019320 != null) sou_43_181_0845344845 = sou_43_1_01300019320.sou_43_181_0845344845;
		if (sou_44_1_0862779871 == null) sou_44_1_0862779871 = register(new Sou_44_1_0862779871(box()).<Sou_44_1_0862779871>id("a2088874150").owner(AbstractSourceLegendTemplate.this));
		if (sou_44_1_0862779871 != null) sou_44_58_11647597214 = sou_44_1_0862779871.sou_44_58_11647597214;
		if (sou_44_1_0862779871 != null) sou_44_181_0604353253 = sou_44_1_0862779871.sou_44_181_0604353253;
		if (sou_45_1_11332481393 == null) sou_45_1_11332481393 = register(new Sou_45_1_11332481393(box()).<Sou_45_1_11332481393>id("a_237550838").owner(AbstractSourceLegendTemplate.this));
		if (sou_45_1_11332481393 != null) sou_45_58_11593277622 = sou_45_1_11332481393.sou_45_58_11593277622;
		if (sou_45_1_11332481393 != null) sou_45_181_12119083845 = sou_45_1_11332481393.sou_45_181_12119083845;
	}

	public class Sou_43_1_01300019320 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceLegendTemplate.Sou_43_1_01300019320. Sou_43_58_11953754543 sou_43_58_11953754543;
		public SourceLegendTemplate.Sou_43_1_01300019320. Sou_43_181_0845344845 sou_43_181_0845344845;

		public Sou_43_1_01300019320(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_43_58_11953754543 == null) sou_43_58_11953754543 = register(new Sou_43_58_11953754543(box()).<Sou_43_58_11953754543>id("a2145093129").owner(AbstractSourceLegendTemplate.this));
			if (sou_43_181_0845344845 == null) sou_43_181_0845344845 = register(new Sou_43_181_0845344845(box()).<Sou_43_181_0845344845>id("a_905133580").owner(AbstractSourceLegendTemplate.this));
		}

		public class Sou_43_58_11953754543 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_43_58_11953754543(B box) {
				super(box);
				_value("C");
			}

			@Override
			public void init() {
				super.init();
			}
			public Sou_43_58_11953754543 textColor(String color) {
			    this._textColor(color);
			    this._refreshHighlight();
			    return this;
			}

			public Sou_43_58_11953754543 backgroundColor(String color) {
			    this._backgroundColor(color);
			    this._refreshHighlight();
			    return this;
			}
		}

		public class Sou_43_181_0845344845 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_43_181_0845344845(B box) {
				super(box);
				_value("Category");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class Sou_44_1_0862779871 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceLegendTemplate.Sou_44_1_0862779871. Sou_44_58_11647597214 sou_44_58_11647597214;
		public SourceLegendTemplate.Sou_44_1_0862779871. Sou_44_181_0604353253 sou_44_181_0604353253;

		public Sou_44_1_0862779871(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_44_58_11647597214 == null) sou_44_58_11647597214 = register(new Sou_44_58_11647597214(box()).<Sou_44_58_11647597214>id("a_1856495025").owner(AbstractSourceLegendTemplate.this));
			if (sou_44_181_0604353253 == null) sou_44_181_0604353253 = register(new Sou_44_181_0604353253(box()).<Sou_44_181_0604353253>id("a854109390").owner(AbstractSourceLegendTemplate.this));
		}

		public class Sou_44_58_11647597214 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_44_58_11647597214(B box) {
				super(box);
				_value("S");
			}

			@Override
			public void init() {
				super.init();
			}
			public Sou_44_58_11647597214 textColor(String color) {
			    this._textColor(color);
			    this._refreshHighlight();
			    return this;
			}

			public Sou_44_58_11647597214 backgroundColor(String color) {
			    this._backgroundColor(color);
			    this._refreshHighlight();
			    return this;
			}
		}

		public class Sou_44_181_0604353253 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_44_181_0604353253(B box) {
				super(box);
				_value("Selectable");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class Sou_45_1_11332481393 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceLegendTemplate.Sou_45_1_11332481393. Sou_45_58_11593277622 sou_45_58_11593277622;
		public SourceLegendTemplate.Sou_45_1_11332481393. Sou_45_181_12119083845 sou_45_181_12119083845;

		public Sou_45_1_11332481393(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_45_58_11593277622 == null) sou_45_58_11593277622 = register(new Sou_45_58_11593277622(box()).<Sou_45_58_11593277622>id("a_1855445049").owner(AbstractSourceLegendTemplate.this));
			if (sou_45_181_12119083845 == null) sou_45_181_12119083845 = register(new Sou_45_181_12119083845(box()).<Sou_45_181_12119083845>id("a_768339295").owner(AbstractSourceLegendTemplate.this));
		}

		public class Sou_45_58_11593277622 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_45_58_11593277622(B box) {
				super(box);
				_value("T");
			}

			@Override
			public void init() {
				super.init();
			}
			public Sou_45_58_11593277622 textColor(String color) {
			    this._textColor(color);
			    this._refreshHighlight();
			    return this;
			}

			public Sou_45_58_11593277622 backgroundColor(String color) {
			    this._backgroundColor(color);
			    this._refreshHighlight();
			    return this;
			}
		}

		public class Sou_45_181_12119083845 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Sou_45_181_12119083845(B box) {
				super(box);
				_value("Term");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}