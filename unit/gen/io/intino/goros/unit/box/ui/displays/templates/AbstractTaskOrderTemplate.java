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

public abstract class AbstractTaskOrderTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Tasvie_137_1_01335934417 tasvie_137_1_01335934417;
	public TaskOrderTemplate.Tasvie_137_1_01335934417. Tasvie_138_2_11553905826 tasvie_138_2_11553905826;
	public TaskOrderTemplate.Tasvie_137_1_01335934417.Tasvie_138_2_11553905826. SuggestedStartDate suggestedStartDate;
	public TaskOrderTemplate.Tasvie_137_1_01335934417. Tasvie_139_2_01664604867 tasvie_139_2_01664604867;
	public TaskOrderTemplate.Tasvie_137_1_01335934417.Tasvie_139_2_01664604867. SuggestedEndDate suggestedEndDate;
	public Comments comments;
	public Urgent urgent;

    public AbstractTaskOrderTemplate(B box) {
        super(box);
        id("taskOrderTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (tasvie_137_1_01335934417 == null) tasvie_137_1_01335934417 = register(new Tasvie_137_1_01335934417(box()).<Tasvie_137_1_01335934417>id("a1680272292").owner(AbstractTaskOrderTemplate.this));
		if (tasvie_137_1_01335934417 != null) tasvie_138_2_11553905826 = tasvie_137_1_01335934417.tasvie_138_2_11553905826;
		if (tasvie_138_2_11553905826 != null) suggestedStartDate = tasvie_137_1_01335934417.tasvie_138_2_11553905826.suggestedStartDate;
		if (tasvie_137_1_01335934417 != null) tasvie_139_2_01664604867 = tasvie_137_1_01335934417.tasvie_139_2_01664604867;
		if (tasvie_139_2_01664604867 != null) suggestedEndDate = tasvie_137_1_01335934417.tasvie_139_2_01664604867.suggestedEndDate;
		if (comments == null) comments = register(new Comments(box()).<Comments>id("a2122260975").owner(AbstractTaskOrderTemplate.this));
		if (urgent == null) urgent = register(new Urgent(box()).<Urgent>id("a_1410606596").owner(AbstractTaskOrderTemplate.this));
	}

	public class Tasvie_137_1_01335934417 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskOrderTemplate.Tasvie_137_1_01335934417. Tasvie_138_2_11553905826 tasvie_138_2_11553905826;
		public TaskOrderTemplate.Tasvie_137_1_01335934417. Tasvie_139_2_01664604867 tasvie_139_2_01664604867;

		public Tasvie_137_1_01335934417(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tasvie_138_2_11553905826 == null) tasvie_138_2_11553905826 = register(new Tasvie_138_2_11553905826(box()).<Tasvie_138_2_11553905826>id("a_1918787818").owner(AbstractTaskOrderTemplate.this));
			if (tasvie_139_2_01664604867 == null) tasvie_139_2_01664604867 = register(new Tasvie_139_2_01664604867(box()).<Tasvie_139_2_01664604867>id("a2122657784").owner(AbstractTaskOrderTemplate.this));
		}

		public class Tasvie_138_2_11553905826 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskOrderTemplate.Tasvie_137_1_01335934417.Tasvie_138_2_11553905826. SuggestedStartDate suggestedStartDate;

			public Tasvie_138_2_11553905826(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (suggestedStartDate == null) suggestedStartDate = register(new SuggestedStartDate(box()).<SuggestedStartDate>id("a17718905").owner(AbstractTaskOrderTemplate.this));
			}

			public class SuggestedStartDate extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

				public SuggestedStartDate(B box) {
					super(box);
					label("Suggested start date");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class Tasvie_139_2_01664604867 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskOrderTemplate.Tasvie_137_1_01335934417.Tasvie_139_2_01664604867. SuggestedEndDate suggestedEndDate;

			public Tasvie_139_2_01664604867(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (suggestedEndDate == null) suggestedEndDate = register(new SuggestedEndDate(box()).<SuggestedEndDate>id("a_338341103").owner(AbstractTaskOrderTemplate.this));
			}

			public class SuggestedEndDate extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

				public SuggestedEndDate(B box) {
					super(box);
					label("Suggested end date");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class Comments extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

		public Comments(B box) {
			super(box);
			label("Comments");
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Urgent extends io.intino.alexandria.ui.displays.components.ActionSwitch<io.intino.alexandria.ui.displays.notifiers.ActionSwitchNotifier, B>  {

		public Urgent(B box) {
			super(box);
			_title("Urgent");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}
}