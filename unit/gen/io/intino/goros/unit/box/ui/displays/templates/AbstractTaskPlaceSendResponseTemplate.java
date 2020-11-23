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

public abstract class AbstractTaskPlaceSendResponseTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public Label label;
	public SendingView sendingView;
	public TaskPlaceSendResponseTemplate.SendingView. Tasvie_112_2_01131215905 tasvie_112_2_01131215905;
	public TaskPlaceSendResponseTemplate.SendingView. Tasvie_113_2_0341219140 tasvie_113_2_0341219140;
	public FailureView failureView;
	public TaskPlaceSendResponseTemplate.FailureView. Tasvie_115_2_0527834239 tasvie_115_2_0527834239;
	public TaskPlaceSendResponseTemplate.FailureView. Retry retry;

    public AbstractTaskPlaceSendResponseTemplate(B box) {
        super(box);
        id("taskPlaceSendResponseTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (label == null) label = register(new Label(box()).<Label>id("a_789097829").owner(AbstractTaskPlaceSendResponseTemplate.this));
		if (sendingView == null) sendingView = register(new SendingView(box()).<SendingView>id("a1403578246").owner(AbstractTaskPlaceSendResponseTemplate.this));
		if (sendingView != null) tasvie_112_2_01131215905 = sendingView.tasvie_112_2_01131215905;
		if (sendingView != null) tasvie_113_2_0341219140 = sendingView.tasvie_113_2_0341219140;
		if (failureView == null) failureView = register(new FailureView(box()).<FailureView>id("a_837073482").owner(AbstractTaskPlaceSendResponseTemplate.this));
		if (failureView != null) tasvie_115_2_0527834239 = failureView.tasvie_115_2_0527834239;
		if (failureView != null) retry = failureView.retry;
	}

	public class Label extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public Label(B box) {
			super(box);
			_value("SendResponse");
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class SendingView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendResponseTemplate.SendingView. Tasvie_112_2_01131215905 tasvie_112_2_01131215905;
		public TaskPlaceSendResponseTemplate.SendingView. Tasvie_113_2_0341219140 tasvie_113_2_0341219140;

		public SendingView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_112_2_01131215905 == null) tasvie_112_2_01131215905 = register(new Tasvie_112_2_01131215905(box()).<Tasvie_112_2_01131215905>id("a_16325534").owner(AbstractTaskPlaceSendResponseTemplate.this));
			if (tasvie_113_2_0341219140 == null) tasvie_113_2_0341219140 = register(new Tasvie_113_2_0341219140(box()).<Tasvie_113_2_0341219140>id("a_1886556570").owner(AbstractTaskPlaceSendResponseTemplate.this));
			if (tasvie_112_2_01131215905 == null) tasvie_112_2_01131215905 = sendingView.tasvie_112_2_01131215905;
			if (tasvie_113_2_0341219140 == null) tasvie_113_2_0341219140 = sendingView.tasvie_113_2_0341219140;
		}

		public class Tasvie_112_2_01131215905 extends io.intino.alexandria.ui.displays.components.Spinner<io.intino.alexandria.ui.displays.notifiers.SpinnerNotifier, B>  {

			public Tasvie_112_2_01131215905(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class Tasvie_113_2_0341219140 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_113_2_0341219140(B box) {
				super(box);
				_value("Sending response. Please, wait...");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class FailureView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
		public TaskPlaceSendResponseTemplate.FailureView. Tasvie_115_2_0527834239 tasvie_115_2_0527834239;
		public TaskPlaceSendResponseTemplate.FailureView. Retry retry;

		public FailureView(B box) {
			super(box);
		}

		@Override
		public void initConditional() {
			super.init();
			if (tasvie_115_2_0527834239 == null) tasvie_115_2_0527834239 = register(new Tasvie_115_2_0527834239(box()).<Tasvie_115_2_0527834239>id("a1033025578").owner(AbstractTaskPlaceSendResponseTemplate.this));
			if (retry == null) retry = register(new Retry(box()).<Retry>id("a_535549217").owner(AbstractTaskPlaceSendResponseTemplate.this));
			if (tasvie_115_2_0527834239 == null) tasvie_115_2_0527834239 = failureView.tasvie_115_2_0527834239;
			if (retry == null) retry = failureView.retry;
		}

		public class Tasvie_115_2_0527834239 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_115_2_0527834239(B box) {
				super(box);
				_value("There was an attempt to send a response that failed");
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