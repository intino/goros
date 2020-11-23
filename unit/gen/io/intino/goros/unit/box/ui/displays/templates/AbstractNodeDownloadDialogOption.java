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

public abstract class AbstractNodeDownloadDialogOption<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Noddia_22_1_11903500967 noddia_22_1_11903500967;
	public NodeDownloadDialogOption.Noddia_22_1_11903500967. Name name;
	public Noddia_23_1_11700625352 noddia_23_1_11700625352;
	public NodeDownloadDialogOption.Noddia_23_1_11700625352. Options options;

    public AbstractNodeDownloadDialogOption(B box) {
        super(box);
        id("NodeDownloadDialogOption");
    }

    @Override
	public void init() {
		super.init();
		if (noddia_22_1_11903500967 == null) noddia_22_1_11903500967 = register(new Noddia_22_1_11903500967(box()).<Noddia_22_1_11903500967>id("a425506369").owner(AbstractNodeDownloadDialogOption.this));
		if (noddia_22_1_11903500967 != null) name = noddia_22_1_11903500967.name;
		if (noddia_23_1_11700625352 == null) noddia_23_1_11700625352 = register(new Noddia_23_1_11700625352(box()).<Noddia_23_1_11700625352>id("a_1378891889").owner(AbstractNodeDownloadDialogOption.this));
		if (noddia_23_1_11700625352 != null) options = noddia_23_1_11700625352.options;
	}

	public class Noddia_22_1_11903500967 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NodeDownloadDialogOption.Noddia_22_1_11903500967. Name name;

		public Noddia_22_1_11903500967(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (name == null) name = register(new Name(box()).<Name>id("a_1197134942").owner(AbstractNodeDownloadDialogOption.this));
		}

		public class Name extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Name(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class Noddia_23_1_11700625352 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NodeDownloadDialogOption.Noddia_23_1_11700625352. Options options;

		public Noddia_23_1_11700625352(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (options == null) options = register(new Options(box()).<Options>id("a1088052456").owner(AbstractNodeDownloadDialogOption.this));
		}

		public class Options extends io.intino.alexandria.ui.displays.components.SelectorComboBox<io.intino.alexandria.ui.displays.notifiers.SelectorComboBoxNotifier, B>  {

			public Options(B box) {
				super(box);
				_multipleSelection(false);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}