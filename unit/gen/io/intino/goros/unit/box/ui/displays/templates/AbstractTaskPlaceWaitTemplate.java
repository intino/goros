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

public abstract class AbstractTaskPlaceWaitTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public Description description;
	public PlusHour plusHour;
	public PlusDay plusDay;
	public PlusMonth plusMonth;
	public PlusYear plusYear;
	public FreePlace freePlace;

    public AbstractTaskPlaceWaitTemplate(B box) {
        super(box);
        id("taskPlaceWaitTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a1057690151").owner(AbstractTaskPlaceWaitTemplate.this));
		if (description == null) description = register(new Description(box()).<Description>id("a_205216529").owner(AbstractTaskPlaceWaitTemplate.this));
		if (plusHour == null) plusHour = register(new PlusHour(box()).<PlusHour>id("a1877038731").owner(AbstractTaskPlaceWaitTemplate.this));
		if (plusDay == null) plusDay = register(new PlusDay(box()).<PlusDay>id("a_1879117291").owner(AbstractTaskPlaceWaitTemplate.this));
		if (plusMonth == null) plusMonth = register(new PlusMonth(box()).<PlusMonth>id("a_1936730439").owner(AbstractTaskPlaceWaitTemplate.this));
		if (plusYear == null) plusYear = register(new PlusYear(box()).<PlusYear>id("a1877534948").owner(AbstractTaskPlaceWaitTemplate.this));
		if (freePlace == null) freePlace = register(new FreePlace(box()).<FreePlace>id("a_888424530").owner(AbstractTaskPlaceWaitTemplate.this));
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

	public class Description extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Description(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class PlusHour extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public PlusHour(B box) {
			super(box);
			_title("pospone one hour");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class PlusDay extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public PlusDay(B box) {
			super(box);
			_title("pospone one day");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class PlusMonth extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public PlusMonth(B box) {
			super(box);
			_title("pospone one month");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class PlusYear extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public PlusYear(B box) {
			super(box);
			_title("pospone one year");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class FreePlace extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public FreePlace(B box) {
			super(box);
			_title("don't pospone");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}
}