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

public class TasksListItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Task, UnitBox> {
	public Tas_42_4_11435015453 tas_42_4_11435015453;
	public TasksListItem.Tas_42_4_11435015453. Tas_43_5_1314567556 tas_43_5_1314567556;
	public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556. Tas_44_6_11536208049 tas_44_6_11536208049;
	public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556.Tas_44_6_11536208049. Label label;
	public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556.Tas_44_6_11536208049. State state;
	public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556. Tas_47_6_11340477231 tas_47_6_11340477231;
	public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556.Tas_47_6_11340477231. Urgent urgent;
	public TasksListItem.Tas_42_4_11435015453. Description description;
	public TasksListItem.Tas_42_4_11435015453. Owner owner;
	public TasksListItem.Tas_42_4_11435015453. CountMessages countMessages;
	public TasksListItem.Tas_42_4_11435015453. Tas_52_5_1235458246 tas_52_5_1235458246;
	public TasksListItem.Tas_42_4_11435015453.Tas_52_5_1235458246. CreateDate createDate;
	public TasksListItem.Tas_42_4_11435015453.Tas_52_5_1235458246. UpdateDate updateDate;

    public TasksListItem(UnitBox box) {
        super(box);
        id("a_370671136");
    }

    @Override
	public void init() {
		super.init();
		if (tas_42_4_11435015453 == null) tas_42_4_11435015453 = register(new Tas_42_4_11435015453(box()).<Tas_42_4_11435015453>id("a_1252517152").owner(TasksListItem.this));
		if (tas_42_4_11435015453 != null) tas_43_5_1314567556 = tas_42_4_11435015453.tas_43_5_1314567556;
		if (tas_43_5_1314567556 != null) tas_44_6_11536208049 = tas_42_4_11435015453.tas_43_5_1314567556.tas_44_6_11536208049;
		if (tas_44_6_11536208049 != null) label = tas_42_4_11435015453.tas_43_5_1314567556.tas_44_6_11536208049.label;
		if (tas_44_6_11536208049 != null) state = tas_42_4_11435015453.tas_43_5_1314567556.tas_44_6_11536208049.state;
		if (tas_43_5_1314567556 != null) tas_47_6_11340477231 = tas_42_4_11435015453.tas_43_5_1314567556.tas_47_6_11340477231;
		if (tas_47_6_11340477231 != null) urgent = tas_42_4_11435015453.tas_43_5_1314567556.tas_47_6_11340477231.urgent;
		if (tas_42_4_11435015453 != null) description = tas_42_4_11435015453.description;
		if (tas_42_4_11435015453 != null) owner = tas_42_4_11435015453.owner;
		if (tas_42_4_11435015453 != null) countMessages = tas_42_4_11435015453.countMessages;
		if (tas_42_4_11435015453 != null) tas_52_5_1235458246 = tas_42_4_11435015453.tas_52_5_1235458246;
		if (tas_52_5_1235458246 != null) createDate = tas_42_4_11435015453.tas_52_5_1235458246.createDate;
		if (tas_52_5_1235458246 != null) updateDate = tas_42_4_11435015453.tas_52_5_1235458246.updateDate;
	}

	public class Tas_42_4_11435015453 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public TasksListItem.Tas_42_4_11435015453. Tas_43_5_1314567556 tas_43_5_1314567556;
		public TasksListItem.Tas_42_4_11435015453. Description description;
		public TasksListItem.Tas_42_4_11435015453. Owner owner;
		public TasksListItem.Tas_42_4_11435015453. CountMessages countMessages;
		public TasksListItem.Tas_42_4_11435015453. Tas_52_5_1235458246 tas_52_5_1235458246;

		public Tas_42_4_11435015453(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tas_43_5_1314567556 == null) tas_43_5_1314567556 = register(new Tas_43_5_1314567556(box()).<Tas_43_5_1314567556>id("a_2046327365").owner(TasksListItem.this));
			if (description == null) description = register(new Description(box()).<Description>id("a1088108833").owner(TasksListItem.this));
			if (owner == null) owner = register(new Owner(box()).<Owner>id("a1964877720").owner(TasksListItem.this));
			if (countMessages == null) countMessages = register(new CountMessages(box()).<CountMessages>id("a52770656").owner(TasksListItem.this));
			if (tas_52_5_1235458246 == null) tas_52_5_1235458246 = register(new Tas_52_5_1235458246(box()).<Tas_52_5_1235458246>id("a1822868792").owner(TasksListItem.this));
		}

		public class Tas_43_5_1314567556 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
			public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556. Tas_44_6_11536208049 tas_44_6_11536208049;
			public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556. Tas_47_6_11340477231 tas_47_6_11340477231;

			public Tas_43_5_1314567556(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tas_44_6_11536208049 == null) tas_44_6_11536208049 = register(new Tas_44_6_11536208049(box()).<Tas_44_6_11536208049>id("a874387293").owner(TasksListItem.this));
				if (tas_47_6_11340477231 == null) tas_47_6_11340477231 = register(new Tas_47_6_11340477231(box()).<Tas_47_6_11340477231>id("a1198467640").owner(TasksListItem.this));
			}

			public class Tas_44_6_11536208049 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
				public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556.Tas_44_6_11536208049. Label label;
				public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556.Tas_44_6_11536208049. State state;

				public Tas_44_6_11536208049(UnitBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (label == null) label = register(new Label(box()).<Label>id("a121538653").owner(TasksListItem.this));
					if (state == null) state = register(new State(box()).<State>id("a128568826").owner(TasksListItem.this));
				}

				public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

					public Label(UnitBox box) {
						super(box);
						_value("Loading...");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class State extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

					public State(UnitBox box) {
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

			public class Tas_47_6_11340477231 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
				public TasksListItem.Tas_42_4_11435015453.Tas_43_5_1314567556.Tas_47_6_11340477231. Urgent urgent;

				public Tas_47_6_11340477231(UnitBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (urgent == null) urgent = register(new Urgent(box()).<Urgent>id("a_843298219").owner(TasksListItem.this));
				}

				public class Urgent extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, UnitBox>  {

					public Urgent(UnitBox box) {
						super(box);
						_title("Marcar/Desmarcar como urgente");
						_color("#ddd");
						_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
						_icon("Alarm");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class Description extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

			public Description(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Owner extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

			public Owner(UnitBox box) {
				super(box);
				label("Responsable");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class CountMessages extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, UnitBox>  {

			public CountMessages(UnitBox box) {
				super(box);
				label("Número de mensajes");
				_value(0.0);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Tas_52_5_1235458246 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
			public TasksListItem.Tas_42_4_11435015453.Tas_52_5_1235458246. CreateDate createDate;
			public TasksListItem.Tas_42_4_11435015453.Tas_52_5_1235458246. UpdateDate updateDate;

			public Tas_52_5_1235458246(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (createDate == null) createDate = register(new CreateDate(box()).<CreateDate>id("a_921778011").owner(TasksListItem.this));
				if (updateDate == null) updateDate = register(new UpdateDate(box()).<UpdateDate>id("a1708044786").owner(TasksListItem.this));
			}

			public class CreateDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

				public CreateDate(UnitBox box) {
					super(box);
					label("Fecha creación");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class UpdateDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, UnitBox>  {

				public UpdateDate(UnitBox box) {
					super(box);
					label("Fecha actualización");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}
}