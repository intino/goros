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

public class RolesTableUserItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public Rol_38_4_0654073082 rol_38_4_0654073082;
	public RolesTableUserItem.Rol_38_4_0654073082. Rol_39_5_1696082854 rol_39_5_1696082854;
	public RolesTableUserItem.Rol_38_4_0654073082.Rol_39_5_1696082854. User user;
	public RolesTableUserItem.Rol_38_4_0654073082. Rol_40_5_11655847926 rol_40_5_11655847926;
	public RolesTableUserItem.Rol_38_4_0654073082.Rol_40_5_11655847926. State state;

    public RolesTableUserItem(UnitBox box) {
        super(box);
        id("a_1732349193");
    }

    @Override
	public void init() {
		super.init();
		if (rol_38_4_0654073082 == null) rol_38_4_0654073082 = register(new Rol_38_4_0654073082(box()).<Rol_38_4_0654073082>id("a_502491952").owner(RolesTableUserItem.this));
		if (rol_38_4_0654073082 != null) rol_39_5_1696082854 = rol_38_4_0654073082.rol_39_5_1696082854;
		if (rol_39_5_1696082854 != null) user = rol_38_4_0654073082.rol_39_5_1696082854.user;
		if (rol_38_4_0654073082 != null) rol_40_5_11655847926 = rol_38_4_0654073082.rol_40_5_11655847926;
		if (rol_40_5_11655847926 != null) state = rol_38_4_0654073082.rol_40_5_11655847926.state;
	}

	public class Rol_38_4_0654073082 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public RolesTableUserItem.Rol_38_4_0654073082. Rol_39_5_1696082854 rol_39_5_1696082854;
		public RolesTableUserItem.Rol_38_4_0654073082. Rol_40_5_11655847926 rol_40_5_11655847926;

		public Rol_38_4_0654073082(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (rol_39_5_1696082854 == null) rol_39_5_1696082854 = register(new Rol_39_5_1696082854(box()).<Rol_39_5_1696082854>id("a_651961985").owner(RolesTableUserItem.this));
			if (rol_40_5_11655847926 == null) rol_40_5_11655847926 = register(new Rol_40_5_11655847926(box()).<Rol_40_5_11655847926>id("a581941854").owner(RolesTableUserItem.this));
		}

		public class Rol_39_5_1696082854 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
			public RolesTableUserItem.Rol_38_4_0654073082.Rol_39_5_1696082854. User user;

			public Rol_39_5_1696082854(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (user == null) user = register(new User(box()).<User>id("a_1780199828").owner(RolesTableUserItem.this));
			}

			public class User extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

				public User(UnitBox box) {
					super(box);
					_value("Loading...");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class Rol_40_5_11655847926 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
			public RolesTableUserItem.Rol_38_4_0654073082.Rol_40_5_11655847926. State state;

			public Rol_40_5_11655847926(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (state == null) state = register(new State(box()).<State>id("a_462733274").owner(RolesTableUserItem.this));
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
	}
}