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

public abstract class AbstractTaskToolbarTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Update update;
	public Assign assign;
	public UnAssign unAssign;
	public Abort abort;
	public AssignTaskOwnerDialogBox assignTaskOwnerDialogBox;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox. Content content;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Content. AssignTaskDialogTable assignTaskDialogTable;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Content. Reason reason;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox. Tasdia_22_2_1955995399 tasdia_22_2_1955995399;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox. Tasdia_23_2_0947611999 tasdia_23_2_0947611999;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Tasdia_23_2_0947611999. Cancel cancel;
	public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Tasdia_23_2_0947611999. Accept accept;

    public AbstractTaskToolbarTemplate(B box) {
        super(box);
        id("taskToolbarTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (update == null) update = register(new Update(box()).<Update>id("a_128996681").owner(AbstractTaskToolbarTemplate.this));
		if (assign == null) assign = register(new Assign(box()).<Assign>id("a_698354979").owner(AbstractTaskToolbarTemplate.this));
		if (unAssign == null) unAssign = register(new UnAssign(box()).<UnAssign>id("a2122781526").owner(AbstractTaskToolbarTemplate.this));
		if (abort == null) abort = register(new Abort(box()).<Abort>id("a531151746").owner(AbstractTaskToolbarTemplate.this));
		if (assignTaskOwnerDialogBox == null) assignTaskOwnerDialogBox = register(new AssignTaskOwnerDialogBox(box()).<AssignTaskOwnerDialogBox>id("a1536110738").owner(AbstractTaskToolbarTemplate.this));
		if (assignTaskOwnerDialogBox != null) content = assignTaskOwnerDialogBox.content;
		if (content != null) assignTaskDialogTable = assignTaskOwnerDialogBox.content.assignTaskDialogTable;
		if (content != null) reason = assignTaskOwnerDialogBox.content.reason;
		if (assignTaskOwnerDialogBox != null) tasdia_22_2_1955995399 = assignTaskOwnerDialogBox.tasdia_22_2_1955995399;
		if (assignTaskOwnerDialogBox != null) tasdia_23_2_0947611999 = assignTaskOwnerDialogBox.tasdia_23_2_0947611999;
		if (tasdia_23_2_0947611999 != null) cancel = assignTaskOwnerDialogBox.tasdia_23_2_0947611999.cancel;
		if (tasdia_23_2_0947611999 != null) accept = assignTaskOwnerDialogBox.tasdia_23_2_0947611999.accept;
		if (assign != null) assign.bindTo(assignTaskOwnerDialogBox);


		if (cancel != null) cancel.bindTo(assignTaskOwnerDialogBox);
	}

	public class Update extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public Update(B box) {
			super(box);
			_title("Actualizar");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Assign extends io.intino.alexandria.ui.displays.components.OpenDialog<io.intino.alexandria.ui.displays.notifiers.OpenDialogNotifier, B>  {

		public Assign(B box) {
			super(box);
			_title("Asignar...");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class UnAssign extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public UnAssign(B box) {
			super(box);
			_title("Desasignar");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Abort extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

		public Abort(B box) {
			super(box);
			_title("Abortar");
			_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class AssignTaskOwnerDialogBox extends io.intino.alexandria.ui.displays.components.Dialog<io.intino.alexandria.ui.displays.notifiers.DialogNotifier, B>  {
		public TaskToolbarTemplate.AssignTaskOwnerDialogBox. Content content;
		public TaskToolbarTemplate.AssignTaskOwnerDialogBox. Tasdia_22_2_1955995399 tasdia_22_2_1955995399;
		public TaskToolbarTemplate.AssignTaskOwnerDialogBox. Tasdia_23_2_0947611999 tasdia_23_2_0947611999;

		public AssignTaskOwnerDialogBox(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (content == null) content = register(new Content(box()).<Content>id("a_2052236852").owner(AbstractTaskToolbarTemplate.this));
			if (tasdia_22_2_1955995399 == null) tasdia_22_2_1955995399 = register(new Tasdia_22_2_1955995399(box()).<Tasdia_22_2_1955995399>id("a825876246").owner(AbstractTaskToolbarTemplate.this));
			if (tasdia_23_2_0947611999 == null) tasdia_23_2_0947611999 = register(new Tasdia_23_2_0947611999(box()).<Tasdia_23_2_0947611999>id("a455639134").owner(AbstractTaskToolbarTemplate.this));
		}

		public class Content extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Content. AssignTaskDialogTable assignTaskDialogTable;
			public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Content. Reason reason;

			public Content(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (assignTaskDialogTable == null) assignTaskDialogTable = register(new AssignTaskDialogTable(box()).<AssignTaskDialogTable>id("a_1464013441").owner(AbstractTaskToolbarTemplate.this));
				if (reason == null) reason = register(new Reason(box()).<Reason>id("a_1485711337").owner(AbstractTaskToolbarTemplate.this));
			}

			public class AssignTaskDialogTable extends io.intino.alexandria.ui.displays.components.Table<B, io.intino.alexandria.ui.displays.components.Row, org.monet.space.kernel.model.User> implements io.intino.alexandria.ui.displays.components.collection.Selectable {

				public AssignTaskDialogTable(B box) {
					super(box);

					_pageSize(20);
				}

				@Override
				public void init() {
					super.init();
				}
				public void onSelect(io.intino.alexandria.ui.displays.events.SelectionListener listener) {
					super.addSelectionListener(listener);
				}

				public AssignTaskDialogTableRow create(org.monet.space.kernel.model.User item) {
					AssignTaskDialogTableRow row = new AssignTaskDialogTableRow((UnitBox)box());
					row.id(java.util.UUID.randomUUID().toString());
					row.item(item);
					return row;
				}
				public class AssignTaskDialogTableFullnameHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
					public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Content.AssignTaskDialogTable.AssignTaskDialogTableFullnameHeading. Tasdia_16_52_01234296205 tasdia_16_52_01234296205;

					public AssignTaskDialogTableFullnameHeading(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (tasdia_16_52_01234296205 == null) tasdia_16_52_01234296205 = register(new Tasdia_16_52_01234296205(box()).<Tasdia_16_52_01234296205>id("a2091506597").owner(AbstractTaskToolbarTemplate.this));
					}

					public class Tasdia_16_52_01234296205 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

						public Tasdia_16_52_01234296205(B box) {
							super(box);
							_value("Fullname");
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}

				public class AssignTaskDialogTableEmailHeading extends io.intino.alexandria.ui.displays.components.Heading<io.intino.alexandria.ui.displays.notifiers.HeadingNotifier, B>  {
					public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Content.AssignTaskDialogTable.AssignTaskDialogTableEmailHeading. Tasdia_19_49_0521747745 tasdia_19_49_0521747745;

					public AssignTaskDialogTableEmailHeading(B box) {
						super(box);
					}

					@Override
					public void init() {
						super.init();
						if (tasdia_19_49_0521747745 == null) tasdia_19_49_0521747745 = register(new Tasdia_19_49_0521747745(box()).<Tasdia_19_49_0521747745>id("a1243679357").owner(AbstractTaskToolbarTemplate.this));
					}

					public class Tasdia_19_49_0521747745 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

						public Tasdia_19_49_0521747745(B box) {
							super(box);
							_value("Email");
						}

						@Override
						public void init() {
							super.init();
						}
					}
				}
			}

			public class Reason extends io.intino.alexandria.ui.displays.components.TextEditable<io.intino.alexandria.ui.displays.notifiers.TextEditableNotifier, B>  {

				public Reason(B box) {
					super(box);
					label("Reason");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class Tasdia_22_2_1955995399 extends io.intino.alexandria.ui.displays.components.Divider<io.intino.alexandria.ui.displays.notifiers.DividerNotifier, B>  {

			public Tasdia_22_2_1955995399(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Tasdia_23_2_0947611999 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Tasdia_23_2_0947611999. Cancel cancel;
			public TaskToolbarTemplate.AssignTaskOwnerDialogBox.Tasdia_23_2_0947611999. Accept accept;

			public Tasdia_23_2_0947611999(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (cancel == null) cancel = register(new Cancel(box()).<Cancel>id("a_100049044").owner(AbstractTaskToolbarTemplate.this));
				if (accept == null) accept = register(new Accept(box()).<Accept>id("a_155785734").owner(AbstractTaskToolbarTemplate.this));
			}

			public class Cancel extends io.intino.alexandria.ui.displays.components.CloseDialog<io.intino.alexandria.ui.displays.notifiers.CloseDialogNotifier, B>  {

				public Cancel(B box) {
					super(box);
					_title("Cancel");
					_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Button"));
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class Accept extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

				public Accept(B box) {
					super(box);
					_title("OK");
					_readonly(true);
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