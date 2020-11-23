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

public abstract class AbstractNodeNotesTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Nodvie_42_1_01822819043 nodvie_42_1_01822819043;
	public NodeNotesTemplate.Nodvie_42_1_01822819043. NodeNotesTable nodeNotesTable;
	public NodeNotesDialog nodeNotesDialog;
	public NodeNotesTemplate.NodeNotesDialog. Nodvie_58_2_11865488311 nodvie_58_2_11865488311;
	public NodeNotesTemplate.NodeNotesDialog. NameField nameField;
	public NodeNotesTemplate.NodeNotesDialog. ValueField valueField;
	public NodeNotesTemplate.NodeNotesDialog. Nodvie_61_2_11480484409 nodvie_61_2_11480484409;
	public NodeNotesTemplate.NodeNotesDialog.Nodvie_61_2_11480484409. Add add;

    public AbstractNodeNotesTemplate(B box) {
        super(box);
        id("nodeNotesTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (nodvie_42_1_01822819043 == null) nodvie_42_1_01822819043 = register(new Nodvie_42_1_01822819043(box()).<Nodvie_42_1_01822819043>id("a701554786").owner(AbstractNodeNotesTemplate.this));
		if (nodvie_42_1_01822819043 != null) nodeNotesTable = nodvie_42_1_01822819043.nodeNotesTable;
		if (nodeNotesDialog == null) nodeNotesDialog = register(new NodeNotesDialog(box()).<NodeNotesDialog>id("a_987498814").owner(AbstractNodeNotesTemplate.this));
		if (nodeNotesDialog != null) nodvie_58_2_11865488311 = nodeNotesDialog.nodvie_58_2_11865488311;
		if (nodeNotesDialog != null) nameField = nodeNotesDialog.nameField;
		if (nodeNotesDialog != null) valueField = nodeNotesDialog.valueField;
		if (nodeNotesDialog != null) nodvie_61_2_11480484409 = nodeNotesDialog.nodvie_61_2_11480484409;
		if (nodvie_61_2_11480484409 != null) add = nodeNotesDialog.nodvie_61_2_11480484409.add;
	}

	public class Nodvie_42_1_01822819043 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NodeNotesTemplate.Nodvie_42_1_01822819043. NodeNotesTable nodeNotesTable;

		public Nodvie_42_1_01822819043(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nodeNotesTable == null) nodeNotesTable = register(new NodeNotesTable(box()).<NodeNotesTable>id("a_1729398965").owner(AbstractNodeNotesTemplate.this));
		}

		public class NodeNotesTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, io.intino.goros.unit.box.ui.datasources.model.Note>  {

			public NodeNotesTable(B box) {
				super(box);

				_pageSize(20);
			}

			@Override
			public void init() {
				super.init();
			}


			public NodeNotesTableRow create(io.intino.goros.unit.box.ui.datasources.model.Note item) {
				NodeNotesTableRow row = new NodeNotesTableRow((UnitBox)box());
				row.id(java.util.UUID.randomUUID().toString());
				row.item(item);
				return row;
			}
			public class NodeNotesTableNameHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public NodeNotesTemplate.Nodvie_42_1_01822819043.NodeNotesTable.NodeNotesTableNameHeading. Nodvie_46_40_0871825099 nodvie_46_40_0871825099;

				public NodeNotesTableNameHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (nodvie_46_40_0871825099 == null) nodvie_46_40_0871825099 = register(new Nodvie_46_40_0871825099(box()).<Nodvie_46_40_0871825099>id("a9336383").owner(AbstractNodeNotesTemplate.this));
				}

				public class Nodvie_46_40_0871825099 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Nodvie_46_40_0871825099(B box) {
						super(box);
						_value("Nombre");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class NodeNotesTableValueHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
				public NodeNotesTemplate.Nodvie_42_1_01822819043.NodeNotesTable.NodeNotesTableValueHeading. Nodvie_49_41_1754749520 nodvie_49_41_1754749520;

				public NodeNotesTableValueHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (nodvie_49_41_1754749520 == null) nodvie_49_41_1754749520 = register(new Nodvie_49_41_1754749520(box()).<Nodvie_49_41_1754749520>id("a925336649").owner(AbstractNodeNotesTemplate.this));
				}

				public class Nodvie_49_41_1754749520 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Nodvie_49_41_1754749520(B box) {
						super(box);
						_value("Valor");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class NodeNotesTableOperationsHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {

				public NodeNotesTableOperationsHeading(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class NodeNotesDialog extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NodeNotesTemplate.NodeNotesDialog. Nodvie_58_2_11865488311 nodvie_58_2_11865488311;
		public NodeNotesTemplate.NodeNotesDialog. NameField nameField;
		public NodeNotesTemplate.NodeNotesDialog. ValueField valueField;
		public NodeNotesTemplate.NodeNotesDialog. Nodvie_61_2_11480484409 nodvie_61_2_11480484409;

		public NodeNotesDialog(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nodvie_58_2_11865488311 == null) nodvie_58_2_11865488311 = register(new Nodvie_58_2_11865488311(box()).<Nodvie_58_2_11865488311>id("a_1420532576").owner(AbstractNodeNotesTemplate.this));
			if (nameField == null) nameField = register(new NameField(box()).<NameField>id("a2111765490").owner(AbstractNodeNotesTemplate.this));
			if (valueField == null) valueField = register(new ValueField(box()).<ValueField>id("a_104247386").owner(AbstractNodeNotesTemplate.this));
			if (nodvie_61_2_11480484409 == null) nodvie_61_2_11480484409 = register(new Nodvie_61_2_11480484409(box()).<Nodvie_61_2_11480484409>id("a_1911160229").owner(AbstractNodeNotesTemplate.this));
		}

		public class Nodvie_58_2_11865488311 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Nodvie_58_2_11865488311(B box) {
				super(box);
				_value("Añadir nota");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class NameField extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

			public NameField(B box) {
				super(box);
				label("Nombre");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class ValueField extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

			public ValueField(B box) {
				super(box);
				label("Valor");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Nodvie_61_2_11480484409 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NodeNotesTemplate.NodeNotesDialog.Nodvie_61_2_11480484409. Add add;

			public Nodvie_61_2_11480484409(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (add == null) add = register(new Add(box()).<Add>id("a_750260733").owner(AbstractNodeNotesTemplate.this));
			}

			public class Add extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Add(B box) {
					super(box);
					_title("Añadir");
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