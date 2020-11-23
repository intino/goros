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

public abstract class AbstractTasksFiltersTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Reset reset;
	public Tas_62_1_1610483189 tas_62_1_1610483189;
	public ComboFilterTemplate folder;
	public Tas_63_1_0972382148 tas_63_1_0972382148;
	public ComboFilterTemplate nature;
	public Tas_64_1_02050367528 tas_64_1_02050367528;
	public CheckFilterTemplate urgent;

    public AbstractTasksFiltersTemplate(B box) {
        super(box);
        id("tasksFiltersTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (reset == null) reset = register(new Reset(box()).<Reset>id("a999970518").owner(AbstractTasksFiltersTemplate.this));
		if (tas_62_1_1610483189 == null) tas_62_1_1610483189 = register(new Tas_62_1_1610483189(box()).<Tas_62_1_1610483189>id("a_1053781370").owner(AbstractTasksFiltersTemplate.this));
		if (tas_62_1_1610483189 != null) folder = tas_62_1_1610483189.folder;
		if (tas_63_1_0972382148 == null) tas_63_1_0972382148 = register(new Tas_63_1_0972382148(box()).<Tas_63_1_0972382148>id("a1123053130").owner(AbstractTasksFiltersTemplate.this));
		if (tas_63_1_0972382148 != null) nature = tas_63_1_0972382148.nature;
		if (tas_64_1_02050367528 == null) tas_64_1_02050367528 = register(new Tas_64_1_02050367528(box()).<Tas_64_1_02050367528>id("a1237014931").owner(AbstractTasksFiltersTemplate.this));
		if (tas_64_1_02050367528 != null) urgent = tas_64_1_02050367528.urgent;
	}

	public class Reset extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public Reset(B box) {
			super(box);
			_title("Resetear filtros");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Tas_62_1_1610483189 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public ComboFilterTemplate folder;

		public Tas_62_1_1610483189(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (folder == null) folder = register(new ComboFilterTemplate((UnitBox)box()).id("a284156686"));
		}
	}

	public class Tas_63_1_0972382148 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public ComboFilterTemplate nature;

		public Tas_63_1_0972382148(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nature == null) nature = register(new ComboFilterTemplate((UnitBox)box()).id("a304002150"));
		}
	}

	public class Tas_64_1_02050367528 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public CheckFilterTemplate urgent;

		public Tas_64_1_02050367528(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (urgent == null) urgent = register(new CheckFilterTemplate((UnitBox)box()).id("a323189791"));
		}
	}
}