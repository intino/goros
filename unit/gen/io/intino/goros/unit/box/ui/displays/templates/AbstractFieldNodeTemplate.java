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

public abstract class AbstractFieldNodeTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Title title;
	public Nodvie_96_1_1322333223 nodvie_96_1_1322333223;
	public FieldNodeTemplate.Nodvie_96_1_1322333223. Nodvie_97_2_11992664387 nodvie_97_2_11992664387;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387. NoTypesDefinedBlock noTypesDefinedBlock;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.NoTypesDefinedBlock. Nodvie_99_4_19565012 nodvie_99_4_19565012;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387. EmptyBlock emptyBlock;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock. Nodvie_101_4_0992508185 nodvie_101_4_0992508185;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock. Nodvie_102_4_1401232569 nodvie_102_4_1401232569;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock.Nodvie_102_4_1401232569. AddType addType;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock.Nodvie_102_4_1401232569. SelectType selectType;
	public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387. NodeFrame nodeFrame;
	public SelectNodeTypeDialog selectNodeTypeDialog;
	public FieldNodeTemplate.SelectNodeTypeDialog. NodeTypeSeletor nodeTypeSeletor;

    public AbstractFieldNodeTemplate(B box) {
        super(box);
        id("fieldNodeTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (title == null) title = register(new Title(box()).<Title>id("a782578768").owner(AbstractFieldNodeTemplate.this));
		if (nodvie_96_1_1322333223 == null) nodvie_96_1_1322333223 = register(new Nodvie_96_1_1322333223(box()).<Nodvie_96_1_1322333223>id("a_727863414").owner(AbstractFieldNodeTemplate.this));
		if (nodvie_96_1_1322333223 != null) nodvie_97_2_11992664387 = nodvie_96_1_1322333223.nodvie_97_2_11992664387;
		if (nodvie_97_2_11992664387 != null) noTypesDefinedBlock = nodvie_96_1_1322333223.nodvie_97_2_11992664387.noTypesDefinedBlock;
		if (noTypesDefinedBlock != null) nodvie_99_4_19565012 = nodvie_96_1_1322333223.nodvie_97_2_11992664387.noTypesDefinedBlock.nodvie_99_4_19565012;
		if (nodvie_97_2_11992664387 != null) emptyBlock = nodvie_96_1_1322333223.nodvie_97_2_11992664387.emptyBlock;
		if (emptyBlock != null) nodvie_101_4_0992508185 = nodvie_96_1_1322333223.nodvie_97_2_11992664387.emptyBlock.nodvie_101_4_0992508185;
		if (emptyBlock != null) nodvie_102_4_1401232569 = nodvie_96_1_1322333223.nodvie_97_2_11992664387.emptyBlock.nodvie_102_4_1401232569;
		if (nodvie_102_4_1401232569 != null) addType = nodvie_96_1_1322333223.nodvie_97_2_11992664387.emptyBlock.nodvie_102_4_1401232569.addType;
		if (nodvie_102_4_1401232569 != null) selectType = nodvie_96_1_1322333223.nodvie_97_2_11992664387.emptyBlock.nodvie_102_4_1401232569.selectType;
		if (nodvie_97_2_11992664387 != null) nodeFrame = nodvie_96_1_1322333223.nodvie_97_2_11992664387.nodeFrame;
		if (selectNodeTypeDialog == null) selectNodeTypeDialog = register(new SelectNodeTypeDialog(box()).<SelectNodeTypeDialog>id("a_1309250584").owner(AbstractFieldNodeTemplate.this));
		if (selectNodeTypeDialog != null) nodeTypeSeletor = selectNodeTypeDialog.nodeTypeSeletor;




		if (selectType != null) selectType.bindTo(selectNodeTypeDialog);
		if (selectNodeTypeDialog != null) selectNodeTypeDialog.bindTo(nodeTypeSeletor);
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

	public class Nodvie_96_1_1322333223 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public FieldNodeTemplate.Nodvie_96_1_1322333223. Nodvie_97_2_11992664387 nodvie_97_2_11992664387;

		public Nodvie_96_1_1322333223(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nodvie_97_2_11992664387 == null) nodvie_97_2_11992664387 = register(new Nodvie_97_2_11992664387(box()).<Nodvie_97_2_11992664387>id("a1020337941").owner(AbstractFieldNodeTemplate.this));
		}

		public class Nodvie_97_2_11992664387 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387. NoTypesDefinedBlock noTypesDefinedBlock;
			public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387. EmptyBlock emptyBlock;
			public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387. NodeFrame nodeFrame;

			public Nodvie_97_2_11992664387(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (noTypesDefinedBlock == null) noTypesDefinedBlock = register(new NoTypesDefinedBlock(box()).<NoTypesDefinedBlock>id("a474060001").owner(AbstractFieldNodeTemplate.this));
				if (emptyBlock == null) emptyBlock = register(new EmptyBlock(box()).<EmptyBlock>id("a_675895269").owner(AbstractFieldNodeTemplate.this));
				if (nodeFrame == null) nodeFrame = register(new NodeFrame(box()).<NodeFrame>id("a_1760861104").owner(AbstractFieldNodeTemplate.this));
			}

			public class NoTypesDefinedBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.NoTypesDefinedBlock. Nodvie_99_4_19565012 nodvie_99_4_19565012;

				public NoTypesDefinedBlock(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (nodvie_99_4_19565012 == null) nodvie_99_4_19565012 = register(new Nodvie_99_4_19565012(box()).<Nodvie_99_4_19565012>id("a834478397").owner(AbstractFieldNodeTemplate.this));
				}

				public class Nodvie_99_4_19565012 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Nodvie_99_4_19565012(B box) {
						super(box);
						_value("Your model is wrong. Property 'add' or 'contain' not defined.");
					}

					@Override
					public void init() {
						super.init();
					}
				}
			}

			public class EmptyBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock. Nodvie_101_4_0992508185 nodvie_101_4_0992508185;
				public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock. Nodvie_102_4_1401232569 nodvie_102_4_1401232569;

				public EmptyBlock(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (nodvie_101_4_0992508185 == null) nodvie_101_4_0992508185 = register(new Nodvie_101_4_0992508185(box()).<Nodvie_101_4_0992508185>id("a_1268040713").owner(AbstractFieldNodeTemplate.this));
					if (nodvie_102_4_1401232569 == null) nodvie_102_4_1401232569 = register(new Nodvie_102_4_1401232569(box()).<Nodvie_102_4_1401232569>id("a_998994482").owner(AbstractFieldNodeTemplate.this));
				}

				public class Nodvie_101_4_0992508185 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

					public Nodvie_101_4_0992508185(B box) {
						super(box);
						_value("No element defined");
					}

					@Override
					public void init() {
						super.init();
					}
				}

				public class Nodvie_102_4_1401232569 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
					public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock.Nodvie_102_4_1401232569. AddType addType;
					public FieldNodeTemplate.Nodvie_96_1_1322333223.Nodvie_97_2_11992664387.EmptyBlock.Nodvie_102_4_1401232569. SelectType selectType;

					public Nodvie_102_4_1401232569(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (addType == null) addType = register(new AddType(box()).<AddType>id("a197496209").owner(AbstractFieldNodeTemplate.this));
						if (selectType == null) selectType = register(new SelectType(box()).<SelectType>id("a1088344192").owner(AbstractFieldNodeTemplate.this));
					}

					public class AddType extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

						public AddType(B box) {
							super(box);
							_title("Add element");
							_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
						}

						@Override
						public void init() {
							super.init();
						}
					}

					public class SelectType extends io.intino.alexandria.ui.displays.components.OpenDialog<io.intino.alexandria.ui.displays.notifiers.OpenDialogNotifier, B>  {

						public SelectType(B box) {
							super(box);
							_title("Add element");
							_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}
			}

			public class NodeFrame extends io.intino.alexandria.ui.displays.components.DisplayStamp<io.intino.alexandria.ui.displays.notifiers.DisplayStampNotifier, B>  {

				public NodeFrame(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}

	public class SelectNodeTypeDialog extends io.intino.alexandria.ui.displays.components.DecisionDialog<io.intino.alexandria.ui.displays.notifiers.DecisionDialogNotifier, B>  {
		public FieldNodeTemplate.SelectNodeTypeDialog. NodeTypeSeletor nodeTypeSeletor;

		public SelectNodeTypeDialog(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (nodeTypeSeletor == null) nodeTypeSeletor = register(new NodeTypeSeletor(box()).<NodeTypeSeletor>id("a_1724746791").owner(AbstractFieldNodeTemplate.this));
		}

		public class NodeTypeSeletor extends io.intino.alexandria.ui.displays.components.SelectorListBox<io.intino.alexandria.ui.displays.notifiers.SelectorListBoxNotifier, B>  {

			public NodeTypeSeletor(B box) {
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