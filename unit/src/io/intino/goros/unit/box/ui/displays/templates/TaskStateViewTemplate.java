package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.metamodel.*;
import org.monet.space.kernel.machines.ttm.behavior.ProcessBehavior;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.User;
import io.intino.goros.unit.box.ui.DisplayProvider;

public class TaskStateViewTemplate extends AbstractTaskStateViewTemplate<UnitBox> {
    private Task task;
    private DisplayProvider displayProvider;

    public TaskStateViewTemplate(UnitBox box) {
        super(box);
    }

    public TaskStateViewTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskStateViewTemplate displayProvider(DisplayProvider provider) {
        this.displayProvider = provider;
        return this;
    }

    @Override
    public void init() {
        super.init();
        box().notifier().onTaskStateChange(this, this::update);
    }

    @Override
    public void remove() {
        super.remove();
        box().notifier().unTaskStateChange(this);
    }

    @Override
    public void refresh() {
        super.refresh();
        date.value(task.getInternalUpdateDate().toInstant());
        refreshAssignMessage();
        refreshState();
        refreshStateDueView();
        refreshServiceView();
        refreshActivityView();
        refreshJobView();
        refreshHistoryView();
    }

    private void refreshAssignMessage() {
        User owner = task.getOwner();
        assignMessage.value(owner != null ? String.format(translate("Task is assigned to %s"), owner.getInfo().getFullname()) : translate("Task is not assigned"));
    }

    private void refreshState() {
        state.value(translate(TaskHelper.state(task)));
        state.backgroundColor(TaskHelper.stateColor(task));
    }

    private void refreshStateDueView() {
        boolean dueState = task.isFinished() || task.isAborted() || task.isExpired();
        stateDueView.visible(dueState);
        stateDueView.onShow(e -> stateDueView.stateDueMessage.value(translate("Task is") + " " + translate(TaskHelper.state(task)).toLowerCase()));
    }

    private void refreshServiceView() {
        serviceView.visible(task.isService());
    }

    private void refreshActivityView() {
        activityView.visible(task.isActivity());
        if (!task.isActivity()) return;
        refreshPlaceView();
    }

    private void refreshJobView() {
        jobView.visible(task.isJob());
        jobMessage.value(jobMessageFor(task));
    }

    private void refreshPlaceView() {
        ProcessBehavior process = task.getProcess();
        PlaceProperty property = process.getCurrentPlace();
        refreshDelegationView(property);
        refreshSendJobView(property);
        refreshLineView(property);
        refreshEditionView(property);
        refreshEnrollView(property);
        refreshWaitView(property);
        refreshSendRequestView(property);
        refreshSendResponseView(property);
    }

    private void refreshHistoryView() {
        historyViewStamp.task(task);
        historyViewStamp.refresh();
    }

    private void refreshDelegationView(PlaceProperty property) {
        DelegationActionProperty action = property.getDelegationActionProperty();
        delegationView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        delegationView.delegationViewStamp.task(task);
        delegationView.delegationViewStamp.property(action);
        delegationView.delegationViewStamp.displayProvider(displayProvider);
        delegationView.delegationViewStamp.refresh();
    }

    private void refreshSendJobView(PlaceProperty property) {
        SendJobActionProperty action = property.getSendJobActionProperty();
        sendJobView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        sendJobView.sendJobViewStamp.task(task);
        sendJobView.sendJobViewStamp.property(action);
        sendJobView.sendJobViewStamp.displayProvider(displayProvider);
        sendJobView.sendJobViewStamp.refresh();
    }

    private void refreshLineView(PlaceProperty property) {
        LineActionProperty action = property.getLineActionProperty();
        lineView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        lineView.lineViewStamp.task(task);
        lineView.lineViewStamp.property(action);
        lineView.lineViewStamp.onResume(e -> refresh());
        lineView.lineViewStamp.refresh();
    }

    private void refreshEditionView(PlaceProperty property) {
        EditionActionProperty action = property.getEditionActionProperty();
        editionView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        editionView.editionViewStamp.task(task);
        editionView.editionViewStamp.property(action);
        editionView.editionViewStamp.displayProvider(displayProvider);
        editionView.editionViewStamp.refresh();
    }

    private void refreshEnrollView(PlaceProperty property) {
        EnrollActionProperty action = property.getEnrollActionProperty();
        enrollView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        enrollView.enrollViewStamp.task(task);
        enrollView.enrollViewStamp.property(action);
        enrollView.enrollViewStamp.refresh();
    }

    private void refreshWaitView(PlaceProperty property) {
        WaitActionProperty action = property.getWaitActionProperty();
        waitView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        waitView.waitViewStamp.task(task);
        waitView.waitViewStamp.property(action);
        waitView.waitViewStamp.refresh();
    }

    private void refreshSendRequestView(PlaceProperty property) {
        SendRequestActionProperty action = property.getSendRequestActionProperty();
        sendRequestView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        sendRequestView.sendRequestViewStamp.task(task);
        sendRequestView.sendRequestViewStamp.property(action);
        sendRequestView.sendRequestViewStamp.refresh();
    }

    private void refreshSendResponseView(PlaceProperty property) {
        SendResponseActionProperty action = property.getSendResponseActionProperty();
        sendResponseView.visible(action != null && TaskHelper.isAlive(task));
        if (action == null) return;
        sendResponseView.sendResponseViewStamp.task(task);
        sendResponseView.sendResponseViewStamp.property(action);
        sendResponseView.sendResponseViewStamp.refresh();
    }

    private void update(Task task) {
        if (this.task == null || !this.task.getId().equals(task.getId())) return;
        task(task);
        refresh();
    }

    private String jobMessageFor(Task task) {
        if (task.isFinished()) return translate("Job is finished");
        else if (task.isAborted()) return translate("Job is aborted");
        else if (task.getOwner() != null) return translate("::owner:: is doing job").replace("::owner::", task.getOwner().getInfo().getFullname());
        else return translate("Job is pending to be assigned to user");
    }

}