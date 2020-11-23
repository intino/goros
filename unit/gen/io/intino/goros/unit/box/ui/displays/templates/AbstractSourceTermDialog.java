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

public abstract class AbstractSourceTermDialog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public GeneralView generalView;
	public SourceTermDialog.GeneralView. Title title;
	public SourceTermDialog.GeneralView. Sou_59_2_1199179770 sou_59_2_1199179770;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Code code;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Label label;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Type type;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770.Type. TermType termType;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770.Type. CategoryType categoryType;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770. ContainOtherTerms containOtherTerms;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Sou_66_3_0822411189 sou_66_3_0822411189;
	public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Tags tags;
	public ChildrenView childrenView;
	public SourceTermDialog.ChildrenView. AddTitle addTitle;
	public SourceTermDialog.ChildrenView. Sou_70_2_1986763456 sou_70_2_1986763456;
	public SourceTermDialog.ChildrenView.Sou_70_2_1986763456. ChildCode childCode;
	public SourceTermDialog.ChildrenView.Sou_70_2_1986763456. ChildLabel childLabel;
	public SourceTermDialog.ChildrenView.Sou_70_2_1986763456. Sou_73_3_11870066214 sou_73_3_11870066214;
	public SourceTermDialog.ChildrenView.Sou_70_2_1986763456.Sou_73_3_11870066214. Add add;

    public AbstractSourceTermDialog(B box) {
        super(box);
        id("sourceTermDialog");
    }

    @Override
	public void init() {
		super.init();
		if (generalView == null) generalView = register(new GeneralView(box()).<GeneralView>id("a1123941020").owner(AbstractSourceTermDialog.this));
		if (generalView != null) title = generalView.title;
		if (generalView != null) sou_59_2_1199179770 = generalView.sou_59_2_1199179770;
		if (sou_59_2_1199179770 != null) code = generalView.sou_59_2_1199179770.code;
		if (sou_59_2_1199179770 != null) label = generalView.sou_59_2_1199179770.label;
		if (sou_59_2_1199179770 != null) type = generalView.sou_59_2_1199179770.type;
		if (type != null) termType = generalView.sou_59_2_1199179770.type.termType;
		if (type != null) categoryType = generalView.sou_59_2_1199179770.type.categoryType;
		if (sou_59_2_1199179770 != null) containOtherTerms = generalView.sou_59_2_1199179770.containOtherTerms;
		if (sou_59_2_1199179770 != null) sou_66_3_0822411189 = generalView.sou_59_2_1199179770.sou_66_3_0822411189;
		if (sou_59_2_1199179770 != null) tags = generalView.sou_59_2_1199179770.tags;
		if (childrenView == null) childrenView = register(new ChildrenView(box()).<ChildrenView>id("a_815145931").owner(AbstractSourceTermDialog.this));
		if (childrenView != null) addTitle = childrenView.addTitle;
		if (childrenView != null) sou_70_2_1986763456 = childrenView.sou_70_2_1986763456;
		if (sou_70_2_1986763456 != null) childCode = childrenView.sou_70_2_1986763456.childCode;
		if (sou_70_2_1986763456 != null) childLabel = childrenView.sou_70_2_1986763456.childLabel;
		if (sou_70_2_1986763456 != null) sou_73_3_11870066214 = childrenView.sou_70_2_1986763456.sou_73_3_11870066214;
		if (sou_73_3_11870066214 != null) add = childrenView.sou_70_2_1986763456.sou_73_3_11870066214.add;
	}

	public class GeneralView extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceTermDialog.GeneralView. Title title;
		public SourceTermDialog.GeneralView. Sou_59_2_1199179770 sou_59_2_1199179770;

		public GeneralView(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (title == null) title = register(new Title(box()).<Title>id("a202840821").owner(AbstractSourceTermDialog.this));
			if (sou_59_2_1199179770 == null) sou_59_2_1199179770 = register(new Sou_59_2_1199179770(box()).<Sou_59_2_1199179770>id("a_1587795460").owner(AbstractSourceTermDialog.this));
		}

		public class Title extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Title(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Sou_59_2_1199179770 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Code code;
			public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Label label;
			public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Type type;
			public SourceTermDialog.GeneralView.Sou_59_2_1199179770. ContainOtherTerms containOtherTerms;
			public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Sou_66_3_0822411189 sou_66_3_0822411189;
			public SourceTermDialog.GeneralView.Sou_59_2_1199179770. Tags tags;

			public Sou_59_2_1199179770(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (code == null) code = register(new Code(box()).<Code>id("a_1211355951").owner(AbstractSourceTermDialog.this));
				if (label == null) label = register(new Label(box()).<Label>id("a1110563984").owner(AbstractSourceTermDialog.this));
				if (type == null) type = register(new Type(box()).<Type>id("a_1210839522").owner(AbstractSourceTermDialog.this));
				if (containOtherTerms == null) containOtherTerms = register(new ContainOtherTerms(box()).<ContainOtherTerms>id("a_2078760985").owner(AbstractSourceTermDialog.this));
				if (sou_66_3_0822411189 == null) sou_66_3_0822411189 = register(new Sou_66_3_0822411189(box()).<Sou_66_3_0822411189>id("a2039945735").owner(AbstractSourceTermDialog.this));
				if (tags == null) tags = register(new Tags((UnitBox)box()).<Tags>id("a_1210862851").owner(AbstractSourceTermDialog.this));
			}

			public class Code extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

				public Code(B box) {
					super(box);
					label("Code");

					_readonly(true);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Label extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

				public Label(B box) {
					super(box);
					label("Label");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Type extends io.intino.alexandria.ui.displays.components.SelectorComboBox<io.intino.alexandria.ui.displays.notifiers.SelectorComboBoxNotifier, B>  {
				public SourceTermDialog.GeneralView.Sou_59_2_1199179770.Type. TermType termType;
				public SourceTermDialog.GeneralView.Sou_59_2_1199179770.Type. CategoryType categoryType;

				public Type(B box) {
					super(box);
					label("Type");
					_multipleSelection(false);
				}

				@Override
				public void init() {
					super.init();
					if (termType == null) termType = register(new TermType(box()).<TermType>id("a980047559").owner(AbstractSourceTermDialog.this));
					if (categoryType == null) categoryType = register(new CategoryType(box()).<CategoryType>id("a_709374503").owner(AbstractSourceTermDialog.this));
				}

				public class TermType extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

					public TermType(B box) {
						super(box);

						name("termType");
						_value("Term");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class CategoryType extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

					public CategoryType(B box) {
						super(box);

						name("categoryType");
						_value("Category");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class ContainOtherTerms extends io.intino.alexandria.ui.displays.components.ActionSwitch<io.intino.alexandria.ui.displays.notifiers.ActionSwitchNotifier, B>  {

				public ContainOtherTerms(B box) {
					super(box);
					_title("Contain other terms");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));

					_state(io.intino.alexandria.ui.displays.events.actionable.ToggleEvent.State.valueOf("Off"));
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Sou_66_3_0822411189 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Sou_66_3_0822411189(B box) {
					super(box);
					_value("Tags");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Tags extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,SourceTermTagTemplate, java.lang.Void>  {

				public Tags(UnitBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public SourceTermTagTemplate add(java.lang.Void value) {
					SourceTermTagTemplate child = new SourceTermTagTemplate(box());
					child.id(java.util.UUID.randomUUID().toString());
					add(child, "tags");
				    notifyAdd(child);
					return child;
				}
				@Override
				public void remove(SourceTermTagTemplate child) {
					removeChild(child, "tags");
				}
				public void clear() {
				    super.clear("tags");
				}
			}
		}
	}

	public class ChildrenView extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public SourceTermDialog.ChildrenView. AddTitle addTitle;
		public SourceTermDialog.ChildrenView. Sou_70_2_1986763456 sou_70_2_1986763456;

		public ChildrenView(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (addTitle == null) addTitle = register(new AddTitle(box()).<AddTitle>id("a_499239167").owner(AbstractSourceTermDialog.this));
			if (sou_70_2_1986763456 == null) sou_70_2_1986763456 = register(new Sou_70_2_1986763456(box()).<Sou_70_2_1986763456>id("a706663146").owner(AbstractSourceTermDialog.this));
		}

		public class AddTitle extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public AddTitle(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Sou_70_2_1986763456 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public SourceTermDialog.ChildrenView.Sou_70_2_1986763456. ChildCode childCode;
			public SourceTermDialog.ChildrenView.Sou_70_2_1986763456. ChildLabel childLabel;
			public SourceTermDialog.ChildrenView.Sou_70_2_1986763456. Sou_73_3_11870066214 sou_73_3_11870066214;

			public Sou_70_2_1986763456(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (childCode == null) childCode = register(new ChildCode(box()).<ChildCode>id("a1704898938").owner(AbstractSourceTermDialog.this));
				if (childLabel == null) childLabel = register(new ChildLabel(box()).<ChildLabel>id("a1320152327").owner(AbstractSourceTermDialog.this));
				if (sou_73_3_11870066214 == null) sou_73_3_11870066214 = register(new Sou_73_3_11870066214(box()).<Sou_73_3_11870066214>id("a1283214812").owner(AbstractSourceTermDialog.this));
			}

			public class ChildCode extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

				public ChildCode(B box) {
					super(box);
					label("Code");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class ChildLabel extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

				public ChildLabel(B box) {
					super(box);
					label("Label");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Sou_73_3_11870066214 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public SourceTermDialog.ChildrenView.Sou_70_2_1986763456.Sou_73_3_11870066214. Add add;

				public Sou_73_3_11870066214(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (add == null) add = register(new Add(box()).<Add>id("a_76440842").owner(AbstractSourceTermDialog.this));
				}

				public class Add extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

					public Add(B box) {
						super(box);
						_title("Add");
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
}