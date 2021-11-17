package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.TaskListDatasource;
import io.intino.goros.unit.box.ui.displays.rows.TasksTableRow;
import io.intino.goros.unit.util.DisplayHelper;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.space.kernel.model.Task;

public class TasksTableCatalog extends AbstractTasksTableCatalog<UnitBox> {
    private boolean readonly = true;
    private Task selected = null;

    public TasksTableCatalog(UnitBox box) {
        super(box);
    }

    public TasksTableCatalog source(TaskListDatasource source) {
        tasksTable.source(source);
        return this;
    }

    public TasksTableCatalog readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public void select(Task task) {
        DisplayHelper.executeDelayed(b -> tasksTable.select(tasksTable.findItem(t -> ((Task)t).getId().equals(task.getId()))), 800);
    }

    public void selectSorting(String sorting, String mode) {
        tasksTable.sortings(sorting != null ? java.util.Collections.singletonList(io.intino.goros.unit.util.NodeHelper.sortingOf(sorting, mode)) : java.util.Collections.emptyList());
    }

    public void refresh(Task task) {
        tasksTable.refresh(tasksTable.findItem(t -> ((Task)t).getId().equals(task.getId())), task);
    }

    @Override
    public void init() {
        super.init();
        tasksTable.onAddItem(this::refreshTask);
        taskComments.onOpen(e -> refreshTaskComments());
    }

    private void refreshTask(io.intino.alexandria.ui.displays.events.AddItemEvent event) {
        refreshTask(event.item(), event.component());
    }

    private void refreshTask(Task<?> task, TasksTableRow display) {
        String comments = task.getComments();
        display.tasksTableLabelItem.label.value(task.getLabel());
        display.tasksTableLabelItem.state.value(translate(TaskHelper.state(task)));
        display.tasksTableLabelItem.state.backgroundColor(TaskHelper.stateColor(task));
        display.tasksTableOwnerItem.owner.value(task.getOwner() != null ? task.getOwner().getInfo().getFullname() : null);
        display.tasksTableCountMessagesItem.countMessages.value(task.getNewMessagesCount());
        display.tasksTableCreateDateItem.createDate.value(task.getInternalCreateDate().toInstant());
        display.tasksTableUpdateDateItem.updateDate.value(task.getInternalUpdateDate().toInstant());
        display.tasksTableOperationsItem.commentsTrigger.readonly(comments == null || comments.isEmpty());
        display.tasksTableOperationsItem.commentsTrigger.bindTo(taskComments);
        display.tasksTableOperationsItem.commentsTrigger.onOpen(e -> refreshTaskComments(task));
        display.tasksTableOperationsItem.urgent.onExecute(e -> toggleUrgent(task, display));
        display.tasksTableOperationsItem.urgent.color(task.isUrgent() ? "#F44335" : "#ddd");
    }

    private void refreshTaskComments(Task<?> task) {
        selected = task;
        refreshTaskComments();
    }

    private void refreshTaskComments() {
        if (selected == null) return;
        taskComments.comments.content(selected.getComments().replace("\n", "<br/>"));
        taskComments.comments.refresh();
    }

    private void toggleUrgent(Task<?> task, TasksTableRow display) {
        task.setUrgent(!task.isUrgent());
        LayerHelper.taskLayer().saveTaskUrgency(task);
        refreshTask(task, display);
    }

    @Override
    public void refresh() {
        super.refresh();
        tasksTable.reload();
    }

}