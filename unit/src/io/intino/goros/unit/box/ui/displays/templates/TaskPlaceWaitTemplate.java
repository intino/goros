package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.DisplayHelper;
import io.intino.goros.unit.util.Formatters;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.metamodel.WaitActionProperty;
import org.monet.metamodel.internal.Time;
import org.monet.space.kernel.machines.ttm.behavior.ProcessBehavior;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Task;

import java.time.Instant;
import java.util.Date;

public class TaskPlaceWaitTemplate extends AbstractTaskPlaceWaitTemplate<UnitBox> {
    private Task task;
    private WaitActionProperty property;

    public TaskPlaceWaitTemplate(UnitBox box) {
        super(box);
    }

    public TaskPlaceWaitTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceWaitTemplate property(WaitActionProperty property) {
        this.property = property;
        return this;
    }

    @Override
    public void init() {
        super.init();
        plusHour.onExecute(e -> plusHour());
        plusDay.onExecute(e -> plusDay());
        plusMonth.onExecute(e -> plusMonth());
        plusYear.onExecute(e -> plusYear());
        freePlace.onExecute(e -> freePlace());
    }

    @Override
    public void refresh() {
        super.refresh();
        label.value(Language.getInstance().getModelResource(property.getLabel()));
        long dueDate = dueDate();
        refreshDescription(dueDate);
        refreshOptions(dueDate);
    }

    private void refreshDescription(long dueDate) {
        description.value(dueDate != -1 ? translate("Due date is") + " " + Formatters.shortDate(Instant.ofEpochMilli(dueDate)) : translate("Due date not defined"));
    }

    private void refreshOptions(long dueDate) {
        plusHour.title(dueDate != -1 ? translate("pospone one hour") : translate("define for next hour"));
        plusHour.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
        plusDay.title(dueDate != -1 ? translate("pospone one day") : translate("define for next day"));
        plusDay.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
        plusMonth.title(dueDate != -1 ? translate("pospone one month") : translate("define for next month"));
        plusMonth.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
        plusYear.title(dueDate != -1 ? translate("pospone one year") : translate("define for next year"));
        plusYear.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
        freePlace.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
    }

    private void plusHour() {
        plusHour.readonly(true);
        setup(plusMillis(TaskHelper.hoursToMillis(1)));
        plusHour.readonly(false);
    }

    private void plusDay() {
        plusDay.readonly(true);
        setup(plusMillis(TaskHelper.daysToMillis(1)));
        plusDay.readonly(false);
    }

    private void plusMonth() {
        plusMonth.readonly(true);
        setup(plusMillis(TaskHelper.monthsToMillis(1)));
        plusMonth.readonly(false);
    }

    private void plusYear() {
        plusYear.readonly(true);
        setup(plusMillis(TaskHelper.yearsToMillis(1)));
        plusYear.readonly(false);
    }

    private long plusMillis(long millis) {
        long timer = dueDate();
        if (timer == -1) timer = Instant.now().toEpochMilli();
        return timer + millis;
    }

    private void freePlace() {
        freePlace.readonly(true);
        setup(0);
        freePlace.readonly(false);
    }

    private long dueDate() {
        ProcessBehavior process = task.getProcess();
        return process.getTimerDue(process.getCurrentPlace().getCode());
    }

    private void setup(long newTimer) {
        long currentTimestamp = Instant.now().toEpochMilli();
        long timeout = newTimer - currentTimestamp;
        task.getProcess().setupWaitAction(new Date(currentTimestamp), new Time(timeout > 0 ? timeout : 0));
        refresh();
    }

}