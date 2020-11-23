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

public abstract class AbstractNodeDownloadDialog<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Noddia_6_1_11231689493 noddia_6_1_11231689493;
	public NodeDownloadDialog.Noddia_6_1_11231689493. Noddia_7_2_0491900015 noddia_7_2_0491900015;
	public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015. Noddia_8_3_1317063330 noddia_8_3_1317063330;
	public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015. Format format;
	public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015.Format. Pdf pdf;
	public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015.Format. Csv csv;
	public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015.Format. Xls xls;
	public NodeDownloadDialog.Noddia_6_1_11231689493. ColumnsBlock columnsBlock;
	public NodeDownloadDialog.Noddia_6_1_11231689493.ColumnsBlock. Noddia_14_3_1118910571 noddia_14_3_1118910571;
	public NodeDownloadDialog.Noddia_6_1_11231689493.ColumnsBlock. Options options;
	public Noddia_16_1_1955995399 noddia_16_1_1955995399;
	public Noddia_17_1_01960515992 noddia_17_1_01960515992;
	public NodeDownloadDialog.Noddia_17_1_01960515992. DownloadCancel downloadCancel;
	public NodeDownloadDialog.Noddia_17_1_01960515992. DownloadAccept downloadAccept;

    public AbstractNodeDownloadDialog(B box) {
        super(box);
        id("NodeDownloadDialog");
    }

    @Override
	public void init() {
		super.init();
		if (noddia_6_1_11231689493 == null) noddia_6_1_11231689493 = register(new Noddia_6_1_11231689493(box()).<Noddia_6_1_11231689493>id("a1955491608").owner(AbstractNodeDownloadDialog.this));
		if (noddia_6_1_11231689493 != null) noddia_7_2_0491900015 = noddia_6_1_11231689493.noddia_7_2_0491900015;
		if (noddia_7_2_0491900015 != null) noddia_8_3_1317063330 = noddia_6_1_11231689493.noddia_7_2_0491900015.noddia_8_3_1317063330;
		if (noddia_7_2_0491900015 != null) format = noddia_6_1_11231689493.noddia_7_2_0491900015.format;
		if (format != null) pdf = noddia_6_1_11231689493.noddia_7_2_0491900015.format.pdf;
		if (format != null) csv = noddia_6_1_11231689493.noddia_7_2_0491900015.format.csv;
		if (format != null) xls = noddia_6_1_11231689493.noddia_7_2_0491900015.format.xls;
		if (noddia_6_1_11231689493 != null) columnsBlock = noddia_6_1_11231689493.columnsBlock;
		if (columnsBlock != null) noddia_14_3_1118910571 = noddia_6_1_11231689493.columnsBlock.noddia_14_3_1118910571;
		if (columnsBlock != null) options = noddia_6_1_11231689493.columnsBlock.options;
		if (noddia_16_1_1955995399 == null) noddia_16_1_1955995399 = register(new Noddia_16_1_1955995399(box()).<Noddia_16_1_1955995399>id("a2010955798").owner(AbstractNodeDownloadDialog.this));
		if (noddia_17_1_01960515992 == null) noddia_17_1_01960515992 = register(new Noddia_17_1_01960515992(box()).<Noddia_17_1_01960515992>id("a2083941692").owner(AbstractNodeDownloadDialog.this));
		if (noddia_17_1_01960515992 != null) downloadCancel = noddia_17_1_01960515992.downloadCancel;
		if (noddia_17_1_01960515992 != null) downloadAccept = noddia_17_1_01960515992.downloadAccept;
	}

	public class Noddia_6_1_11231689493 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NodeDownloadDialog.Noddia_6_1_11231689493. Noddia_7_2_0491900015 noddia_7_2_0491900015;
		public NodeDownloadDialog.Noddia_6_1_11231689493. ColumnsBlock columnsBlock;

		public Noddia_6_1_11231689493(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (noddia_7_2_0491900015 == null) noddia_7_2_0491900015 = register(new Noddia_7_2_0491900015(box()).<Noddia_7_2_0491900015>id("a706215557").owner(AbstractNodeDownloadDialog.this));
			if (columnsBlock == null) columnsBlock = register(new ColumnsBlock(box()).<ColumnsBlock>id("a_246641411").owner(AbstractNodeDownloadDialog.this));
		}

		public class Noddia_7_2_0491900015 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015. Noddia_8_3_1317063330 noddia_8_3_1317063330;
			public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015. Format format;

			public Noddia_7_2_0491900015(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (noddia_8_3_1317063330 == null) noddia_8_3_1317063330 = register(new Noddia_8_3_1317063330(box()).<Noddia_8_3_1317063330>id("a828680825").owner(AbstractNodeDownloadDialog.this));
				if (format == null) format = register(new Format(box()).<Format>id("a2085126658").owner(AbstractNodeDownloadDialog.this));
			}

			public class Noddia_8_3_1317063330 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Noddia_8_3_1317063330(B box) {
					super(box);
					_value("Indique el formato de descarga");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Format extends io.intino.alexandria.ui.displays.components.SelectorComboBox<io.intino.alexandria.ui.displays.notifiers.SelectorComboBoxNotifier, B>  {
				public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015.Format. Pdf pdf;
				public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015.Format. Csv csv;
				public NodeDownloadDialog.Noddia_6_1_11231689493.Noddia_7_2_0491900015.Format. Xls xls;

				public Format(B box) {
					super(box);
					_multipleSelection(false);
				}

				@Override
				public void init() {
					super.init();
					if (pdf == null) pdf = register(new Pdf(box()).<Pdf>id("a1082167605").owner(AbstractNodeDownloadDialog.this));
					if (csv == null) csv = register(new Csv(box()).<Csv>id("a1082155593").owner(AbstractNodeDownloadDialog.this));
					if (xls == null) xls = register(new Xls(box()).<Xls>id("a1082175554").owner(AbstractNodeDownloadDialog.this));
				}

				public class Pdf extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

					public Pdf(B box) {
						super(box);

						name("pdf");
						_value("Formato de documento portátil (pdf)");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class Csv extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

					public Csv(B box) {
						super(box);

						name("csv");
						_value("Valores separados por coma (csv)");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class Xls extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B> implements io.intino.alexandria.ui.displays.components.selector.SelectorOption {

					public Xls(B box) {
						super(box);

						name("xls");
						_value("Documento de Excel (xls)");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}
		}

		public class ColumnsBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NodeDownloadDialog.Noddia_6_1_11231689493.ColumnsBlock. Noddia_14_3_1118910571 noddia_14_3_1118910571;
			public NodeDownloadDialog.Noddia_6_1_11231689493.ColumnsBlock. Options options;

			public ColumnsBlock(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (noddia_14_3_1118910571 == null) noddia_14_3_1118910571 = register(new Noddia_14_3_1118910571(box()).<Noddia_14_3_1118910571>id("a532976130").owner(AbstractNodeDownloadDialog.this));
				if (options == null) options = register(new Options((UnitBox)box()).<Options>id("a465071452").owner(AbstractNodeDownloadDialog.this));
			}

			public class Noddia_14_3_1118910571 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Noddia_14_3_1118910571(B box) {
					super(box);
					_value("Indique las columnas de la cabecera del documento");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Options extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,NodeDownloadDialogOption, java.lang.Void>  {

				public Options(UnitBox box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}

				@Override
				public NodeDownloadDialogOption add(java.lang.Void value) {
					NodeDownloadDialogOption child = new NodeDownloadDialogOption(box());
					child.id(java.util.UUID.randomUUID().toString());
					add(child, "options");
				    notifyAdd(child);
					return child;
				}
				@Override
				public void remove(NodeDownloadDialogOption child) {
					removeChild(child, "options");
				}
				public void clear() {
				    super.clear("options");
				}
			}
		}
	}

	public class Noddia_16_1_1955995399 extends io.intino.alexandria.ui.displays.components.Divider<io.intino.alexandria.ui.displays.notifiers.DividerNotifier, B>  {

		public Noddia_16_1_1955995399(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Noddia_17_1_01960515992 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public NodeDownloadDialog.Noddia_17_1_01960515992. DownloadCancel downloadCancel;
		public NodeDownloadDialog.Noddia_17_1_01960515992. DownloadAccept downloadAccept;

		public Noddia_17_1_01960515992(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (downloadCancel == null) downloadCancel = register(new DownloadCancel(box()).<DownloadCancel>id("a848750163").owner(AbstractNodeDownloadDialog.this));
			if (downloadAccept == null) downloadAccept = register(new DownloadAccept(box()).<DownloadAccept>id("a793013473").owner(AbstractNodeDownloadDialog.this));
		}

		public class DownloadCancel extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

			public DownloadCancel(B box) {
				super(box);
				_title("Cancelar");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class DownloadAccept extends io.intino.alexandria.ui.displays.components.Download<io.intino.alexandria.ui.displays.notifiers.DownloadNotifier, B>  {

			public DownloadAccept(B box) {
				super(box);
				_title("Aceptar");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}