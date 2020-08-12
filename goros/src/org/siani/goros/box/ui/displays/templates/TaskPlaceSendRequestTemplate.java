package org.siani.goros.box.ui.displays.templates;

import org.monet.metamodel.SendRequestActionProperty;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Task;
import org.siani.goros.box.GorosBox;

public class TaskPlaceSendRequestTemplate extends AbstractTaskPlaceSendRequestTemplate<GorosBox> {
    private Task task;
    private SendRequestActionProperty property;

    public TaskPlaceSendRequestTemplate(GorosBox box) {
        super(box);
    }

    public TaskPlaceSendRequestTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceSendRequestTemplate property(SendRequestActionProperty property) {
        this.property = property;
        return this;
    }

    @Override
    public void init() {
        super.init();
        sendingView.onShow(e -> refreshSendingView());
        failureView.onShow(e -> {
            failureView.retry.onExecute(e1 -> retry());
            refreshFailureView();
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        label.value(Language.getInstance().getModelResource(property.getLabel()));
        sendingView.visible(!task.isFailure());
        failureView.visible(task.isFailure());
        refreshView();
    }

    private void refreshView() {
        if (sendingView.isVisible()) refreshSendingView();
        else if (failureView.isVisible()) refreshFailureView();
    }

    private void refreshSendingView() {
    }

    private void refreshFailureView() {
    }

    private void retry() {
        task.getProcess().resume();
    }

}