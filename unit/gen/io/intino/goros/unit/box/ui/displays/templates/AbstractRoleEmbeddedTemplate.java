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

public abstract class AbstractRoleEmbeddedTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Rol_117_1_1835630170 rol_117_1_1835630170;
	public RoleEmbeddedTemplate.Rol_117_1_1835630170. Rol_118_2_01498652406 rol_118_2_01498652406;
	public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_118_2_01498652406. Edit edit;
	public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_118_2_01498652406. Revoke revoke;
	public RoleEmbeddedTemplate.Rol_117_1_1835630170. Rol_121_2_11838180553 rol_121_2_11838180553;
	public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_121_2_11838180553. Previous previous;
	public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_121_2_11838180553. Next next;
	public Rol_125_1_1588508171 rol_125_1_1588508171;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171. Rol_126_2_12082579240 rol_126_2_12082579240;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_126_2_12082579240. User user;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_126_2_12082579240. State state;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171. Message message;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171. Rol_130_2_1911839303 rol_130_2_1911839303;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. Definition definition;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. Type type;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. Nature nature;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. StartDate startDate;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171. Rol_135_2_0996243325 rol_135_2_0996243325;
	public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_135_2_0996243325. EndDate endDate;

    public AbstractRoleEmbeddedTemplate(B box) {
        super(box);
        id("roleEmbeddedTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (rol_117_1_1835630170 == null) rol_117_1_1835630170 = register(new Rol_117_1_1835630170(box()).<Rol_117_1_1835630170>id("a1784351532").owner(AbstractRoleEmbeddedTemplate.this));
		if (rol_117_1_1835630170 != null) rol_118_2_01498652406 = rol_117_1_1835630170.rol_118_2_01498652406;
		if (rol_118_2_01498652406 != null) edit = rol_117_1_1835630170.rol_118_2_01498652406.edit;
		if (rol_118_2_01498652406 != null) revoke = rol_117_1_1835630170.rol_118_2_01498652406.revoke;
		if (rol_117_1_1835630170 != null) rol_121_2_11838180553 = rol_117_1_1835630170.rol_121_2_11838180553;
		if (rol_121_2_11838180553 != null) previous = rol_117_1_1835630170.rol_121_2_11838180553.previous;
		if (rol_121_2_11838180553 != null) next = rol_117_1_1835630170.rol_121_2_11838180553.next;
		if (rol_125_1_1588508171 == null) rol_125_1_1588508171 = register(new Rol_125_1_1588508171(box()).<Rol_125_1_1588508171>id("a_404051167").owner(AbstractRoleEmbeddedTemplate.this));
		if (rol_125_1_1588508171 != null) rol_126_2_12082579240 = rol_125_1_1588508171.rol_126_2_12082579240;
		if (rol_126_2_12082579240 != null) user = rol_125_1_1588508171.rol_126_2_12082579240.user;
		if (rol_126_2_12082579240 != null) state = rol_125_1_1588508171.rol_126_2_12082579240.state;
		if (rol_125_1_1588508171 != null) message = rol_125_1_1588508171.message;
		if (rol_125_1_1588508171 != null) rol_130_2_1911839303 = rol_125_1_1588508171.rol_130_2_1911839303;
		if (rol_130_2_1911839303 != null) definition = rol_125_1_1588508171.rol_130_2_1911839303.definition;
		if (rol_130_2_1911839303 != null) type = rol_125_1_1588508171.rol_130_2_1911839303.type;
		if (rol_130_2_1911839303 != null) nature = rol_125_1_1588508171.rol_130_2_1911839303.nature;
		if (rol_130_2_1911839303 != null) startDate = rol_125_1_1588508171.rol_130_2_1911839303.startDate;
		if (rol_125_1_1588508171 != null) rol_135_2_0996243325 = rol_125_1_1588508171.rol_135_2_0996243325;
		if (rol_135_2_0996243325 != null) endDate = rol_125_1_1588508171.rol_135_2_0996243325.endDate;
	}

	public class Rol_117_1_1835630170 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public RoleEmbeddedTemplate.Rol_117_1_1835630170. Rol_118_2_01498652406 rol_118_2_01498652406;
		public RoleEmbeddedTemplate.Rol_117_1_1835630170. Rol_121_2_11838180553 rol_121_2_11838180553;

		public Rol_117_1_1835630170(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (rol_118_2_01498652406 == null) rol_118_2_01498652406 = register(new Rol_118_2_01498652406(box()).<Rol_118_2_01498652406>id("a_502556931").owner(AbstractRoleEmbeddedTemplate.this));
			if (rol_121_2_11838180553 == null) rol_121_2_11838180553 = register(new Rol_121_2_11838180553(box()).<Rol_121_2_11838180553>id("a_1125247581").owner(AbstractRoleEmbeddedTemplate.this));
		}

		public class Rol_118_2_01498652406 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_118_2_01498652406. Edit edit;
			public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_118_2_01498652406. Revoke revoke;

			public Rol_118_2_01498652406(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (edit == null) edit = register(new Edit(box()).<Edit>id("a677416160").owner(AbstractRoleEmbeddedTemplate.this));
				if (revoke == null) revoke = register(new Revoke(box()).<Revoke>id("a_1464610852").owner(AbstractRoleEmbeddedTemplate.this));
			}

			public class Edit extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Edit(B box) {
					super(box);
					_title("Editar");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Revoke extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Revoke(B box) {
					super(box);
					_title("Revocar");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class Rol_121_2_11838180553 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_121_2_11838180553. Previous previous;
			public RoleEmbeddedTemplate.Rol_117_1_1835630170.Rol_121_2_11838180553. Next next;

			public Rol_121_2_11838180553(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (previous == null) previous = register(new Previous(box()).<Previous>id("a_957022283").owner(AbstractRoleEmbeddedTemplate.this));
				if (next == null) next = register(new Next(box()).<Next>id("a_444539215").owner(AbstractRoleEmbeddedTemplate.this));
			}

			public class Previous extends io.intino.alexandria.ui.displays.components.SelectPreviousItem<io.intino.alexandria.ui.displays.notifiers.SelectPreviousItemNotifier, B>  {

				public Previous(B box) {
					super(box);
					_title("Anterior");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
					_icon("KeyboardArrowLeft");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Next extends io.intino.alexandria.ui.displays.components.SelectNextItem<io.intino.alexandria.ui.displays.notifiers.SelectNextItemNotifier, B>  {

				public Next(B box) {
					super(box);
					_title("Siguiente");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
					_icon("KeyboardArrowRight");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class Rol_125_1_1588508171 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public RoleEmbeddedTemplate.Rol_125_1_1588508171. Rol_126_2_12082579240 rol_126_2_12082579240;
		public RoleEmbeddedTemplate.Rol_125_1_1588508171. Message message;
		public RoleEmbeddedTemplate.Rol_125_1_1588508171. Rol_130_2_1911839303 rol_130_2_1911839303;
		public RoleEmbeddedTemplate.Rol_125_1_1588508171. Rol_135_2_0996243325 rol_135_2_0996243325;

		public Rol_125_1_1588508171(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (rol_126_2_12082579240 == null) rol_126_2_12082579240 = register(new Rol_126_2_12082579240(box()).<Rol_126_2_12082579240>id("a_1700811042").owner(AbstractRoleEmbeddedTemplate.this));
			if (message == null) message = register(new Message(box()).<Message>id("a433948556").owner(AbstractRoleEmbeddedTemplate.this));
			if (rol_130_2_1911839303 == null) rol_130_2_1911839303 = register(new Rol_130_2_1911839303(box()).<Rol_130_2_1911839303>id("a280478185").owner(AbstractRoleEmbeddedTemplate.this));
			if (rol_135_2_0996243325 == null) rol_135_2_0996243325 = register(new Rol_135_2_0996243325(box()).<Rol_135_2_0996243325>id("a_1021699601").owner(AbstractRoleEmbeddedTemplate.this));
		}

		public class Rol_126_2_12082579240 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_126_2_12082579240. User user;
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_126_2_12082579240. State state;

			public Rol_126_2_12082579240(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (user == null) user = register(new User(box()).<User>id("a_320200732").owner(AbstractRoleEmbeddedTemplate.this));
				if (state == null) state = register(new State(box()).<State>id("a_1338109032").owner(AbstractRoleEmbeddedTemplate.this));
			}

			public class User extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public User(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class State extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public State(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
				public State textColor(String color) {
				    this._textColor(color);
				    this._refreshHighlight();
				    return this;
				}

				public State backgroundColor(String color) {
				    this._backgroundColor(color);
				    this._refreshHighlight();
				    return this;
				}
			}
		}

		public class Message extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Message(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Rol_130_2_1911839303 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. Definition definition;
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. Type type;
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. Nature nature;
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_130_2_1911839303. StartDate startDate;

			public Rol_130_2_1911839303(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (definition == null) definition = register(new Definition(box()).<Definition>id("a455729971").owner(AbstractRoleEmbeddedTemplate.this));
				if (type == null) type = register(new Type(box()).<Type>id("a300360986").owner(AbstractRoleEmbeddedTemplate.this));
				if (nature == null) nature = register(new Nature(box()).<Nature>id("a690297479").owner(AbstractRoleEmbeddedTemplate.this));
				if (startDate == null) startDate = register(new StartDate(box()).<StartDate>id("a_1112523440").owner(AbstractRoleEmbeddedTemplate.this));
			}

			public class Definition extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Definition(B box) {
					super(box);
					label("Class");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Type extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Type(B box) {
					super(box);
					label("Type");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Nature extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Nature(B box) {
					super(box);
					label("Nature");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class StartDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, B>  {

				public StartDate(B box) {
					super(box);
					label("Start date");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class Rol_135_2_0996243325 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public RoleEmbeddedTemplate.Rol_125_1_1588508171.Rol_135_2_0996243325. EndDate endDate;

			public Rol_135_2_0996243325(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (endDate == null) endDate = register(new EndDate(box()).<EndDate>id("a487891726").owner(AbstractRoleEmbeddedTemplate.this));
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
}