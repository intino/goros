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

public abstract class AbstractTaskPlaceDelegationTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public WaitingView waitingView;
	public TaskPlaceDelegationTemplate.WaitingView. Tasvie_37_2_01131215905 tasvie_37_2_01131215905;
	public TaskPlaceDelegationTemplate.WaitingView. Tasvie_38_2_01208617754 tasvie_38_2_01208617754;
	public PendingView pendingView;
	public TaskPlaceDelegationTemplate.PendingView. PendingMessage pendingMessage;
	public TaskPlaceDelegationTemplate.PendingView. OpenRoles openRoles;
	public TaskPlaceDelegationTemplate.PendingView. Roles roles;
	public TaskPlaceDelegationTemplate.PendingView. SetupBlock setupBlock;
	public TaskPlaceDelegationTemplate.PendingView.SetupBlock. SetupFrame setupFrame;
	public TaskPlaceDelegationTemplate.PendingView.SetupBlock. SetupToolbar setupToolbar;
	public TaskPlaceDelegationTemplate.PendingView.SetupBlock.SetupToolbar. SolveSetup solveSetup;
	public FailureView failureView;
	public TaskPlaceDelegationTemplate.FailureView. Tasvie_47_2_0678513474 tasvie_47_2_0678513474;
	public TaskPlaceDelegationTemplate.FailureView.Tasvie_47_2_0678513474. Tasvie_48_3_061622241 tasvie_48_3_061622241;
	public TaskPlaceDelegationTemplate.FailureView.Tasvie_47_2_0678513474. FailureDate failureDate;

    public AbstractTaskPlaceDelegationTemplate(B box) {
        super(box);
        id("taskPlaceDelegationTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a711828058").owner(AbstractTaskPlaceDelegationTemplate.this));
		if (waitingView == null) waitingView = register(new WaitingView(box()).<WaitingView>id("a_606612104").owner(AbstractTaskPlaceDelegationTemplate.this));
		if (waitingView != null) tasvie_37_2_01131215905 = waitingView.tasvie_37_2_01131215905;
		if (waitingView != null) tasvie_38_2_01208617754 = waitingView.tasvie_38_2_01208617754;
		if (pendingView == null) pendingView = register(new PendingView(box()).<PendingView>id("a33559490").owner(AbstractTaskPlaceDelegationTemplate.this));
		if (pendingView != null) pendingMessage = pendingView.pendingMessage;
		if (pendingView != null) openRoles = pendingView.openRoles;
		if (pendingView != null) roles = pendingView.roles;
		if (pendingView != null) setupBlock = pendingView.setupBlock;
		if (setupBlock != null) setupFrame = pendingView.setupBlock.setupFrame;
		if (setupBlock != null) setupToolbar = pendingView.setupBlock.setupToolbar;
		if (setupToolbar != null) solveSetup = pendingView.setupBlock.setupToolbar.solveSetup;
		if (failureView == null) failureView = register(new FailureView(box()).<FailureView>id("a991988277").owner(AbstractTaskPlaceDelegationTemplate.this));
		if (failureView != null) tasvie_47_2_0678513474 = failureView.tasvie_47_2_0678513474;
		if (tasvie_47_2_0678513474 != null) tasvie_48_3_061622241 = failureView.tasvie_47_2_0678513474.tasvie_48_3_061622241;
		if (tasvie_47_2_0678513474 != null) failureDate = failureView.tasvie_47_2_0678513474.failureDate;
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
		public TaskPlaceDelegationTemplate.WaitingView. Tasvie_37_2_01131215905 tasvie_37_2_01131215905;
		public TaskPlaceDelegationTemplate.WaitingView. Tasvie_38_2_01208617754 tasvie_38_2_01208617754;

		public WaitingView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_37_2_01131215905 == null) tasvie_37_2_01131215905 = register(new Tasvie_37_2_01131215905(box()).<Tasvie_37_2_01131215905>id("a_970468134").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (tasvie_38_2_01208617754 == null) tasvie_38_2_01208617754 = register(new Tasvie_38_2_01208617754(box()).<Tasvie_38_2_01208617754>id("a_171701608").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (tasvie_37_2_01131215905 == null) tasvie_37_2_01131215905 = waitingView.tasvie_37_2_01131215905;
			if (tasvie_38_2_01208617754 == null) tasvie_38_2_01208617754 = waitingView.tasvie_38_2_01208617754;
		}

		public class Tasvie_37_2_01131215905 extends io.intino.alexandria.ui.displays.components.Spinner<io.intino.alexandria.ui.displays.notifiers.SpinnerNotifier, B>  {

			public Tasvie_37_2_01131215905(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Tasvie_38_2_01208617754 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_38_2_01208617754(B box) {
				super(box);
				_value("Sending to selected provider...");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class PendingView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceDelegationTemplate.PendingView. PendingMessage pendingMessage;
		public TaskPlaceDelegationTemplate.PendingView. OpenRoles openRoles;
		public TaskPlaceDelegationTemplate.PendingView. Roles roles;
		public TaskPlaceDelegationTemplate.PendingView. SetupBlock setupBlock;

		public PendingView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (pendingMessage == null) pendingMessage = register(new PendingMessage(box()).<PendingMessage>id("a_1944681331").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (openRoles == null) openRoles = register(new OpenRoles(box()).<OpenRoles>id("a1397135958").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (roles == null) roles = register(new Roles((UnitBox)box()).<Roles>id("a1467329536").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (setupBlock == null) setupBlock = register(new SetupBlock(box()).<SetupBlock>id("a1089885357").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (pendingMessage == null) pendingMessage = pendingView.pendingMessage;
			if (openRoles == null) openRoles = pendingView.openRoles;
			if (roles == null) roles = pendingView.roles;
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

		public class SetupBlock extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskPlaceDelegationTemplate.PendingView.SetupBlock. SetupFrame setupFrame;
			public TaskPlaceDelegationTemplate.PendingView.SetupBlock. SetupToolbar setupToolbar;

			public SetupBlock(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (setupFrame == null) setupFrame = register(new SetupFrame(box()).<SetupFrame>id("a_1511667774").owner(AbstractTaskPlaceDelegationTemplate.this));
				if (setupToolbar == null) setupToolbar = register(new SetupToolbar(box()).<SetupToolbar>id("a_1546622832").owner(AbstractTaskPlaceDelegationTemplate.this));
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
				public TaskPlaceDelegationTemplate.PendingView.SetupBlock.SetupToolbar. SolveSetup solveSetup;

				public SetupToolbar(B box) {
					super(box);
				}

				@Override
				public void init() {
					super.init();
					if (solveSetup == null) solveSetup = register(new SolveSetup(box()).<SolveSetup>id("a_2029198195").owner(AbstractTaskPlaceDelegationTemplate.this));
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
		public TaskPlaceDelegationTemplate.FailureView. Tasvie_47_2_0678513474 tasvie_47_2_0678513474;

		public FailureView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_47_2_0678513474 == null) tasvie_47_2_0678513474 = register(new Tasvie_47_2_0678513474(box()).<Tasvie_47_2_0678513474>id("a_369507359").owner(AbstractTaskPlaceDelegationTemplate.this));
			if (tasvie_48_3_061622241 == null) tasvie_48_3_061622241 = failureView.tasvie_47_2_0678513474.tasvie_48_3_061622241;
			if (failureDate == null) failureDate = failureView.tasvie_47_2_0678513474.failureDate;
		}

		public class Tasvie_47_2_0678513474 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
			public TaskPlaceDelegationTemplate.FailureView.Tasvie_47_2_0678513474. Tasvie_48_3_061622241 tasvie_48_3_061622241;
			public TaskPlaceDelegationTemplate.FailureView.Tasvie_47_2_0678513474. FailureDate failureDate;

			public Tasvie_47_2_0678513474(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
				if (tasvie_48_3_061622241 == null) tasvie_48_3_061622241 = register(new Tasvie_48_3_061622241(box()).<Tasvie_48_3_061622241>id("a1921835005").owner(AbstractTaskPlaceDelegationTemplate.this));
				if (failureDate == null) failureDate = register(new FailureDate(box()).<FailureDate>id("a1532897477").owner(AbstractTaskPlaceDelegationTemplate.this));
			}

			public class Tasvie_48_3_061622241 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public Tasvie_48_3_061622241(B box) {
					super(box);
					_value("Trying to send order. Last sent request was at");
				}

				@Override
				public void init() {
					super.init();
				}
			}

			public class FailureDate extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, B>  {

				public FailureDate(B box) {
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