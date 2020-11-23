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

public abstract class AbstractTaskPlaceEditionTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public FormFrame formFrame;
	public NoEditionBlock noEditionBlock;
	public TaskPlaceEditionTemplate.NoEditionBlock. Tasvie_84_39_01099733593 tasvie_84_39_01099733593;
	public SolveErrorMessageBlock solveErrorMessageBlock;
	public TaskPlaceEditionTemplate.SolveErrorMessageBlock. SolveErrorMessage solveErrorMessage;
	public Tasvie_86_1_01366597752 tasvie_86_1_01366597752;
	public TaskPlaceEditionTemplate.Tasvie_86_1_01366597752. Solve solve;

    public AbstractTaskPlaceEditionTemplate(B box) {
        super(box);
        id("taskPlaceEditionTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a_1202811126").owner(AbstractTaskPlaceEditionTemplate.this));
		if (formFrame == null) formFrame = register(new FormFrame(box()).<FormFrame>id("a1339694111").owner(AbstractTaskPlaceEditionTemplate.this));
		if (noEditionBlock == null) noEditionBlock = register(new NoEditionBlock(box()).<NoEditionBlock>id("a1212233338").owner(AbstractTaskPlaceEditionTemplate.this));
		if (noEditionBlock != null) tasvie_84_39_01099733593 = noEditionBlock.tasvie_84_39_01099733593;
		if (solveErrorMessageBlock == null) solveErrorMessageBlock = register(new SolveErrorMessageBlock(box()).<SolveErrorMessageBlock>id("a547141401").owner(AbstractTaskPlaceEditionTemplate.this));
		if (solveErrorMessageBlock != null) solveErrorMessage = solveErrorMessageBlock.solveErrorMessage;
		if (tasvie_86_1_01366597752 == null) tasvie_86_1_01366597752 = register(new Tasvie_86_1_01366597752(box()).<Tasvie_86_1_01366597752>id("a_1729301907").owner(AbstractTaskPlaceEditionTemplate.this));
		if (tasvie_86_1_01366597752 != null) solve = tasvie_86_1_01366597752.solve;
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Label(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class FormFrame extends io.intino.alexandria.ui.displays.components.DisplayStamp<io.intino.alexandria.ui.displays.notifiers.DisplayStampNotifier, B>  {

		public FormFrame(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class NoEditionBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskPlaceEditionTemplate.NoEditionBlock. Tasvie_84_39_01099733593 tasvie_84_39_01099733593;

		public NoEditionBlock(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tasvie_84_39_01099733593 == null) tasvie_84_39_01099733593 = register(new Tasvie_84_39_01099733593(box()).<Tasvie_84_39_01099733593>id("a_1021289757").owner(AbstractTaskPlaceEditionTemplate.this));
		}

		public class Tasvie_84_39_01099733593 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_84_39_01099733593(B box) {
				super(box);
				_value("No form defined");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class SolveErrorMessageBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskPlaceEditionTemplate.SolveErrorMessageBlock. SolveErrorMessage solveErrorMessage;

		public SolveErrorMessageBlock(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (solveErrorMessage == null) solveErrorMessage = register(new SolveErrorMessage(box()).<SolveErrorMessage>id("a_3018984").owner(AbstractTaskPlaceEditionTemplate.this));
		}

		public class SolveErrorMessage extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public SolveErrorMessage(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class Tasvie_86_1_01366597752 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskPlaceEditionTemplate.Tasvie_86_1_01366597752. Solve solve;

		public Tasvie_86_1_01366597752(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (solve == null) solve = register(new Solve(box()).<Solve>id("a1376469158").owner(AbstractTaskPlaceEditionTemplate.this));
		}

		public class Solve extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

			public Solve(B box) {
				super(box);
				_title("Continue");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}