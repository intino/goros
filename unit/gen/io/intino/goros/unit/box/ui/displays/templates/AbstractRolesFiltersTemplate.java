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

public abstract class AbstractRolesFiltersTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Reset reset;
	public Rol_111_1_0156687088 rol_111_1_0156687088;
	public ComboFilterTemplate definition;
	public Rol_112_1_1682861417 rol_112_1_1682861417;
	public ComboFilterTemplate type;
	public Rol_113_1_0972382148 rol_113_1_0972382148;
	public ComboFilterTemplate nature;
	public Rol_114_1_01290750496 rol_114_1_01290750496;
	public CheckFilterTemplate expired;

    public AbstractRolesFiltersTemplate(B box) {
        super(box);
        id("rolesFiltersTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (reset == null) reset = register(new Reset(box()).<Reset>id("a_782801145").owner(AbstractRolesFiltersTemplate.this));
		if (rol_111_1_0156687088 == null) rol_111_1_0156687088 = register(new Rol_111_1_0156687088(box()).<Rol_111_1_0156687088>id("a_270513103").owner(AbstractRolesFiltersTemplate.this));
		if (rol_111_1_0156687088 != null) definition = rol_111_1_0156687088.definition;
		if (rol_112_1_1682861417 == null) rol_112_1_1682861417 = register(new Rol_112_1_1682861417(box()).<Rol_112_1_1682861417>id("a313729465").owner(AbstractRolesFiltersTemplate.this));
		if (rol_112_1_1682861417 != null) type = rol_112_1_1682861417.type;
		if (rol_113_1_0972382148 == null) rol_113_1_0972382148 = register(new Rol_113_1_0972382148(box()).<Rol_113_1_0972382148>id("a1288173502").owner(AbstractRolesFiltersTemplate.this));
		if (rol_113_1_0972382148 != null) nature = rol_113_1_0972382148.nature;
		if (rol_114_1_01290750496 == null) rol_114_1_01290750496 = register(new Rol_114_1_01290750496(box()).<Rol_114_1_01290750496>id("a1432041590").owner(AbstractRolesFiltersTemplate.this));
		if (rol_114_1_01290750496 != null) expired = rol_114_1_01290750496.expired;
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

	public class Rol_111_1_0156687088 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public ComboFilterTemplate definition;

		public Rol_111_1_0156687088(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (definition == null) definition = register(new ComboFilterTemplate((UnitBox)box()).id("a1100952305"));
		}
	}

	public class Rol_112_1_1682861417 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public ComboFilterTemplate type;

		public Rol_112_1_1682861417(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (type == null) type = register(new ComboFilterTemplate((UnitBox)box()).id("a_1217673161"));
		}
	}

	public class Rol_113_1_0972382148 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public ComboFilterTemplate nature;

		public Rol_113_1_0972382148(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nature == null) nature = register(new ComboFilterTemplate((UnitBox)box()).id("a1951849347"));
		}
	}

	public class Rol_114_1_01290750496 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public CheckFilterTemplate expired;

		public Rol_114_1_01290750496(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (expired == null) expired = register(new CheckFilterTemplate((UnitBox)box()).id("a_162343286"));
		}
	}
}