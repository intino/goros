package io.intino.goros.unit.box.ui.displays.items;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.ItemNotifier;

public class TasksTableCreateDateItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Tas_25_58_11657982757 tas_25_58_11657982757;
	public TasksTableCreateDateItem.Tas_25_58_11657982757. CreateDate createDate;

    public TasksTableCreateDateItem(UnitBox box) {
        super(box);
        id("a_1540070121");
    }

    @Override
	public void init() {
		super.init();
		if (tas_25_58_11657982757 == null) tas_25_58_11657982757 = register(new Tas_25_58_11657982757(box()).<Tas_25_58_11657982757>id("a522548445").owner(TasksTableCreateDateItem.this));
		if (tas_25_58_11657982757 != null) createDate = tas_25_58_11657982757.createDate;
	}

	public class Tas_25_58_11657982757 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public TasksTableCreateDateItem.Tas_25_58_11657982757. CreateDate createDate;

		public Tas_25_58_11657982757(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (createDate == null) createDate = register(new CreateDate(box()).<CreateDate>id("a1190824347").owner(TasksTableCreateDateItem.this));
		}

		public class CreateDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

			public CreateDate(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}