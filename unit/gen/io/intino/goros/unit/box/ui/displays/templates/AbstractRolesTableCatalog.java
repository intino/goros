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

public abstract class AbstractRolesTableCatalog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public RolesTable rolesTable;

    public AbstractRolesTableCatalog(B box) {
        super(box);
        id("rolesTableCatalog");
    }

    @Override
	public void init() {
		super.init();
		if (rolesTable == null) rolesTable = register(new RolesTable(box()).<RolesTable>id("a1863333831").owner(AbstractRolesTableCatalog.this));
	}

	public class RolesTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.Role> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

		public RolesTable(B box) {
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

		public RolesTableRow create(org.monet.space.kernel.model.Role item) {
			RolesTableRow row = new RolesTableRow((UnitBox)box());
			row.id(java.util.UUID.randomUUID().toString());
			row.item(item);
			return row;
		}
		public class RolesTableUserHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public RolesTableCatalog.RolesTable.RolesTableUserHeading. Rol_36_35_01448784380 rol_36_35_01448784380;

			public RolesTableUserHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_36_35_01448784380 == null) rol_36_35_01448784380 = register(new Rol_36_35_01448784380(box()).<Rol_36_35_01448784380>id("a_2032662115").owner(AbstractRolesTableCatalog.this));
			}

			public class Rol_36_35_01448784380 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Rol_36_35_01448784380(B box) {
					super(box);
					_value("User");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class RolesTableDefinitionHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public RolesTableCatalog.RolesTable.RolesTableDefinitionHeading. Rol_42_41_11538999994 rol_42_41_11538999994;

			public RolesTableDefinitionHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_42_41_11538999994 == null) rol_42_41_11538999994 = register(new Rol_42_41_11538999994(box()).<Rol_42_41_11538999994>id("a_1566434122").owner(AbstractRolesTableCatalog.this));
			}

			public class Rol_42_41_11538999994 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTableCatalog.RolesTable.RolesTableDefinitionHeading.Rol_42_41_11538999994. Rol_42_84_01847186117 rol_42_84_01847186117;

				public Rol_42_41_11538999994(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_42_84_01847186117 == null) rol_42_84_01847186117 = register(new Rol_42_84_01847186117(box()).<Rol_42_84_01847186117>id("a_406612787").owner(AbstractRolesTableCatalog.this));
				}

				public class Rol_42_84_01847186117 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Rol_42_84_01847186117(B box) {
						super(box);
						_value("Class");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class RolesTableTypeHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public RolesTableCatalog.RolesTable.RolesTableTypeHeading. Rol_45_35_11889998584 rol_45_35_11889998584;

			public RolesTableTypeHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_45_35_11889998584 == null) rol_45_35_11889998584 = register(new Rol_45_35_11889998584(box()).<Rol_45_35_11889998584>id("a144780177").owner(AbstractRolesTableCatalog.this));
			}

			public class Rol_45_35_11889998584 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTableCatalog.RolesTable.RolesTableTypeHeading.Rol_45_35_11889998584. Rol_45_78_11837729171 rol_45_78_11837729171;

				public Rol_45_35_11889998584(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_45_78_11837729171 == null) rol_45_78_11837729171 = register(new Rol_45_78_11837729171(box()).<Rol_45_78_11837729171>id("a_840582984").owner(AbstractRolesTableCatalog.this));
				}

				public class Rol_45_78_11837729171 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Rol_45_78_11837729171(B box) {
						super(box);
						_value("Type");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class RolesTableNatureHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public RolesTableCatalog.RolesTable.RolesTableNatureHeading. Rol_48_37_1920971333 rol_48_37_1920971333;

			public RolesTableNatureHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_48_37_1920971333 == null) rol_48_37_1920971333 = register(new Rol_48_37_1920971333(box()).<Rol_48_37_1920971333>id("a_646451950").owner(AbstractRolesTableCatalog.this));
			}

			public class Rol_48_37_1920971333 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTableCatalog.RolesTable.RolesTableNatureHeading.Rol_48_37_1920971333. Rol_48_80_12045948064 rol_48_80_12045948064;

				public Rol_48_37_1920971333(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_48_80_12045948064 == null) rol_48_80_12045948064 = register(new Rol_48_80_12045948064(box()).<Rol_48_80_12045948064>id("a_837801149").owner(AbstractRolesTableCatalog.this));
				}

				public class Rol_48_80_12045948064 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Rol_48_80_12045948064(B box) {
						super(box);
						_value("Nature");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class RolesTableStartDateHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public RolesTableCatalog.RolesTable.RolesTableStartDateHeading. Rol_51_40_0116571054 rol_51_40_0116571054;

			public RolesTableStartDateHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_51_40_0116571054 == null) rol_51_40_0116571054 = register(new Rol_51_40_0116571054(box()).<Rol_51_40_0116571054>id("a29598275").owner(AbstractRolesTableCatalog.this));
			}

			public class Rol_51_40_0116571054 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTableCatalog.RolesTable.RolesTableStartDateHeading.Rol_51_40_0116571054. Rol_51_83_11148922195 rol_51_83_11148922195;

				public Rol_51_40_0116571054(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_51_83_11148922195 == null) rol_51_83_11148922195 = register(new Rol_51_83_11148922195(box()).<Rol_51_83_11148922195>id("a517668662").owner(AbstractRolesTableCatalog.this));
				}

				public class Rol_51_83_11148922195 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Rol_51_83_11148922195(B box) {
						super(box);
						_value("Start date");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class RolesTableEndDateHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
			public RolesTableCatalog.RolesTable.RolesTableEndDateHeading. Rol_54_38_12111709867 rol_54_38_12111709867;

			public RolesTableEndDateHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (rol_54_38_12111709867 == null) rol_54_38_12111709867 = register(new Rol_54_38_12111709867(box()).<Rol_54_38_12111709867>id("a1202300214").owner(AbstractRolesTableCatalog.this));
			}

			public class Rol_54_38_12111709867 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesTableCatalog.RolesTable.RolesTableEndDateHeading.Rol_54_38_12111709867. Rol_54_81_01751292564 rol_54_81_01751292564;

				public Rol_54_38_12111709867(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_54_81_01751292564 == null) rol_54_81_01751292564 = register(new Rol_54_81_01751292564(box()).<Rol_54_81_01751292564>id("a274594952").owner(AbstractRolesTableCatalog.this));
				}

				public class Rol_54_81_01751292564 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Rol_54_81_01751292564(B box) {
						super(box);
						_value("End date");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class RolesTableOperationsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {

			public RolesTableOperationsHeading(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}