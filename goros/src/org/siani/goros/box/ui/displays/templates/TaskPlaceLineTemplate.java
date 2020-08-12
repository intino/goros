package org.siani.goros.box.ui.displays.templates;

import org.monet.metamodel.LineActionProperty;
import org.monet.metamodel.LineActionPropertyBase;
import org.monet.metamodel.internal.Lock;
import org.monet.space.kernel.machines.ttm.behavior.ProcessBehavior;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Task;
import org.siani.goros.box.GorosBox;
import org.siani.goros.util.DisplayHelper;
import org.siani.goros.util.Formatters;

import java.time.Instant;
import java.util.function.Consumer;

public class TaskPlaceLineTemplate extends AbstractTaskPlaceLineTemplate<GorosBox> {
    private Task task;
    private LineActionProperty property;
    private Consumer<LineActionProperty> resumeListener;

    private static final String DueDateMessage = "%s will be selected if no option is checked before %s";

    public TaskPlaceLineTemplate(GorosBox box) {
        super(box);
    }

    public TaskPlaceLineTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceLineTemplate property(LineActionProperty property) {
        this.property = property;
        return this;
    }

    public TaskPlaceLineTemplate onResume(Consumer<LineActionProperty> listener) {
        this.resumeListener = listener;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        label.value(Language.getInstance().getModelResource(property.getLabel()));
        refreshTimeoutMessage();
        refreshStops();
    }

    private void refreshTimeoutMessage() {
        Long dueStamp = task.getProcess().getTimerDue(property.getCode());
        boolean dueDateDefined = dueStamp != -1;
        timeoutMessage.visible(dueDateDefined);
        if (!dueDateDefined) return;
        Language language = Language.getInstance();
        timeoutMessage.value(String.format(DueDateMessage, language.getModelResource(property.getLabel()), Formatters.shortDate(Instant.ofEpochMilli(dueStamp))));
    }

    private void refreshStops() {
        loadingStops.visible(true);
        stopsBlock.visible(false);
        stops.clear();
        property.getStopList().stream().filter(s -> !s.isHidden()).forEach(stop -> fill(stop, stops.add()));
        stopsBlock.visible(true);
        loadingStops.visible(false);
    }

    private void fill(LineActionPropertyBase.LineStopProperty stop, TaskPlaceLineStopTemplate view) {
        view.task(task);
        view.stop(stop);
        view.confirmText(translate(DisplayHelper.requireConfirmationMessage(property)));
        view.onSelect(e -> select(stop));
        view.refresh();
    }

    private void select(LineActionPropertyBase.LineStopProperty stop) {
        Lock lock = new Lock(task.getProcess().getCurrentPlace().getCode(), stop.getCode());
        ProcessBehavior process = task.getProcess();
        process.unlock(lock);
        process.resume();
        resumeListener.accept(property);
    }

}