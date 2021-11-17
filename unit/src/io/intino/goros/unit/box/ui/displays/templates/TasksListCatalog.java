package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.TaskListDatasource;
import io.intino.goros.unit.box.ui.displays.items.TasksListItem;
import io.intino.goros.unit.util.DisplayHelper;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.space.kernel.model.Task;

public class TasksListCatalog extends AbstractTasksListCatalog<UnitBox> {
    private boolean readonly = true;
    private Task selected = null;

    public TasksListCatalog(UnitBox box) {
        super(box);
    }

    public TasksListCatalog source(TaskListDatasource source) {
        tasksList.source(source);
        return this;
    }

    public TasksListCatalog readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public void select(Task task) {
        DisplayHelper.executeDelayed(b -> tasksList.select(tasksList.findItem(t -> ((Task)t).getId().equals(task.getId()))), 800);
    }

    public void selectSorting(String sorting, String mode) {
        tasksList.sortings(sorting != null ? java.util.Collections.singletonList(io.intino.goros.unit.util.NodeHelper.sortingOf(sorting, mode)) : java.util.Collections.emptyList());
    }

    public void refresh(Task task) {
        tasksList.refresh(tasksList.findItem(t -> ((Task)t).getId().equals(task.getId())), task);
    }

    @Override
    public void init() {
        super.init();
        tasksList.onAddItem(this::refreshTask);
        taskComments.onOpen(e -> refreshTaskComments());
    }

    private void refreshTask(io.intino.alexandria.ui.displays.events.AddItemEvent event) {
        refreshTask(event.item(), event.component());
    }

    private void refreshTask(Task<?> task, TasksListItem display) {
        String comments = task.getComments();
        display.label.value(task.getLabel());
        display.state.value(translate(TaskHelper.state(task)));
        display.state.backgroundColor(TaskHelper.stateColor(task));
        display.owner.value(task.getOwner() != null ? task.getOwner().getInfo().getFullname() : null);
        display.description.value(task.getDescription());
        display.countMessages.value(task.getNewMessagesCount());
        display.createDate.value(task.getInternalCreateDate().toInstant());
        display.updateDate.value(task.getInternalUpdateDate().toInstant());
        display.commentsTrigger.readonly(comments == null || comments.isEmpty());
        display.commentsTrigger.bindTo(taskComments);
        display.commentsTrigger.onOpen(e -> refreshTaskComments(task));
        display.urgent.onExecute(e -> toggleUrgent(task, display));
        display.urgent.color(task.isUrgent() ? "#F44335" : "#ddd");
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

    private void toggleUrgent(Task<?> task, TasksListItem display) {
        task.setUrgent(!task.isUrgent());
        LayerHelper.taskLayer().saveTaskUrgency(task);
        refreshTask(task, display);
    }

    @Override
    public void refresh() {
        super.refresh();
        tasksList.reload();
    }

}