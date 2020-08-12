package org.siani.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.Task;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.TaskListDatasource;
import org.siani.goros.box.ui.displays.items.TasksListItem;
import org.siani.goros.util.DisplayHelper;
import org.siani.goros.util.LayerHelper;
import org.siani.goros.util.TaskHelper;

public class TasksListCatalog extends AbstractTasksListCatalog<GorosBox> {
    private TaskListDatasource.Inbox inbox;
    private boolean readonly = true;

    public TasksListCatalog(GorosBox box) {
        super(box);
    }

    public TasksListCatalog inbox(TaskListDatasource.Inbox inbox) {
        this.inbox = inbox;
        return this;
    }

    public TasksListCatalog readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public void select(Task task) {
        DisplayHelper.executeDelayed(b -> tasksList.select(tasksList.findItem(t -> ((Task)t).getId().equals(task.getId()))), 800);
    }

    public void refresh(Task task) {
        tasksList.refresh(tasksList.findItem(t -> ((Task)t).getId().equals(task.getId())), task);
    }

    @Override
    public void init() {
        super.init();
        tasksList.onAddItem(e -> {
            Task task = e.item();
            TasksListItem item = e.component();
            item.label.value(task.getLabel());
            item.state.value(translate(TaskHelper.state(task)));
            item.state.backgroundColor(TaskHelper.stateColor(task));
            item.owner.value(task.getOwner() != null ? task.getOwner().getInfo().getFullname() : null);
            item.description.value(task.getDescription());
            item.urgent.color(task.isUrgent() ? "primary" : "#ddd");
            item.urgent.onExecute(e1 -> toggleUrgent(task));
            item.countMessages.value(task.getNewMessagesCount());
            item.createDate.value(task.getInternalCreateDate().toInstant());
            item.updateDate.value(task.getInternalUpdateDate().toInstant());
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        tasksList.source(new TaskListDatasource(box(), session(), inbox));
        tasksList.reload();
    }

    private void toggleUrgent(Task task) {
        task.setUrgent(!task.isUrgent());
        LayerHelper.taskLayer().saveTaskUrgency(task);
        tasksList.refresh(tasksList.findItem(t -> ((Task)t).getId().equals(task.getId())), task);
    }

}