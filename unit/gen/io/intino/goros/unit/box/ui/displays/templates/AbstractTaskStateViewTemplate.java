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

public abstract class AbstractTaskStateViewTemplate<B extends Box> extends io.intino.alexandria.ui.displays.components.Template<TemplateNotifier, java.lang.Void, B> {
	public TaskOrderTemplate tasvie_7_1_02074635646;
	public AssignMessage assignMessage;
	public Tasvie_11_1_01147767590 tasvie_11_1_01147767590;
	public TaskStateViewTemplate.Tasvie_11_1_01147767590. Date date;
	public TaskStateViewTemplate.Tasvie_11_1_01147767590. State state;
	public ServiceView serviceView;
	public TaskStateViewTemplate.ServiceView. Tasvie_16_2_1263042417 tasvie_16_2_1263042417;
	public JobView jobView;
	public TaskStateViewTemplate.JobView. JobMessage jobMessage;
	public ActivityView activityView;
	public TaskStateViewTemplate.ActivityView. StateDueView stateDueView;
	public TaskStateViewTemplate.ActivityView.StateDueView. StateDueMessage stateDueMessage;
	public TaskStateViewTemplate.ActivityView. DelegationView delegationView;
	public TaskPlaceDelegationTemplate delegationViewStamp;
	public TaskStateViewTemplate.ActivityView. SendJobView sendJobView;
	public TaskPlaceSendJobTemplate sendJobViewStamp;
	public TaskStateViewTemplate.ActivityView. LineView lineView;
	public TaskPlaceLineTemplate lineViewStamp;
	public TaskStateViewTemplate.ActivityView. EditionView editionView;
	public TaskPlaceEditionTemplate editionViewStamp;
	public TaskStateViewTemplate.ActivityView. EnrollView enrollView;
	public TaskPlaceEnrollTemplate enrollViewStamp;
	public TaskStateViewTemplate.ActivityView. WaitView waitView;
	public TaskPlaceWaitTemplate waitViewStamp;
	public TaskStateViewTemplate.ActivityView. SendRequestView sendRequestView;
	public TaskPlaceSendRequestTemplate sendRequestViewStamp;
	public TaskStateViewTemplate.ActivityView. SendResponseView sendResponseView;
	public TaskPlaceSendResponseTemplate sendResponseViewStamp;
	public Tasvie_32_1_02094438642 tasvie_32_1_02094438642;
	public TaskHistoryTemplate historyViewStamp;

    public AbstractTaskStateViewTemplate(B box) {
        super(box);
        id("taskStateViewTemplate");
    }

    @Override
	public void init() {
		super.init();
		if (tasvie_7_1_02074635646 == null) tasvie_7_1_02074635646 = register(new TaskOrderTemplate((UnitBox)box()).id("a1119020085"));
		if (assignMessage == null) assignMessage = register(new AssignMessage(box()).<AssignMessage>id("a322929797").owner(AbstractTaskStateViewTemplate.this));
		if (tasvie_11_1_01147767590 == null) tasvie_11_1_01147767590 = register(new Tasvie_11_1_01147767590(box()).<Tasvie_11_1_01147767590>id("a1433101018").owner(AbstractTaskStateViewTemplate.this));
		if (tasvie_11_1_01147767590 != null) date = tasvie_11_1_01147767590.date;
		if (tasvie_11_1_01147767590 != null) state = tasvie_11_1_01147767590.state;
		if (serviceView == null) serviceView = register(new ServiceView(box()).<ServiceView>id("a1791283879").owner(AbstractTaskStateViewTemplate.this));
		if (serviceView != null) tasvie_16_2_1263042417 = serviceView.tasvie_16_2_1263042417;
		if (jobView == null) jobView = register(new JobView(box()).<JobView>id("a394641967").owner(AbstractTaskStateViewTemplate.this));
		if (jobView != null) jobMessage = jobView.jobMessage;
		if (activityView == null) activityView = register(new ActivityView(box()).<ActivityView>id("a972666951").owner(AbstractTaskStateViewTemplate.this));
		if (activityView != null) stateDueView = activityView.stateDueView;
		if (stateDueView != null) stateDueMessage = activityView.stateDueView.stateDueMessage;
		if (activityView != null) delegationView = activityView.delegationView;
		if (delegationView != null) delegationViewStamp = activityView.delegationView.delegationViewStamp;
		if (activityView != null) sendJobView = activityView.sendJobView;
		if (sendJobView != null) sendJobViewStamp = activityView.sendJobView.sendJobViewStamp;
		if (activityView != null) lineView = activityView.lineView;
		if (lineView != null) lineViewStamp = activityView.lineView.lineViewStamp;
		if (activityView != null) editionView = activityView.editionView;
		if (editionView != null) editionViewStamp = activityView.editionView.editionViewStamp;
		if (activityView != null) enrollView = activityView.enrollView;
		if (enrollView != null) enrollViewStamp = activityView.enrollView.enrollViewStamp;
		if (activityView != null) waitView = activityView.waitView;
		if (waitView != null) waitViewStamp = activityView.waitView.waitViewStamp;
		if (activityView != null) sendRequestView = activityView.sendRequestView;
		if (sendRequestView != null) sendRequestViewStamp = activityView.sendRequestView.sendRequestViewStamp;
		if (activityView != null) sendResponseView = activityView.sendResponseView;
		if (sendResponseView != null) sendResponseViewStamp = activityView.sendResponseView.sendResponseViewStamp;
		if (tasvie_32_1_02094438642 == null) tasvie_32_1_02094438642 = register(new Tasvie_32_1_02094438642(box()).<Tasvie_32_1_02094438642>id("a903504054").owner(AbstractTaskStateViewTemplate.this));
		if (tasvie_32_1_02094438642 != null) historyViewStamp = tasvie_32_1_02094438642.historyViewStamp;
	}

	public class AssignMessage extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

		public AssignMessage(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
		}
	}

	public class Tasvie_11_1_01147767590 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskStateViewTemplate.Tasvie_11_1_01147767590. Date date;
		public TaskStateViewTemplate.Tasvie_11_1_01147767590. State state;

		public Tasvie_11_1_01147767590(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (date == null) date = register(new Date(box()).<Date>id("a_1005632251").owner(AbstractTaskStateViewTemplate.this));
			if (state == null) state = register(new State(box()).<State>id("a_1095427558").owner(AbstractTaskStateViewTemplate.this));
		}

		public class Date extends io.intino.alexandria.ui.displays.components.Date<io.intino.alexandria.ui.displays.notifiers.DateNotifier, B>  {

			public Date(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}

		public class State extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public State(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
			public State textColor(String color) {
			    this._textColor(color);
			    this._refreshHighlight();
			    return this;
			}

			public State backgroundColor(String color) {
			    this._backgroundColor(color);
			    this._refreshHighlight();
			    return this;
			}
		}
	}

	public class ServiceView extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskStateViewTemplate.ServiceView. Tasvie_16_2_1263042417 tasvie_16_2_1263042417;

		public ServiceView(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (tasvie_16_2_1263042417 == null) tasvie_16_2_1263042417 = register(new Tasvie_16_2_1263042417(box()).<Tasvie_16_2_1263042417>id("a1170147606").owner(AbstractTaskStateViewTemplate.this));
		}

		public class Tasvie_16_2_1263042417 extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public Tasvie_16_2_1263042417(B box) {
				super(box);
				_value("No pending tasks");
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class JobView extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskStateViewTemplate.JobView. JobMessage jobMessage;

		public JobView(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (jobMessage == null) jobMessage = register(new JobMessage(box()).<JobMessage>id("a_1919652454").owner(AbstractTaskStateViewTemplate.this));
		}

		public class JobMessage extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

			public JobMessage(B box) {
				super(box);
			}

			@Override
			public void init() {
				super.init();
			}
		}
	}

	public class ActivityView extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskStateViewTemplate.ActivityView. StateDueView stateDueView;
		public TaskStateViewTemplate.ActivityView. DelegationView delegationView;
		public TaskStateViewTemplate.ActivityView. SendJobView sendJobView;
		public TaskStateViewTemplate.ActivityView. LineView lineView;
		public TaskStateViewTemplate.ActivityView. EditionView editionView;
		public TaskStateViewTemplate.ActivityView. EnrollView enrollView;
		public TaskStateViewTemplate.ActivityView. WaitView waitView;
		public TaskStateViewTemplate.ActivityView. SendRequestView sendRequestView;
		public TaskStateViewTemplate.ActivityView. SendResponseView sendResponseView;

		public ActivityView(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (stateDueView == null) stateDueView = register(new StateDueView(box()).<StateDueView>id("a_1806338592").owner(AbstractTaskStateViewTemplate.this));
			if (delegationView == null) delegationView = register(new DelegationView(box()).<DelegationView>id("a_2058172699").owner(AbstractTaskStateViewTemplate.this));
			if (sendJobView == null) sendJobView = register(new SendJobView(box()).<SendJobView>id("a_721369246").owner(AbstractTaskStateViewTemplate.this));
			if (lineView == null) lineView = register(new LineView(box()).<LineView>id("a_1005380175").owner(AbstractTaskStateViewTemplate.this));
			if (editionView == null) editionView = register(new EditionView(box()).<EditionView>id("a_1115915893").owner(AbstractTaskStateViewTemplate.this));
			if (enrollView == null) enrollView = register(new EnrollView(box()).<EnrollView>id("a424114019").owner(AbstractTaskStateViewTemplate.this));
			if (waitView == null) waitView = register(new WaitView(box()).<WaitView>id("a_1948690766").owner(AbstractTaskStateViewTemplate.this));
			if (sendRequestView == null) sendRequestView = register(new SendRequestView(box()).<SendRequestView>id("a_209603276").owner(AbstractTaskStateViewTemplate.this));
			if (sendResponseView == null) sendResponseView = register(new SendResponseView(box()).<SendResponseView>id("a_2058079450").owner(AbstractTaskStateViewTemplate.this));
		}

		public class StateDueView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskStateViewTemplate.ActivityView.StateDueView. StateDueMessage stateDueMessage;

			public StateDueView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (stateDueMessage == null) stateDueMessage = register(new StateDueMessage(box()).<StateDueMessage>id("a_977198459").owner(AbstractTaskStateViewTemplate.this));
				if (stateDueMessage == null) stateDueMessage = activityView.stateDueView.stateDueMessage;
			}

			public class StateDueMessage extends io.intino.alexandria.ui.displays.components.Text<io.intino.alexandria.ui.displays.notifiers.TextNotifier, B>  {

				public StateDueMessage(B box) {
					super(box);
					_value("Task is finished");
				}

				@Override
				public void init() {
					super.init();
				}
			}
		}

		public class DelegationView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceDelegationTemplate delegationViewStamp;

			public DelegationView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (delegationViewStamp == null) delegationViewStamp = register(new TaskPlaceDelegationTemplate((UnitBox)box()).id("a_1313593476"));
				if (delegationViewStamp == null) delegationViewStamp = activityView.delegationView.delegationViewStamp;
			}
		}

		public class SendJobView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceSendJobTemplate sendJobViewStamp;

			public SendJobView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (sendJobViewStamp == null) sendJobViewStamp = register(new TaskPlaceSendJobTemplate((UnitBox)box()).id("a_958266426"));
				if (sendJobViewStamp == null) sendJobViewStamp = activityView.sendJobView.sendJobViewStamp;
			}
		}

		public class LineView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceLineTemplate lineViewStamp;

			public LineView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (lineViewStamp == null) lineViewStamp = register(new TaskPlaceLineTemplate((UnitBox)box()).id("a_1354284932"));
				if (lineViewStamp == null) lineViewStamp = activityView.lineView.lineViewStamp;
			}
		}

		public class EditionView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceEditionTemplate editionViewStamp;

			public EditionView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (editionViewStamp == null) editionViewStamp = register(new TaskPlaceEditionTemplate((UnitBox)box()).id("a_1621620684"));
				if (editionViewStamp == null) editionViewStamp = activityView.editionView.editionViewStamp;
			}
		}

		public class EnrollView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceEnrollTemplate enrollViewStamp;

			public EnrollView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (enrollViewStamp == null) enrollViewStamp = register(new TaskPlaceEnrollTemplate((UnitBox)box()).id("a_1912174276"));
				if (enrollViewStamp == null) enrollViewStamp = activityView.enrollView.enrollViewStamp;
			}
		}

		public class WaitView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceWaitTemplate waitViewStamp;

			public WaitView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (waitViewStamp == null) waitViewStamp = register(new TaskPlaceWaitTemplate((UnitBox)box()).id("a50029404"));
				if (waitViewStamp == null) waitViewStamp = activityView.waitView.waitViewStamp;
			}
		}

		public class SendRequestView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceSendRequestTemplate sendRequestViewStamp;

			public SendRequestView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (sendRequestViewStamp == null) sendRequestViewStamp = register(new TaskPlaceSendRequestTemplate((UnitBox)box()).id("a_836335582"));
				if (sendRequestViewStamp == null) sendRequestViewStamp = activityView.sendRequestView.sendRequestViewStamp;
			}
		}

		public class SendResponseView extends io.intino.alexandria.ui.displays.components.BlockConditional<io.intino.alexandria.ui.displays.notifiers.BlockConditionalNotifier, B>  {
			public TaskPlaceSendResponseTemplate sendResponseViewStamp;

			public SendResponseView(B box) {
				super(box);
			}

			@Override
			public void initConditional() {
				super.init();
				if (sendResponseViewStamp == null) sendResponseViewStamp = register(new TaskPlaceSendResponseTemplate((UnitBox)box()).id("a738927068"));
				if (sendResponseViewStamp == null) sendResponseViewStamp = activityView.sendResponseView.sendResponseViewStamp;
			}
		}
	}

	public class Tasvie_32_1_02094438642 extends io.intino.alexandria.ui.displays.components.Block<io.intino.alexandria.ui.displays.notifiers.BlockNotifier, B>  {
		public TaskHistoryTemplate historyViewStamp;

		public Tasvie_32_1_02094438642(B box) {
			super(box);
		}

		@Override
		public void init() {
			super.init();
			if (historyViewStamp == null) historyViewStamp = register(new TaskHistoryTemplate((UnitBox)box()).id("a_1069521374"));
		}
	}
}