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

public class SourceLevelListItem extends io.intino.alexandria.ui.displays.components.Item<ItemNotifier, org.monet.space.kernel.model.Term, UnitBox> {
	public Sou_32_4_01316497317 sou_32_4_01316497317;
	public SourceLevelListItem.Sou_32_4_01316497317. Sou_33_5_01546744121 sou_33_5_01546744121;
	public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121. Sou_34_6_01699575602 sou_34_6_01699575602;
	public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121.Sou_34_6_01699575602. Type type;
	public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121.Sou_34_6_01699575602. Label label;
	public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121. Code code;
	public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121. TagsCount tagsCount;
	public SourceLevelListItem.Sou_32_4_01316497317. Sou_39_5_0855064589 sou_39_5_0855064589;
	public SourceLevelListItem.Sou_32_4_01316497317.Sou_39_5_0855064589. GroupFlag groupFlag;

    public SourceLevelListItem(UnitBox box) {
        super(box);
        id("a522535855");
    }

    @Override
	public void init() {
		super.init();
		if (sou_32_4_01316497317 == null) sou_32_4_01316497317 = register(new Sou_32_4_01316497317(box()).<Sou_32_4_01316497317>id("a356551625").owner(SourceLevelListItem.this));
		if (sou_32_4_01316497317 != null) sou_33_5_01546744121 = sou_32_4_01316497317.sou_33_5_01546744121;
		if (sou_33_5_01546744121 != null) sou_34_6_01699575602 = sou_32_4_01316497317.sou_33_5_01546744121.sou_34_6_01699575602;
		if (sou_34_6_01699575602 != null) type = sou_32_4_01316497317.sou_33_5_01546744121.sou_34_6_01699575602.type;
		if (sou_34_6_01699575602 != null) label = sou_32_4_01316497317.sou_33_5_01546744121.sou_34_6_01699575602.label;
		if (sou_33_5_01546744121 != null) code = sou_32_4_01316497317.sou_33_5_01546744121.code;
		if (sou_33_5_01546744121 != null) tagsCount = sou_32_4_01316497317.sou_33_5_01546744121.tagsCount;
		if (sou_32_4_01316497317 != null) sou_39_5_0855064589 = sou_32_4_01316497317.sou_39_5_0855064589;
		if (sou_39_5_0855064589 != null) groupFlag = sou_32_4_01316497317.sou_39_5_0855064589.groupFlag;
	}

	public class Sou_32_4_01316497317 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
		public SourceLevelListItem.Sou_32_4_01316497317. Sou_33_5_01546744121 sou_33_5_01546744121;
		public SourceLevelListItem.Sou_32_4_01316497317. Sou_39_5_0855064589 sou_39_5_0855064589;

		public Sou_32_4_01316497317(UnitBox box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (sou_33_5_01546744121 == null) sou_33_5_01546744121 = register(new Sou_33_5_01546744121(box()).<Sou_33_5_01546744121>id("a1466757235").owner(SourceLevelListItem.this));
			if (sou_39_5_0855064589 == null) sou_39_5_0855064589 = register(new Sou_39_5_0855064589(box()).<Sou_39_5_0855064589>id("a178247398").owner(SourceLevelListItem.this));
		}

		public class Sou_33_5_01546744121 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
			public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121. Sou_34_6_01699575602 sou_34_6_01699575602;
			public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121. Code code;
			public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121. TagsCount tagsCount;

			public Sou_33_5_01546744121(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (sou_34_6_01699575602 == null) sou_34_6_01699575602 = register(new Sou_34_6_01699575602(box()).<Sou_34_6_01699575602>id("a1500563454").owner(SourceLevelListItem.this));
				if (code == null) code = register(new Code(box()).<Code>id("a622513010").owner(SourceLevelListItem.this));
				if (tagsCount == null) tagsCount = register(new TagsCount(box()).<TagsCount>id("a170549777").owner(SourceLevelListItem.this));
			}

			public class Sou_34_6_01699575602 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
				public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121.Sou_34_6_01699575602. Type type;
				public SourceLevelListItem.Sou_32_4_01316497317.Sou_33_5_01546744121.Sou_34_6_01699575602. Label label;

				public Sou_34_6_01699575602(UnitBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (type == null) type = register(new Type(box()).<Type>id("a_1900498371").owner(SourceLevelListItem.this));
					if (label == null) label = register(new Label(box()).<Label>id("a1205976145").owner(SourceLevelListItem.this));
				}

				public class Type extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

					public Type(UnitBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
					}
					public Type textColor(String color) {
					    this._textColor(color);
					    this._refreshHighlight();
					    return this;
					}

					public Type backgroundColor(String color) {
					    this._backgroundColor(color);
					    this._refreshHighlight();
					    return this;
					}
				}

				public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

					public Label(UnitBox box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class Code extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, UnitBox>  {

				public Code(UnitBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class TagsCount extends io.intino.alexandria.ui.displays.components.Number<io.intino.alexandria.ui.displays.notifiers.NumberNotifier, UnitBox>  {

				public TagsCount(UnitBox box) {
					super(box);
					label("Tags count");
					_value(0.0);
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class Sou_39_5_0855064589 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, UnitBox>  {
			public SourceLevelListItem.Sou_32_4_01316497317.Sou_39_5_0855064589. GroupFlag groupFlag;

			public Sou_39_5_0855064589(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (groupFlag == null) groupFlag = register(new GroupFlag(box()).<GroupFlag>id("a_1397110996").owner(SourceLevelListItem.this));
			}

			public class GroupFlag extends io.intino.alexandria.ui.displays.components.MaterialIcon<io.intino.alexandria.ui.displays.notifiers.MaterialIconNotifier, UnitBox>  {

				public GroupFlag(UnitBox box) {
					super(box);
					_icon("KeyboardArrowRight");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}
}