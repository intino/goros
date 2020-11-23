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

public abstract class AbstractTrashTableFilters<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Reset reset;
	public Tra_50_1_1682861417 tra_50_1_1682861417;
	public ComboFilterTemplate type;
	public Tra_51_1_1886557047 tra_51_1_1886557047;
	public DateRangeFilterTemplate deleteDate;

    public AbstractTrashTableFilters(B box) {
        super(box);
        id("trashTableFilters");
    }

    @Override
	public void init() {
		super.init();
		if (reset == null) reset = register(new Reset(box()).<Reset>id("a_380214026").owner(AbstractTrashTableFilters.this));
		if (tra_50_1_1682861417 == null) tra_50_1_1682861417 = register(new Tra_50_1_1682861417(box()).<Tra_50_1_1682861417>id("a2096879843").owner(AbstractTrashTableFilters.this));
		if (tra_50_1_1682861417 != null) type = tra_50_1_1682861417.type;
		if (tra_51_1_1886557047 == null) tra_51_1_1886557047 = register(new Tra_51_1_1886557047(box()).<Tra_51_1_1886557047>id("a1439791037").owner(AbstractTrashTableFilters.this));
		if (tra_51_1_1886557047 != null) deleteDate = tra_51_1_1886557047.deleteDate;
	}

	public class Reset extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public Reset(B box) {
			super(box);
			_title("Reset filters");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Tra_50_1_1682861417 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public ComboFilterTemplate type;

		public Tra_50_1_1682861417(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (type == null) type = register(new ComboFilterTemplate((UnitBox)box()).id("a809574469"));
		}
	}

	public class Tra_51_1_1886557047 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public DateRangeFilterTemplate deleteDate;

		public Tra_51_1_1886557047(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (deleteDate == null) deleteDate = register(new DateRangeFilterTemplate((UnitBox)box()).id("a2030191203"));
		}
	}
}