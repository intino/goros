package io.intino.goros.box.ui.displays.templates;

import org.monet.metamodel.SendResponseActionProperty;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Task;
import io.intino.goros.box.GorosBox;

public class TaskPlaceSendResponseTemplate extends AbstractTaskPlaceSendResponseTemplate<GorosBox> {
    private Task task;
    private SendResponseActionProperty property;

    public TaskPlaceSendResponseTemplate(GorosBox box) {
        super(box);
    }

    public TaskPlaceSendResponseTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceSendResponseTemplate property(SendResponseActionProperty property) {
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