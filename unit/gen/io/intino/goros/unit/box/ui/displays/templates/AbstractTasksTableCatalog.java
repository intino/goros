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

public abstract class AbstractTasksTableCatalog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public TasksTable tasksTable;

    public AbstractTasksTableCatalog(B box) {
        super(box);
        id("tasksTableCatalog");
    }

    @Override
	public void init() {
		super.init();
		if (tasksTable == null) tasksTable = register(new TasksTable(box()).<TasksTable>id("a901307813").owner(AbstractTasksTableCatalog.this));
	}

	public class TasksTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.Task> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public TasksTable(B box) {
			super(box);

			_pageSize(20);
		}

		@Override
		public void init() {
			super.init();
		}
		public void onSelect(io.intino.alexandria.ui.displays.events.SelectionListener listener) {
			super.addSelectionListener(listener);
		}

		public TasksTableRow create(org.monet.space.kernel.model.Task item) {
			TasksTableRow row = new TasksTableRow((UnitBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class TasksTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TasksTableCatalog.TasksTable.TasksTableLabelHeading. Tas_13_36_11182118849 tas_13_36_11182118849;

			public TasksTableLabelHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_13_36_11182118849 == null) tas_13_36_11182118849 = register(new Tas_13_36_11182118849(box()).<Tas_13_36_11182118849>id("a1897022945").owner(AbstractTasksTableCatalog.this));
			}

			public class Tas_13_36_11182118849 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tas_13_36_11182118849(B box) {
					super(box);
					_value("Título");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class TasksTableDescriptionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TasksTableCatalog.TasksTable.TasksTableDescriptionHeading. Tas_18_42_11718484075 tas_18_42_11718484075;

			public TasksTableDescriptionHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_18_42_11718484075 == null) tas_18_42_11718484075 = register(new Tas_18_42_11718484075(box()).<Tas_18_42_11718484075>id("a125528854").owner(AbstractTasksTableCatalog.this));
			}

			public class Tas_18_42_11718484075 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tas_18_42_11718484075(B box) {
					super(box);
					_value("Descripción");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class TasksTableOwnerHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TasksTableCatalog.TasksTable.TasksTableOwnerHeading. Tas_21_36_01126538053 tas_21_36_01126538053;

			public TasksTableOwnerHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_21_36_01126538053 == null) tas_21_36_01126538053 = register(new Tas_21_36_01126538053(box()).<Tas_21_36_01126538053>id("a1327617952").owner(AbstractTasksTableCatalog.this));
			}

			public class Tas_21_36_01126538053 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TasksTableCatalog.TasksTable.TasksTableOwnerHeading.Tas_21_36_01126538053. Tas_21_79_1239563606 tas_21_79_1239563606;

				public Tas_21_36_01126538053(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tas_21_79_1239563606 == null) tas_21_79_1239563606 = register(new Tas_21_79_1239563606(box()).<Tas_21_79_1239563606>id("a_1711707756").owner(AbstractTasksTableCatalog.this));
				}

				public class Tas_21_79_1239563606 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Tas_21_79_1239563606(B box) {
						super(box);
						_value("Responsable");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class TasksTableCreateDateHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TasksTableCatalog.TasksTable.TasksTableCreateDateHeading. Tas_24_41_0357109003 tas_24_41_0357109003;

			public TasksTableCreateDateHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_24_41_0357109003 == null) tas_24_41_0357109003 = register(new Tas_24_41_0357109003(box()).<Tas_24_41_0357109003>id("a1089468797").owner(AbstractTasksTableCatalog.this));
			}

			public class Tas_24_41_0357109003 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TasksTableCatalog.TasksTable.TasksTableCreateDateHeading.Tas_24_41_0357109003. Tas_24_84_01312913994 tas_24_84_01312913994;

				public Tas_24_41_0357109003(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tas_24_84_01312913994 == null) tas_24_84_01312913994 = register(new Tas_24_84_01312913994(box()).<Tas_24_84_01312913994>id("a_1343981289").owner(AbstractTasksTableCatalog.this));
				}

				public class Tas_24_84_01312913994 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Tas_24_84_01312913994(B box) {
						super(box);
						_value("Creada");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class TasksTableUpdateDateHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TasksTableCatalog.TasksTable.TasksTableUpdateDateHeading. Tas_27_41_0574823174 tas_27_41_0574823174;

			public TasksTableUpdateDateHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_27_41_0574823174 == null) tas_27_41_0574823174 = register(new Tas_27_41_0574823174(box()).<Tas_27_41_0574823174>id("a2045777635").owner(AbstractTasksTableCatalog.this));
			}

			public class Tas_27_41_0574823174 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TasksTableCatalog.TasksTable.TasksTableUpdateDateHeading.Tas_27_41_0574823174. Tas_27_84_11810997909 tas_27_84_11810997909;

				public Tas_27_41_0574823174(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tas_27_84_11810997909 == null) tas_27_84_11810997909 = register(new Tas_27_84_11810997909(box()).<Tas_27_84_11810997909>id("a1795620807").owner(AbstractTasksTableCatalog.this));
				}

				public class Tas_27_84_11810997909 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Tas_27_84_11810997909(B box) {
						super(box);
						_value("Actualizada");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class TasksTableCountMessagesHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public TasksTableCatalog.TasksTable.TasksTableCountMessagesHeading. Tas_30_44_01544806647 tas_30_44_01544806647;

			public TasksTableCountMessagesHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_30_44_01544806647 == null) tas_30_44_01544806647 = register(new Tas_30_44_01544806647(box()).<Tas_30_44_01544806647>id("a1350242741").owner(AbstractTasksTableCatalog.this));
			}

			public class Tas_30_44_01544806647 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TasksTableCatalog.TasksTable.TasksTableCountMessagesHeading.Tas_30_44_01544806647. Tas_30_87_0566980342 tas_30_87_0566980342;

				public Tas_30_44_01544806647(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (tas_30_87_0566980342 == null) tas_30_87_0566980342 = register(new Tas_30_87_0566980342(box()).<Tas_30_87_0566980342>id("a604085610").owner(AbstractTasksTableCatalog.this));
				}

				public class Tas_30_87_0566980342 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Tas_30_87_0566980342(B box) {
						super(box);
						_value("Mensajes");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class TasksTableOperationsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {

			public TasksTableOperationsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}