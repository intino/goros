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

public abstract class AbstractBusinessUnitTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Ui_16_1_197012341 ui_16_1_197012341;
	public BusinessUnitTemplate.Ui_16_1_197012341. Label label;
	public BusinessUnitTemplate.Ui_16_1_197012341. LabelText labelText;
	public BusinessUnitTemplate.Ui_16_1_197012341. Active active;
	public UnitFrame unitFrame;

    public AbstractBusinessUnitTemplate(B box) {
        super(box);
        id("businessUnitTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (ui_16_1_197012341 == null) ui_16_1_197012341 = register(new Ui_16_1_197012341(box()).<Ui_16_1_197012341>id("a54338127").owner(AbstractBusinessUnitTemplate.this));
		if (ui_16_1_197012341 != null) label = ui_16_1_197012341.label;
		if (ui_16_1_197012341 != null) labelText = ui_16_1_197012341.labelText;
		if (ui_16_1_197012341 != null) active = ui_16_1_197012341.active;
		if (unitFrame == null) unitFrame = register(new UnitFrame(box()).<UnitFrame>id("a1944867175").owner(AbstractBusinessUnitTemplate.this));
	}

	public class Ui_16_1_197012341 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public BusinessUnitTemplate.Ui_16_1_197012341. Label label;
		public BusinessUnitTemplate.Ui_16_1_197012341. LabelText labelText;
		public BusinessUnitTemplate.Ui_16_1_197012341. Active active;

		public Ui_16_1_197012341(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (label == null) label = register(new Label(box()).<Label>id("a23238615").owner(AbstractBusinessUnitTemplate.this));
			if (labelText == null) labelText = register(new LabelText(box()).<LabelText>id("a_600011356").owner(AbstractBusinessUnitTemplate.this));
			if (active == null) active = register(new Active(box()).<Active>id("a407863939").owner(AbstractBusinessUnitTemplate.this));
		}

		public class Label extends io.intino.alexandria.ui.displays.components.OpenSite<io.intino.alexandria.ui.displays.notifiers.OpenSiteNotifier, B>  {

			public Label(B box) {
				super(box);
				_title("");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
				_site("");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class LabelText extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public LabelText(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Active extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Active(B box) {
				super(box);
				_value("(current)");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class UnitFrame extends io.intino.alexandria.ui.displays.components.Frame<io.intino.alexandria.ui.displays.notifiers.FrameNotifier, B>  {

		public UnitFrame(B box) {
			super(box);
			_url("");
		}

		@Override
		public void init() {
			super.init();
		}
	}
}