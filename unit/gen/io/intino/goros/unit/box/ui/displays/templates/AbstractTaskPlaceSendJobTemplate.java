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

public abstract class AbstractTaskPlaceSendJobTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public WaitingView waitingView;
	public TaskPlaceSendJobTemplate.WaitingView. Tasvie_57_2_01131215905 tasvie_57_2_01131215905;
	public TaskPlaceSendJobTemplate.WaitingView. Tasvie_58_2_1603897497 tasvie_58_2_1603897497;
	public PendingView pendingView;
	public TaskPlaceSendJobTemplate.PendingView. PendingMessage pendingMessage;
	public TaskPlaceSendJobTemplate.PendingView. OpenRoles openRoles;
	public TaskPlaceSendJobTemplate.PendingView. Roles roles;
	public TaskPlaceSendJobTemplate.PendingView. UnAssignedRole unAssignedRole;
	public TaskPlaceSendJobTemplate.PendingView. SetupBlock setupBlock;
	public TaskPlaceSendJobTemplate.PendingView.SetupBlock. SetupFrame setupFrame;
	public TaskPlaceSendJobTemplate.PendingView.SetupBlock. SetupToolbar setupToolbar;
	public TaskPlaceSendJobTemplate.PendingView.SetupBlock.SetupToolbar. SolveSetup solveSetup;
	public FailureView failureView;
	public TaskPlaceSendJobTemplate.FailureView. Tasvie_68_2_01892404598 tasvie_68_2_01892404598;
	public TaskPlaceSendJobTemplate.FailureView.Tasvie_68_2_01892404598. Tasvie_69_3_0466299490 tasvie_69_3_0466299490;

    public AbstractTaskPlaceSendJobTemplate(B box) {
        super(box);
        id("taskPlaceSendJobTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a279493665").owner(AbstractTaskPlaceSendJobTemplate.this));
		if (waitingView == null) waitingView = register(new WaitingView(box()).<WaitingView>id("a_2070659585").owner(AbstractTaskPlaceSendJobTemplate.this));
		if (waitingView != null) tasvie_57_2_01131215905 = waitingView.tasvie_57_2_01131215905;
		if (waitingView != null) tasvie_58_2_1603897497 = waitingView.tasvie_58_2_1603897497;
		if (pendingView == null) pendingView = register(new PendingView(box()).<PendingView>id("a_1430487991").owner(AbstractTaskPlaceSendJobTemplate.this));
		if (pendingView != null) pendingMessage = pendingView.pendingMessage;
		if (pendingView != null) openRoles = pendingView.openRoles;
		if (pendingView != null) roles = pendingView.roles;
		if (pendingView != null) unAssignedRole = pendingView.unAssignedRole;
		if (pendingView != null) setupBlock = pendingView.setupBlock;
		if (setupBlock != null) setupFrame = pendingView.setupBlock.setupFrame;
		if (setupBlock != null) setupToolbar = pendingView.setupBlock.setupToolbar;
		if (setupToolbar != null) solveSetup = pendingView.setupBlock.setupToolbar.solveSetup;
		if (failureView == null) failureView = register(new FailureView(box()).<FailureView>id("a_472059204").owner(AbstractTaskPlaceSendJobTemplate.this));
		if (failureView != null) tasvie_68_2_01892404598 = failureView.tasvie_68_2_01892404598;
		if (tasvie_68_2_01892404598 != null) tasvie_69_3_0466299490 = failureView.tasvie_68_2_01892404598.tasvie_69_3_0466299490;
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Label(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class WaitingView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendJobTemplate.WaitingView. Tasvie_57_2_01131215905 tasvie_57_2_01131215905;
		public TaskPlaceSendJobTemplate.WaitingView. Tasvie_58_2_1603897497 tasvie_58_2_1603897497;

		public WaitingView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_57_2_01131215905 == null) tasvie_57_2_01131215905 = register(new Tasvie_57_2_01131215905(box()).<Tasvie_57_2_01131215905>id("a315135007").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (tasvie_58_2_1603897497 == null) tasvie_58_2_1603897497 = register(new Tasvie_58_2_1603897497(box()).<Tasvie_58_2_1603897497>id("a_181156070").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (tasvie_57_2_01131215905 == null) tasvie_57_2_01131215905 = waitingView.tasvie_57_2_01131215905;
			if (tasvie_58_2_1603897497 == null) tasvie_58_2_1603897497 = waitingView.tasvie_58_2_1603897497;
		}

		public class Tasvie_57_2_01131215905 extends io.intino.alexandria.ui.displays.components.Spinner<io.intino.alexandria.ui.displays.notifiers.SpinnerNotifier, B>  {

			public Tasvie_57_2_01131215905(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Tasvie_58_2_1603897497 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_58_2_1603897497(B box) {
				super(box);
				_value("Sending to selected worker...");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class PendingView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendJobTemplate.PendingView. PendingMessage pendingMessage;
		public TaskPlaceSendJobTemplate.PendingView. OpenRoles openRoles;
		public TaskPlaceSendJobTemplate.PendingView. Roles roles;
		public TaskPlaceSendJobTemplate.PendingView. UnAssignedRole unAssignedRole;
		public TaskPlaceSendJobTemplate.PendingView. SetupBlock setupBlock;

		public PendingView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (pendingMessage == null) pendingMessage = register(new PendingMessage(box()).<PendingMessage>id("a166272294").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (openRoles == null) openRoles = register(new OpenRoles(box()).<OpenRoles>id("a_1371847139").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (roles == null) roles = register(new Roles((UnitBox)box()).<Roles>id("a_257076409").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (unAssignedRole == null) unAssignedRole = register(new UnAssignedRole(box()).<UnAssignedRole>id("a_1420204205").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (setupBlock == null) setupBlock = register(new SetupBlock(box()).<SetupBlock>id("a1150755270").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (pendingMessage == null) pendingMessage = pendingView.pendingMessage;
			if (openRoles == null) openRoles = pendingView.openRoles;
			if (roles == null) roles = pendingView.roles;
			if (unAssignedRole == null) unAssignedRole = pendingView.unAssignedRole;
			if (setupFrame == null) setupFrame = pendingView.setupBlock.setupFrame;
			if (solveSetup == null) solveSetup = pendingView.setupBlock.setupToolbar.solveSetup;
		}

		public class PendingMessage extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public PendingMessage(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class OpenRoles extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B> implements io.intino.alexandria.ui.displays.components.addressable.Addressed<OpenRoles> {

			public OpenRoles(B box) {
				super(box);
				_title("Ver roles");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
				_path("/roles");
			}

			@Override
			public void init() {
				super.init();
			}
			@Override
			public OpenRoles address(java.util.function.Function<String, String> addressFromPathResolver) {
			    address(addressFromPathResolver.apply(path()));
			    return this;
			}
		}

		public class Roles extends io.intino.alexandria.ui.displays.components.Multiple<UnitBox,TaskPlaceRoleTemplate, java.lang.Void>  {

			public Roles(UnitBox box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}

			@Override
			public TaskPlaceRoleTemplate add(java.lang.Void value) {
				TaskPlaceRoleTemplate child = new TaskPlaceRoleTemplate(box());
				child.id(java.util.UUID.randomUUID().toString());
				add(child, "roles");
			    notifyAdd(child);
				return child;
			}
			@Override
			public void remove(TaskPlaceRoleTemplate child) {
				removeChild(child, "roles");
			}
			public void clear() {
			    super.clear("roles");
			}
		}

		public class UnAssignedRole extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

			public UnAssignedRole(B box) {
				super(box);
				_title("Unassigned");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class SetupBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskPlaceSendJobTemplate.PendingView.SetupBlock. SetupFrame setupFrame;
			public TaskPlaceSendJobTemplate.PendingView.SetupBlock. SetupToolbar setupToolbar;

			public SetupBlock(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (setupFrame == null) setupFrame = register(new SetupFrame(box()).<SetupFrame>id("a537657609").owner(AbstractTaskPlaceSendJobTemplate.this));
				if (setupToolbar == null) setupToolbar = register(new SetupToolbar(box()).<SetupToolbar>id("a760048663").owner(AbstractTaskPlaceSendJobTemplate.this));
			}

			public class SetupFrame extends io.intino.alexandria.ui.displays.components.DisplayStamp<io.intino.alexandria.ui.displays.notifiers.DisplayStampNotifier, B>  {

				public SetupFrame(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class SetupToolbar extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
				public TaskPlaceSendJobTemplate.PendingView.SetupBlock.SetupToolbar. SolveSetup solveSetup;

				public SetupToolbar(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (solveSetup == null) solveSetup = register(new SolveSetup(box()).<SolveSetup>id("a1091450534").owner(AbstractTaskPlaceSendJobTemplate.this));
				}

				public class SolveSetup extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

					public SolveSetup(B box) {
						super(box);
						_title("Continue");
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

	public class FailureView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendJobTemplate.FailureView. Tasvie_68_2_01892404598 tasvie_68_2_01892404598;

		public FailureView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_68_2_01892404598 == null) tasvie_68_2_01892404598 = register(new Tasvie_68_2_01892404598(box()).<Tasvie_68_2_01892404598>id("a_1733111054").owner(AbstractTaskPlaceSendJobTemplate.this));
			if (tasvie_69_3_0466299490 == null) tasvie_69_3_0466299490 = failureView.tasvie_68_2_01892404598.tasvie_69_3_0466299490;
		}

		public class Tasvie_68_2_01892404598 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskPlaceSendJobTemplate.FailureView.Tasvie_68_2_01892404598. Tasvie_69_3_0466299490 tasvie_69_3_0466299490;

			public Tasvie_68_2_01892404598(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tasvie_69_3_0466299490 == null) tasvie_69_3_0466299490 = register(new Tasvie_69_3_0466299490(box()).<Tasvie_69_3_0466299490>id("a_933099258").owner(AbstractTaskPlaceSendJobTemplate.this));
			}

			public class Tasvie_69_3_0466299490 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tasvie_69_3_0466299490(B box) {
					super(box);
					_value("Send order failure");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}
	}
}