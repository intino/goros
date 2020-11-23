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

public abstract class AbstractRolesToolbarTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Rol_61_1_02052593266 rol_61_1_02052593266;
	public AddRoleDialog addRoleDialog;
	public RolesToolbarTemplate.AddRoleDialog. Content content;
	public RolesToolbarTemplate.AddRoleDialog.Content. Type type;
	public RolesToolbarTemplate.AddRoleDialog.Content. Definition definition;
	public RolesToolbarTemplate.AddRoleDialog.Content. Rol_67_3_11053800386 rol_67_3_11053800386;
	public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386. Rol_68_4_01829324727 rol_68_4_01829324727;
	public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386.Rol_68_4_01829324727. BeginDate beginDate;
	public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386. Rol_69_4_12027464911 rol_69_4_12027464911;
	public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386.Rol_69_4_12027464911. EndDate endDate;
	public RolesToolbarTemplate.AddRoleDialog.Content. UserRoleBlock userRoleBlock;
	public RolesToolbarTemplate.AddRoleDialog.Content.UserRoleBlock. Rol_72_4_0553596432 rol_72_4_0553596432;
	public RolesToolbarTemplate.AddRoleDialog.Content.UserRoleBlock. AddRoleUserTable addRoleUserTable;
	public RolesToolbarTemplate.AddRoleDialog.Content. ServiceRoleBlock serviceRoleBlock;
	public RolesToolbarTemplate.AddRoleDialog.Content.ServiceRoleBlock. Rol_83_4_01782256806 rol_83_4_01782256806;
	public RolesToolbarTemplate.AddRoleDialog.Content.ServiceRoleBlock. AddRoleServiceTable addRoleServiceTable;
	public RolesToolbarTemplate.AddRoleDialog.Content. FeederRoleBlock feederRoleBlock;
	public RolesToolbarTemplate.AddRoleDialog.Content.FeederRoleBlock. Rol_94_4_02065703568 rol_94_4_02065703568;
	public RolesToolbarTemplate.AddRoleDialog.Content.FeederRoleBlock. AddRoleFeederTable addRoleFeederTable;
	public RolesToolbarTemplate.AddRoleDialog. Rol_103_2_1955995399 rol_103_2_1955995399;
	public RolesToolbarTemplate.AddRoleDialog. Rol_104_2_01773733018 rol_104_2_01773733018;
	public RolesToolbarTemplate.AddRoleDialog.Rol_104_2_01773733018. Cancel cancel;
	public RolesToolbarTemplate.AddRoleDialog.Rol_104_2_01773733018. Accept accept;

    public AbstractRolesToolbarTemplate(B box) {
        super(box);
        id("rolesToolbarTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (rol_61_1_02052593266 == null) rol_61_1_02052593266 = register(new Rol_61_1_02052593266(box()).<Rol_61_1_02052593266>id("a763156980").owner(AbstractRolesToolbarTemplate.this));
		if (addRoleDialog == null) addRoleDialog = register(new AddRoleDialog(box()).<AddRoleDialog>id("a_1615998441").owner(AbstractRolesToolbarTemplate.this));
		if (addRoleDialog != null) content = addRoleDialog.content;
		if (content != null) type = addRoleDialog.content.type;
		if (content != null) definition = addRoleDialog.content.definition;
		if (content != null) rol_67_3_11053800386 = addRoleDialog.content.rol_67_3_11053800386;
		if (rol_67_3_11053800386 != null) rol_68_4_01829324727 = addRoleDialog.content.rol_67_3_11053800386.rol_68_4_01829324727;
		if (rol_68_4_01829324727 != null) beginDate = addRoleDialog.content.rol_67_3_11053800386.rol_68_4_01829324727.beginDate;
		if (rol_67_3_11053800386 != null) rol_69_4_12027464911 = addRoleDialog.content.rol_67_3_11053800386.rol_69_4_12027464911;
		if (rol_69_4_12027464911 != null) endDate = addRoleDialog.content.rol_67_3_11053800386.rol_69_4_12027464911.endDate;
		if (content != null) userRoleBlock = addRoleDialog.content.userRoleBlock;
		if (userRoleBlock != null) rol_72_4_0553596432 = addRoleDialog.content.userRoleBlock.rol_72_4_0553596432;
		if (userRoleBlock != null) addRoleUserTable = addRoleDialog.content.userRoleBlock.addRoleUserTable;
		if (content != null) serviceRoleBlock = addRoleDialog.content.serviceRoleBlock;
		if (serviceRoleBlock != null) rol_83_4_01782256806 = addRoleDialog.content.serviceRoleBlock.rol_83_4_01782256806;
		if (serviceRoleBlock != null) addRoleServiceTable = addRoleDialog.content.serviceRoleBlock.addRoleServiceTable;
		if (content != null) feederRoleBlock = addRoleDialog.content.feederRoleBlock;
		if (feederRoleBlock != null) rol_94_4_02065703568 = addRoleDialog.content.feederRoleBlock.rol_94_4_02065703568;
		if (feederRoleBlock != null) addRoleFeederTable = addRoleDialog.content.feederRoleBlock.addRoleFeederTable;
		if (addRoleDialog != null) rol_103_2_1955995399 = addRoleDialog.rol_103_2_1955995399;
		if (addRoleDialog != null) rol_104_2_01773733018 = addRoleDialog.rol_104_2_01773733018;
		if (rol_104_2_01773733018 != null) cancel = addRoleDialog.rol_104_2_01773733018.cancel;
		if (rol_104_2_01773733018 != null) accept = addRoleDialog.rol_104_2_01773733018.accept;
		if (rol_61_1_02052593266 != null) rol_61_1_02052593266.bindTo(addRoleDialog);



		if (rol_72_4_0553596432 != null) rol_72_4_0553596432.bindTo(addRoleUserTable);

		if (rol_83_4_01782256806 != null) rol_83_4_01782256806.bindTo(addRoleServiceTable);

		if (rol_94_4_02065703568 != null) rol_94_4_02065703568.bindTo(addRoleFeederTable);

		if (cancel != null) cancel.bindTo(addRoleDialog);
	}

	public class Rol_61_1_02052593266 extends io.intino.alexandria.ui.displays.components.OpenDialog<io.intino.alexandria.ui.displays.notifiers.OpenDialogNotifier, B>  {

		public Rol_61_1_02052593266(B box) {
			super(box);
			_title("Add role");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class AddRoleDialog extends io.intino.alexandria.ui.displays.components.Dialog<io.intino.alexandria.ui.displays.notifiers.DialogNotifier, B>  {
		public RolesToolbarTemplate.AddRoleDialog. Content content;
		public RolesToolbarTemplate.AddRoleDialog. Rol_103_2_1955995399 rol_103_2_1955995399;
		public RolesToolbarTemplate.AddRoleDialog. Rol_104_2_01773733018 rol_104_2_01773733018;

		public AddRoleDialog(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (content == null) content = register(new Content(box()).<Content>id("a_584538543").owner(AbstractRolesToolbarTemplate.this));
			if (rol_103_2_1955995399 == null) rol_103_2_1955995399 = register(new Rol_103_2_1955995399(box()).<Rol_103_2_1955995399>id("a1817823830").owner(AbstractRolesToolbarTemplate.this));
			if (rol_104_2_01773733018 == null) rol_104_2_01773733018 = register(new Rol_104_2_01773733018(box()).<Rol_104_2_01773733018>id("a_118849437").owner(AbstractRolesToolbarTemplate.this));
		}

		public class Content extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RolesToolbarTemplate.AddRoleDialog.Content. Type type;
			public RolesToolbarTemplate.AddRoleDialog.Content. Definition definition;
			public RolesToolbarTemplate.AddRoleDialog.Content. Rol_67_3_11053800386 rol_67_3_11053800386;
			public RolesToolbarTemplate.AddRoleDialog.Content. UserRoleBlock userRoleBlock;
			public RolesToolbarTemplate.AddRoleDialog.Content. ServiceRoleBlock serviceRoleBlock;
			public RolesToolbarTemplate.AddRoleDialog.Content. FeederRoleBlock feederRoleBlock;

			public Content(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (type == null) type = register(new Type(box()).<Type>id("a_268899224").owner(AbstractRolesToolbarTemplate.this));
				if (definition == null) definition = register(new Definition(box()).<Definition>id("a2125494273").owner(AbstractRolesToolbarTemplate.this));
				if (rol_67_3_11053800386 == null) rol_67_3_11053800386 = register(new Rol_67_3_11053800386(box()).<Rol_67_3_11053800386>id("a522332155").owner(AbstractRolesToolbarTemplate.this));
				if (userRoleBlock == null) userRoleBlock = register(new UserRoleBlock(box()).<UserRoleBlock>id("a_985396034").owner(AbstractRolesToolbarTemplate.this));
				if (serviceRoleBlock == null) serviceRoleBlock = register(new ServiceRoleBlock(box()).<ServiceRoleBlock>id("a_972076368").owner(AbstractRolesToolbarTemplate.this));
				if (feederRoleBlock == null) feederRoleBlock = register(new FeederRoleBlock(box()).<FeederRoleBlock>id("a63732030").owner(AbstractRolesToolbarTemplate.this));
			}

			public class Type extends io.intino.alexandria.ui.displays.components.SelectorComboBox<io.intino.alexandria.ui.displays.notifiers.SelectorComboBoxNotifier, B>  {

				public Type(B box) {
					super(box);
					label("Type");
					_multipleSelection(false);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Definition extends io.intino.alexandria.ui.displays.components.SelectorComboBox<io.intino.alexandria.ui.displays.notifiers.SelectorComboBoxNotifier, B>  {

				public Definition(B box) {
					super(box);
					label("Class");
					_multipleSelection(false);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Rol_67_3_11053800386 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386. Rol_68_4_01829324727 rol_68_4_01829324727;
				public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386. Rol_69_4_12027464911 rol_69_4_12027464911;

				public Rol_67_3_11053800386(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (rol_68_4_01829324727 == null) rol_68_4_01829324727 = register(new Rol_68_4_01829324727(box()).<Rol_68_4_01829324727>id("a_148299243").owner(AbstractRolesToolbarTemplate.this));
					if (rol_69_4_12027464911 == null) rol_69_4_12027464911 = register(new Rol_69_4_12027464911(box()).<Rol_69_4_12027464911>id("a_802160724").owner(AbstractRolesToolbarTemplate.this));
				}

				public class Rol_68_4_01829324727 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386.Rol_68_4_01829324727. BeginDate beginDate;

					public Rol_68_4_01829324727(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (beginDate == null) beginDate = register(new BeginDate(box()).<BeginDate>id("a508829073").owner(AbstractRolesToolbarTemplate.this));
					}

					public class BeginDate extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

						public BeginDate(B box) {
							super(box);
							label("Start date");
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}

				public class Rol_69_4_12027464911 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public RolesToolbarTemplate.AddRoleDialog.Content.Rol_67_3_11053800386.Rol_69_4_12027464911. EndDate endDate;

					public Rol_69_4_12027464911(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (endDate == null) endDate = register(new EndDate(box()).<EndDate>id("a1057297924").owner(AbstractRolesToolbarTemplate.this));
					}

					public class EndDate extends io.intino.alexandria.ui.displays.components.DateEditable<io.intino.alexandria.ui.displays.notifiers.DateEditableNotifier, B>  {

						public EndDate(B box) {
							super(box);
							label("End date");
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}
			}

			public class UserRoleBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
				public RolesToolbarTemplate.AddRoleDialog.Content.UserRoleBlock. Rol_72_4_0553596432 rol_72_4_0553596432;
				public RolesToolbarTemplate.AddRoleDialog.Content.UserRoleBlock. AddRoleUserTable addRoleUserTable;

				public UserRoleBlock(B box) {
					super(box);
				}

				@Override
				public void initConditional() {
					super.init();
					if (rol_72_4_0553596432 == null) rol_72_4_0553596432 = register(new Rol_72_4_0553596432(box()).<Rol_72_4_0553596432>id("a728276930").owner(AbstractRolesToolbarTemplate.this));
					if (addRoleUserTable == null) addRoleUserTable = register(new AddRoleUserTable(box()).<AddRoleUserTable>id("a_633276115").owner(AbstractRolesToolbarTemplate.this));
					if (rol_72_4_0553596432 == null) rol_72_4_0553596432 = addRoleDialog.content.userRoleBlock.rol_72_4_0553596432;
					if (rol_72_4_0553596432 != null) rol_72_4_0553596432.bindTo(addRoleUserTable);
					if (addRoleUserTable == null) addRoleUserTable = addRoleDialog.content.userRoleBlock.addRoleUserTable;
				}

				public class Rol_72_4_0553596432 extends io.intino.alexandria.ui.displays.components.SearchBox<io.intino.alexandria.ui.displays.notifiers.SearchBoxNotifier, B>  {

					public Rol_72_4_0553596432(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class AddRoleUserTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.User> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

					public AddRoleUserTable(B box) {
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

					public AddRoleUserTableRow create(org.monet.space.kernel.model.User item) {
						AddRoleUserTableRow row = new AddRoleUserTableRow((UnitBox)box());
						row.id(java.util.UUID.randomUUID().toString());
						row.item(item);
						return row;
					}
					public class AddRoleUserTableFullnameHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
						public RolesToolbarTemplate.AddRoleDialog.Content.UserRoleBlock.AddRoleUserTable.AddRoleUserTableFullnameHeading. Rol_76_48_01234296205 rol_76_48_01234296205;

						public AddRoleUserTableFullnameHeading(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (rol_76_48_01234296205 == null) rol_76_48_01234296205 = register(new Rol_76_48_01234296205(box()).<Rol_76_48_01234296205>id("a364857027").owner(AbstractRolesToolbarTemplate.this));
						}

						public class Rol_76_48_01234296205 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Rol_76_48_01234296205(B box) {
								super(box);
								_value("Fullname");
							}

							@Override
							public void init() {
								super.init();
							}
						}
					}

					public class AddRoleUserTableEmailHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
						public RolesToolbarTemplate.AddRoleDialog.Content.UserRoleBlock.AddRoleUserTable.AddRoleUserTableEmailHeading. Rol_79_45_0521747745 rol_79_45_0521747745;

						public AddRoleUserTableEmailHeading(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (rol_79_45_0521747745 == null) rol_79_45_0521747745 = register(new Rol_79_45_0521747745(box()).<Rol_79_45_0521747745>id("a608804218").owner(AbstractRolesToolbarTemplate.this));
						}

						public class Rol_79_45_0521747745 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Rol_79_45_0521747745(B box) {
								super(box);
								_value("Email");
							}

							@Override
							public void init() {
								super.init();
							}
						}
					}
				}
			}

			public class ServiceRoleBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
				public RolesToolbarTemplate.AddRoleDialog.Content.ServiceRoleBlock. Rol_83_4_01782256806 rol_83_4_01782256806;
				public RolesToolbarTemplate.AddRoleDialog.Content.ServiceRoleBlock. AddRoleServiceTable addRoleServiceTable;

				public ServiceRoleBlock(B box) {
					super(box);
				}

				@Override
				public void initConditional() {
					super.init();
					if (rol_83_4_01782256806 == null) rol_83_4_01782256806 = register(new Rol_83_4_01782256806(box()).<Rol_83_4_01782256806>id("a891760043").owner(AbstractRolesToolbarTemplate.this));
					if (addRoleServiceTable == null) addRoleServiceTable = register(new AddRoleServiceTable(box()).<AddRoleServiceTable>id("a_278905759").owner(AbstractRolesToolbarTemplate.this));
					if (rol_83_4_01782256806 == null) rol_83_4_01782256806 = addRoleDialog.content.serviceRoleBlock.rol_83_4_01782256806;
					if (rol_83_4_01782256806 != null) rol_83_4_01782256806.bindTo(addRoleServiceTable);
					if (addRoleServiceTable == null) addRoleServiceTable = addRoleDialog.content.serviceRoleBlock.addRoleServiceTable;
				}

				public class Rol_83_4_01782256806 extends io.intino.alexandria.ui.displays.components.SearchBox<io.intino.alexandria.ui.displays.notifiers.SearchBoxNotifier, B>  {

					public Rol_83_4_01782256806(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class AddRoleServiceTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.FederationUnitService> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

					public AddRoleServiceTable(B box) {
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

					public AddRoleServiceTableRow create(org.monet.space.kernel.model.FederationUnitService item) {
						AddRoleServiceTableRow row = new AddRoleServiceTableRow((UnitBox)box());
						row.id(java.util.UUID.randomUUID().toString());
						row.item(item);
						return row;
					}
					public class AddRoleServiceTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
						public RolesToolbarTemplate.AddRoleDialog.Content.ServiceRoleBlock.AddRoleServiceTable.AddRoleServiceTableLabelHeading. Rol_87_48_0649427772 rol_87_48_0649427772;

						public AddRoleServiceTableLabelHeading(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (rol_87_48_0649427772 == null) rol_87_48_0649427772 = register(new Rol_87_48_0649427772(box()).<Rol_87_48_0649427772>id("a_499330695").owner(AbstractRolesToolbarTemplate.this));
						}

						public class Rol_87_48_0649427772 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Rol_87_48_0649427772(B box) {
								super(box);
								_value("Name");
							}

							@Override
							public void init() {
								super.init();
							}
						}
					}

					public class AddRoleServiceTablePartnerHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
						public RolesToolbarTemplate.AddRoleDialog.Content.ServiceRoleBlock.AddRoleServiceTable.AddRoleServiceTablePartnerHeading. Rol_90_50_01316169397 rol_90_50_01316169397;

						public AddRoleServiceTablePartnerHeading(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (rol_90_50_01316169397 == null) rol_90_50_01316169397 = register(new Rol_90_50_01316169397(box()).<Rol_90_50_01316169397>id("a_559951635").owner(AbstractRolesToolbarTemplate.this));
						}

						public class Rol_90_50_01316169397 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Rol_90_50_01316169397(B box) {
								super(box);
								_value("Partner");
							}

							@Override
							public void init() {
								super.init();
							}
						}
					}
				}
			}

			public class FeederRoleBlock extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
				public RolesToolbarTemplate.AddRoleDialog.Content.FeederRoleBlock. Rol_94_4_02065703568 rol_94_4_02065703568;
				public RolesToolbarTemplate.AddRoleDialog.Content.FeederRoleBlock. AddRoleFeederTable addRoleFeederTable;

				public FeederRoleBlock(B box) {
					super(box);
				}

				@Override
				public void initConditional() {
					super.init();
					if (rol_94_4_02065703568 == null) rol_94_4_02065703568 = register(new Rol_94_4_02065703568(box()).<Rol_94_4_02065703568>id("a2118691340").owner(AbstractRolesToolbarTemplate.this));
					if (addRoleFeederTable == null) addRoleFeederTable = register(new AddRoleFeederTable(box()).<AddRoleFeederTable>id("a629248813").owner(AbstractRolesToolbarTemplate.this));
					if (rol_94_4_02065703568 == null) rol_94_4_02065703568 = addRoleDialog.content.feederRoleBlock.rol_94_4_02065703568;
					if (rol_94_4_02065703568 != null) rol_94_4_02065703568.bindTo(addRoleFeederTable);
					if (addRoleFeederTable == null) addRoleFeederTable = addRoleDialog.content.feederRoleBlock.addRoleFeederTable;
				}

				public class Rol_94_4_02065703568 extends io.intino.alexandria.ui.displays.components.SearchBox<io.intino.alexandria.ui.displays.notifiers.SearchBoxNotifier, B>  {

					public Rol_94_4_02065703568(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class AddRoleFeederTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.FederationUnitFeeder> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

					public AddRoleFeederTable(B box) {
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

					public AddRoleFeederTableRow create(org.monet.space.kernel.model.FederationUnitFeeder item) {
						AddRoleFeederTableRow row = new AddRoleFeederTableRow((UnitBox)box());
						row.id(java.util.UUID.randomUUID().toString());
						row.item(item);
						return row;
					}
					public class AddRoleFeederTableLabelHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
						public RolesToolbarTemplate.AddRoleDialog.Content.FeederRoleBlock.AddRoleFeederTable.AddRoleFeederTableLabelHeading. Rol_98_47_0649427772 rol_98_47_0649427772;

						public AddRoleFeederTableLabelHeading(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (rol_98_47_0649427772 == null) rol_98_47_0649427772 = register(new Rol_98_47_0649427772(box()).<Rol_98_47_0649427772>id("a482658956").owner(AbstractRolesToolbarTemplate.this));
						}

						public class Rol_98_47_0649427772 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Rol_98_47_0649427772(B box) {
								super(box);
								_value("Name");
							}

							@Override
							public void init() {
								super.init();
							}
						}
					}

					public class AddRoleFeederTablePartnerHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
						public RolesToolbarTemplate.AddRoleDialog.Content.FeederRoleBlock.AddRoleFeederTable.AddRoleFeederTablePartnerHeading. Rol_101_49_01316169397 rol_101_49_01316169397;

						public AddRoleFeederTablePartnerHeading(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (rol_101_49_01316169397 == null) rol_101_49_01316169397 = register(new Rol_101_49_01316169397(box()).<Rol_101_49_01316169397>id("a1091305302").owner(AbstractRolesToolbarTemplate.this));
						}

						public class Rol_101_49_01316169397 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Rol_101_49_01316169397(B box) {
								super(box);
								_value("Partner");
							}

							@Override
							public void init() {
								super.init();
							}
						}
					}
				}
			}
		}

		public class Rol_103_2_1955995399 extends io.intino.alexandria.ui.displays.components.Divider<io.intino.alexandria.ui.displays.notifiers.DividerNotifier, B>  {

			public Rol_103_2_1955995399(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Rol_104_2_01773733018 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RolesToolbarTemplate.AddRoleDialog.Rol_104_2_01773733018. Cancel cancel;
			public RolesToolbarTemplate.AddRoleDialog.Rol_104_2_01773733018. Accept accept;

			public Rol_104_2_01773733018(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (cancel == null) cancel = register(new Cancel(box()).<Cancel>id("a685013139").owner(AbstractRolesToolbarTemplate.this));
				if (accept == null) accept = register(new Accept(box()).<Accept>id("a629276449").owner(AbstractRolesToolbarTemplate.this));
			}

			public class Cancel extends io.intino.alexandria.ui.displays.components.CloseDialog<io.intino.alexandria.ui.displays.notifiers.CloseDialogNotifier, B>  {

				public Cancel(B box) {
					super(box);
					_title("Cancel");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Accept extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Accept(B box) {
					super(box);
					_title("OK");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}
}