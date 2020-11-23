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

public abstract class AbstractTaskPlaceSendRequestTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public SendingView sendingView;
	public TaskPlaceSendRequestTemplate.SendingView. Tasvie_103_2_01131215905 tasvie_103_2_01131215905;
	public TaskPlaceSendRequestTemplate.SendingView. Tasvie_104_2_01252557236 tasvie_104_2_01252557236;
	public FailureView failureView;
	public TaskPlaceSendRequestTemplate.FailureView. Tasvie_106_2_1657987283 tasvie_106_2_1657987283;
	public TaskPlaceSendRequestTemplate.FailureView. Retry retry;

    public AbstractTaskPlaceSendRequestTemplate(B box) {
        super(box);
        id("taskPlaceSendRequestTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a1429252339").owner(AbstractTaskPlaceSendRequestTemplate.this));
		if (sendingView == null) sendingView = register(new SendingView(box()).<SendingView>id("a_1876026402").owner(AbstractTaskPlaceSendRequestTemplate.this));
		if (sendingView != null) tasvie_103_2_01131215905 = sendingView.tasvie_103_2_01131215905;
		if (sendingView != null) tasvie_104_2_01252557236 = sendingView.tasvie_104_2_01252557236;
		if (failureView == null) failureView = register(new FailureView(box()).<FailureView>id("a178289166").owner(AbstractTaskPlaceSendRequestTemplate.this));
		if (failureView != null) tasvie_106_2_1657987283 = failureView.tasvie_106_2_1657987283;
		if (failureView != null) retry = failureView.retry;
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

	public class SendingView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendRequestTemplate.SendingView. Tasvie_103_2_01131215905 tasvie_103_2_01131215905;
		public TaskPlaceSendRequestTemplate.SendingView. Tasvie_104_2_01252557236 tasvie_104_2_01252557236;

		public SendingView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_103_2_01131215905 == null) tasvie_103_2_01131215905 = register(new Tasvie_103_2_01131215905(box()).<Tasvie_103_2_01131215905>id("a_1308471444").owner(AbstractTaskPlaceSendRequestTemplate.this));
			if (tasvie_104_2_01252557236 == null) tasvie_104_2_01252557236 = register(new Tasvie_104_2_01252557236(box()).<Tasvie_104_2_01252557236>id("a_1440582557").owner(AbstractTaskPlaceSendRequestTemplate.this));
			if (tasvie_103_2_01131215905 == null) tasvie_103_2_01131215905 = sendingView.tasvie_103_2_01131215905;
			if (tasvie_104_2_01252557236 == null) tasvie_104_2_01252557236 = sendingView.tasvie_104_2_01252557236;
		}

		public class Tasvie_103_2_01131215905 extends io.intino.alexandria.ui.displays.components.Spinner<io.intino.alexandria.ui.displays.notifiers.SpinnerNotifier, B>  {

			public Tasvie_103_2_01131215905(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Tasvie_104_2_01252557236 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_104_2_01252557236(B box) {
				super(box);
				_value("Sending request. Please, wait...");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class FailureView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendRequestTemplate.FailureView. Tasvie_106_2_1657987283 tasvie_106_2_1657987283;
		public TaskPlaceSendRequestTemplate.FailureView. Retry retry;

		public FailureView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_106_2_1657987283 == null) tasvie_106_2_1657987283 = register(new Tasvie_106_2_1657987283(box()).<Tasvie_106_2_1657987283>id("a92722803").owner(AbstractTaskPlaceSendRequestTemplate.this));
			if (retry == null) retry = register(new Retry(box()).<Retry>id("a_670646985").owner(AbstractTaskPlaceSendRequestTemplate.this));
			if (tasvie_106_2_1657987283 == null) tasvie_106_2_1657987283 = failureView.tasvie_106_2_1657987283;
			if (retry == null) retry = failureView.retry;
		}

		public class Tasvie_106_2_1657987283 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_106_2_1657987283(B box) {
				super(box);
				_value("There was an attempt to send a request that failed");
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Retry extends io.intino.alexandria.ui.displays.components.Action<io.intino.alexandria.ui.displays.notifiers.ActionNotifier, B>  {

			public Retry(B box) {
				super(box);
				_title("Retry");
				_mode(io.intino.alexandria.ui.displays.components.Actionable.Mode.valueOf("Link"));
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}
}