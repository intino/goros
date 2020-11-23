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

public abstract class AbstractNodeDocumentTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Edit edit;
	public Preview preview;
	public EditDocumentDialog editDocumentDialog;
	public NodeDocumentTemplate.EditDocumentDialog. Nodvie_73_2_01491773108 nodvie_73_2_01491773108;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108. Stepper stepper;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper. DownloadStep downloadStep;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep. Nodvie_76_5_01699803797 nodvie_76_5_01699803797;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797. Nodvie_77_6_0356285653 nodvie_77_6_0356285653;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797. Nodvie_78_6_0521107663 nodvie_78_6_0521107663;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797. Nodvie_79_6_0932197719 nodvie_79_6_0932197719;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797.Nodvie_79_6_0932197719. DownloadDocument downloadDocument;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper. EditingStep editingStep;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep. Nodvie_81_5_1566245186 nodvie_81_5_1566245186;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186. Nodvie_82_6_1331037279 nodvie_82_6_1331037279;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186. Nodvie_83_6_11182865935 nodvie_83_6_11182865935;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186. Nodvie_84_6_11698289504 nodvie_84_6_11698289504;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186.Nodvie_84_6_11698289504. NewDocument newDocument;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper. FinishStep finishStep;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.FinishStep. Nodvie_86_5_0584241504 nodvie_86_5_0584241504;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.FinishStep.Nodvie_86_5_0584241504. Nodvie_87_6_01587028506 nodvie_87_6_01587028506;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.FinishStep.Nodvie_86_5_0584241504. Nodvie_88_6_11009589694 nodvie_88_6_11009589694;
	public NodeDocumentTemplate.EditDocumentDialog. Nodvie_89_2_1955995399 nodvie_89_2_1955995399;
	public NodeDocumentTemplate.EditDocumentDialog. Nodvie_90_2_01225100375 nodvie_90_2_01225100375;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_90_2_01225100375. Nodvie_91_3_1210424442 nodvie_91_3_1210424442;
	public NodeDocumentTemplate.EditDocumentDialog.Nodvie_90_2_01225100375. Save save;

    public AbstractNodeDocumentTemplate(B box) {
        super(box);
        id("nodeDocumentTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (edit == null) edit = register(new Edit(box()).<Edit>id("a1729628403").owner(AbstractNodeDocumentTemplate.this));
		if (preview == null) preview = register(new Preview(box()).<Preview>id("a_2087979969").owner(AbstractNodeDocumentTemplate.this));
		if (editDocumentDialog == null) editDocumentDialog = register(new EditDocumentDialog(box()).<EditDocumentDialog>id("a1257892374").owner(AbstractNodeDocumentTemplate.this));
		if (editDocumentDialog != null) nodvie_73_2_01491773108 = editDocumentDialog.nodvie_73_2_01491773108;
		if (nodvie_73_2_01491773108 != null) stepper = editDocumentDialog.nodvie_73_2_01491773108.stepper;
		if (stepper != null) downloadStep = editDocumentDialog.nodvie_73_2_01491773108.stepper.downloadStep;
		if (downloadStep != null) nodvie_76_5_01699803797 = editDocumentDialog.nodvie_73_2_01491773108.stepper.downloadStep.nodvie_76_5_01699803797;
		if (nodvie_76_5_01699803797 != null) nodvie_77_6_0356285653 = editDocumentDialog.nodvie_73_2_01491773108.stepper.downloadStep.nodvie_76_5_01699803797.nodvie_77_6_0356285653;
		if (nodvie_76_5_01699803797 != null) nodvie_78_6_0521107663 = editDocumentDialog.nodvie_73_2_01491773108.stepper.downloadStep.nodvie_76_5_01699803797.nodvie_78_6_0521107663;
		if (nodvie_76_5_01699803797 != null) nodvie_79_6_0932197719 = editDocumentDialog.nodvie_73_2_01491773108.stepper.downloadStep.nodvie_76_5_01699803797.nodvie_79_6_0932197719;
		if (nodvie_79_6_0932197719 != null) downloadDocument = editDocumentDialog.nodvie_73_2_01491773108.stepper.downloadStep.nodvie_76_5_01699803797.nodvie_79_6_0932197719.downloadDocument;
		if (stepper != null) editingStep = editDocumentDialog.nodvie_73_2_01491773108.stepper.editingStep;
		if (editingStep != null) nodvie_81_5_1566245186 = editDocumentDialog.nodvie_73_2_01491773108.stepper.editingStep.nodvie_81_5_1566245186;
		if (nodvie_81_5_1566245186 != null) nodvie_82_6_1331037279 = editDocumentDialog.nodvie_73_2_01491773108.stepper.editingStep.nodvie_81_5_1566245186.nodvie_82_6_1331037279;
		if (nodvie_81_5_1566245186 != null) nodvie_83_6_11182865935 = editDocumentDialog.nodvie_73_2_01491773108.stepper.editingStep.nodvie_81_5_1566245186.nodvie_83_6_11182865935;
		if (nodvie_81_5_1566245186 != null) nodvie_84_6_11698289504 = editDocumentDialog.nodvie_73_2_01491773108.stepper.editingStep.nodvie_81_5_1566245186.nodvie_84_6_11698289504;
		if (nodvie_84_6_11698289504 != null) newDocument = editDocumentDialog.nodvie_73_2_01491773108.stepper.editingStep.nodvie_81_5_1566245186.nodvie_84_6_11698289504.newDocument;
		if (stepper != null) finishStep = editDocumentDialog.nodvie_73_2_01491773108.stepper.finishStep;
		if (finishStep != null) nodvie_86_5_0584241504 = editDocumentDialog.nodvie_73_2_01491773108.stepper.finishStep.nodvie_86_5_0584241504;
		if (nodvie_86_5_0584241504 != null) nodvie_87_6_01587028506 = editDocumentDialog.nodvie_73_2_01491773108.stepper.finishStep.nodvie_86_5_0584241504.nodvie_87_6_01587028506;
		if (nodvie_86_5_0584241504 != null) nodvie_88_6_11009589694 = editDocumentDialog.nodvie_73_2_01491773108.stepper.finishStep.nodvie_86_5_0584241504.nodvie_88_6_11009589694;
		if (editDocumentDialog != null) nodvie_89_2_1955995399 = editDocumentDialog.nodvie_89_2_1955995399;
		if (editDocumentDialog != null) nodvie_90_2_01225100375 = editDocumentDialog.nodvie_90_2_01225100375;
		if (nodvie_90_2_01225100375 != null) nodvie_91_3_1210424442 = editDocumentDialog.nodvie_90_2_01225100375.nodvie_91_3_1210424442;
		if (nodvie_90_2_01225100375 != null) save = editDocumentDialog.nodvie_90_2_01225100375.save;
		if (edit != null) edit.bindTo(editDocumentDialog);


		if (nodvie_91_3_1210424442 != null) nodvie_91_3_1210424442.bindTo(editDocumentDialog);
	}

	public class Edit extends io.intino.alexandria.ui.displays.components.OpenDialog<io.intino.alexandria.ui.displays.notifiers.OpenDialogNotifier, B>  {

		public Edit(B box) {
			super(box);
			_title("Modify document");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("MaterialIconButton"));
			_icon("Edit");
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Preview extends io.intino.alexandria.ui.displays.components.File<io.intino.alexandria.ui.displays.notifiers.FileNotifier, B>  {

		public Preview(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class EditDocumentDialog extends io.intino.alexandria.ui.displays.components.Dialog<io.intino.alexandria.ui.displays.notifiers.DialogNotifier, B>  {
		public NodeDocumentTemplate.EditDocumentDialog. Nodvie_73_2_01491773108 nodvie_73_2_01491773108;
		public NodeDocumentTemplate.EditDocumentDialog. Nodvie_89_2_1955995399 nodvie_89_2_1955995399;
		public NodeDocumentTemplate.EditDocumentDialog. Nodvie_90_2_01225100375 nodvie_90_2_01225100375;

		public EditDocumentDialog(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nodvie_73_2_01491773108 == null) nodvie_73_2_01491773108 = register(new Nodvie_73_2_01491773108(box()).<Nodvie_73_2_01491773108>id("a1545256").owner(AbstractNodeDocumentTemplate.this));
			if (nodvie_89_2_1955995399 == null) nodvie_89_2_1955995399 = register(new Nodvie_89_2_1955995399(box()).<Nodvie_89_2_1955995399>id("a_1825339574").owner(AbstractNodeDocumentTemplate.this));
			if (nodvie_90_2_01225100375 == null) nodvie_90_2_01225100375 = register(new Nodvie_90_2_01225100375(box()).<Nodvie_90_2_01225100375>id("a2129647878").owner(AbstractNodeDocumentTemplate.this));
		}

		public class Nodvie_73_2_01491773108 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108. Stepper stepper;

			public Nodvie_73_2_01491773108(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (stepper == null) stepper = register(new Stepper(box()).<Stepper>id("a_150559212").owner(AbstractNodeDocumentTemplate.this));
			}

			public class Stepper extends io.intino.alexandria.ui.displays.components.Stepper<io.intino.alexandria.ui.displays.notifiers.StepperNotifier, B>  {
				public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper. DownloadStep downloadStep;
				public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper. EditingStep editingStep;
				public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper. FinishStep finishStep;

				public Stepper(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (downloadStep == null) downloadStep = register(new DownloadStep(box()).<DownloadStep>id("a1568998335").owner(AbstractNodeDocumentTemplate.this));
					if (editingStep == null) editingStep = register(new EditingStep(box()).<EditingStep>id("a_1839109415").owner(AbstractNodeDocumentTemplate.this));
					if (finishStep == null) finishStep = register(new FinishStep(box()).<FinishStep>id("a_640196342").owner(AbstractNodeDocumentTemplate.this));
				}

				public class DownloadStep extends io.intino.alexandria.ui.displays.components.Step<io.intino.alexandria.ui.displays.notifiers.StepNotifier, B>  {
					public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep. Nodvie_76_5_01699803797 nodvie_76_5_01699803797;

					public DownloadStep(B box) {
						super(box);
						label("Download document");
					}

					@Override
					public void init() {
						super.init();
						if (nodvie_76_5_01699803797 == null) nodvie_76_5_01699803797 = register(new Nodvie_76_5_01699803797(box()).<Nodvie_76_5_01699803797>id("a_2026710827").owner(AbstractNodeDocumentTemplate.this));
					}

					public class Nodvie_76_5_01699803797 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797. Nodvie_77_6_0356285653 nodvie_77_6_0356285653;
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797. Nodvie_78_6_0521107663 nodvie_78_6_0521107663;
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797. Nodvie_79_6_0932197719 nodvie_79_6_0932197719;

						public Nodvie_76_5_01699803797(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (nodvie_77_6_0356285653 == null) nodvie_77_6_0356285653 = register(new Nodvie_77_6_0356285653(box()).<Nodvie_77_6_0356285653>id("a165163608").owner(AbstractNodeDocumentTemplate.this));
							if (nodvie_78_6_0521107663 == null) nodvie_78_6_0521107663 = register(new Nodvie_78_6_0521107663(box()).<Nodvie_78_6_0521107663>id("a_772309171").owner(AbstractNodeDocumentTemplate.this));
							if (nodvie_79_6_0932197719 == null) nodvie_79_6_0932197719 = register(new Nodvie_79_6_0932197719(box()).<Nodvie_79_6_0932197719>id("a_1574091835").owner(AbstractNodeDocumentTemplate.this));
						}

						public class Nodvie_77_6_0356285653 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Nodvie_77_6_0356285653(B box) {
								super(box);
								_value("Download document to edit it in your computer.");
							}

							@Override
							public void init() {
								super.init();
							}
						}

						public class Nodvie_78_6_0521107663 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Nodvie_78_6_0521107663(B box) {
								super(box);
								_value("Click next if you have already edit the document.");
							}

							@Override
							public void init() {
								super.init();
							}
						}

						public class Nodvie_79_6_0932197719 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
							public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.DownloadStep.Nodvie_76_5_01699803797.Nodvie_79_6_0932197719. DownloadDocument downloadDocument;

							public Nodvie_79_6_0932197719(B box) {
								super(box);
							}

							@Override
							public void init() {
								super.init();
								if (downloadDocument == null) downloadDocument = register(new DownloadDocument(box()).<DownloadDocument>id("a1809514646").owner(AbstractNodeDocumentTemplate.this));
							}

							public class DownloadDocument extends io.intino.alexandria.ui.displays.components.Download<io.intino.alexandria.ui.displays.notifiers.DownloadNotifier, B>  {

								public DownloadDocument(B box) {
									super(box);
									_title("Download");
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

				public class EditingStep extends io.intino.alexandria.ui.displays.components.Step<io.intino.alexandria.ui.displays.notifiers.StepNotifier, B>  {
					public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep. Nodvie_81_5_1566245186 nodvie_81_5_1566245186;

					public EditingStep(B box) {
						super(box);
						label("Edit document");
					}

					@Override
					public void init() {
						super.init();
						if (nodvie_81_5_1566245186 == null) nodvie_81_5_1566245186 = register(new Nodvie_81_5_1566245186(box()).<Nodvie_81_5_1566245186>id("a_332414746").owner(AbstractNodeDocumentTemplate.this));
					}

					public class Nodvie_81_5_1566245186 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186. Nodvie_82_6_1331037279 nodvie_82_6_1331037279;
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186. Nodvie_83_6_11182865935 nodvie_83_6_11182865935;
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186. Nodvie_84_6_11698289504 nodvie_84_6_11698289504;

						public Nodvie_81_5_1566245186(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (nodvie_82_6_1331037279 == null) nodvie_82_6_1331037279 = register(new Nodvie_82_6_1331037279(box()).<Nodvie_82_6_1331037279>id("a1120518139").owner(AbstractNodeDocumentTemplate.this));
							if (nodvie_83_6_11182865935 == null) nodvie_83_6_11182865935 = register(new Nodvie_83_6_11182865935(box()).<Nodvie_83_6_11182865935>id("a_1466031691").owner(AbstractNodeDocumentTemplate.this));
							if (nodvie_84_6_11698289504 == null) nodvie_84_6_11698289504 = register(new Nodvie_84_6_11698289504(box()).<Nodvie_84_6_11698289504>id("a_2097732414").owner(AbstractNodeDocumentTemplate.this));
						}

						public class Nodvie_82_6_1331037279 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Nodvie_82_6_1331037279(B box) {
								super(box);
								_value("Open the document and insert the changes that you want.");
							}

							@Override
							public void init() {
								super.init();
							}
						}

						public class Nodvie_83_6_11182865935 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Nodvie_83_6_11182865935(B box) {
								super(box);
								_value("When you finish, indicate the location of the modified document to save the last version in the system.");
							}

							@Override
							public void init() {
								super.init();
							}
						}

						public class Nodvie_84_6_11698289504 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
							public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.EditingStep.Nodvie_81_5_1566245186.Nodvie_84_6_11698289504. NewDocument newDocument;

							public Nodvie_84_6_11698289504(B box) {
								super(box);
							}

							@Override
							public void init() {
								super.init();
								if (newDocument == null) newDocument = register(new NewDocument(box()).<NewDocument>id("a1060849346").owner(AbstractNodeDocumentTemplate.this));
							}

							public class NewDocument extends io.intino.alexandria.ui.displays.components.FileEditable<io.intino.alexandria.ui.displays.notifiers.FileEditableNotifier, B>  {

								public NewDocument(B box) {
									super(box);
								}

								@Override
								public void init() {
									super.init();
								}
							}
						}
					}
				}

				public class FinishStep extends io.intino.alexandria.ui.displays.components.Step<io.intino.alexandria.ui.displays.notifiers.StepNotifier, B>  {
					public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.FinishStep. Nodvie_86_5_0584241504 nodvie_86_5_0584241504;

					public FinishStep(B box) {
						super(box);
						label("Document saved");
					}

					@Override
					public void init() {
						super.init();
						if (nodvie_86_5_0584241504 == null) nodvie_86_5_0584241504 = register(new Nodvie_86_5_0584241504(box()).<Nodvie_86_5_0584241504>id("a_1481571749").owner(AbstractNodeDocumentTemplate.this));
					}

					public class Nodvie_86_5_0584241504 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.FinishStep.Nodvie_86_5_0584241504. Nodvie_87_6_01587028506 nodvie_87_6_01587028506;
						public NodeDocumentTemplate.EditDocumentDialog.Nodvie_73_2_01491773108.Stepper.FinishStep.Nodvie_86_5_0584241504. Nodvie_88_6_11009589694 nodvie_88_6_11009589694;

						public Nodvie_86_5_0584241504(B box) {
							super(box);
						}

						@Override
						public void init() {
							super.init();
							if (nodvie_87_6_01587028506 == null) nodvie_87_6_01587028506 = register(new Nodvie_87_6_01587028506(box()).<Nodvie_87_6_01587028506>id("a_445678905").owner(AbstractNodeDocumentTemplate.this));
							if (nodvie_88_6_11009589694 == null) nodvie_88_6_11009589694 = register(new Nodvie_88_6_11009589694(box()).<Nodvie_88_6_11009589694>id("a578403748").owner(AbstractNodeDocumentTemplate.this));
						}

						public class Nodvie_87_6_01587028506 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Nodvie_87_6_01587028506(B box) {
								super(box);
								_value("New version of document received.");
							}

							@Override
							public void init() {
								super.init();
							}
						}

						public class Nodvie_88_6_11009589694 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

							public Nodvie_88_6_11009589694(B box) {
								super(box);
								_value("Click save to replace current version.");
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

		public class Nodvie_89_2_1955995399 extends io.intino.alexandria.ui.displays.components.Divider<io.intino.alexandria.ui.displays.notifiers.DividerNotifier, B>  {

			public Nodvie_89_2_1955995399(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Nodvie_90_2_01225100375 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public NodeDocumentTemplate.EditDocumentDialog.Nodvie_90_2_01225100375. Nodvie_91_3_1210424442 nodvie_91_3_1210424442;
			public NodeDocumentTemplate.EditDocumentDialog.Nodvie_90_2_01225100375. Save save;

			public Nodvie_90_2_01225100375(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (nodvie_91_3_1210424442 == null) nodvie_91_3_1210424442 = register(new Nodvie_91_3_1210424442(box()).<Nodvie_91_3_1210424442>id("a1425830529").owner(AbstractNodeDocumentTemplate.this));
				if (save == null) save = register(new Save(box()).<Save>id("a_357951361").owner(AbstractNodeDocumentTemplate.this));
			}

			public class Nodvie_91_3_1210424442 extends io.intino.alexandria.ui.displays.components.CloseDialog<io.intino.alexandria.ui.displays.notifiers.CloseDialogNotifier, B>  {

				public Nodvie_91_3_1210424442(B box) {
					super(box);
					_title("Cancel");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Save extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Save(B box) {
					super(box);
					_title("Save");
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