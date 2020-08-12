package org.siani.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.Task;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.TaskListDatasource;
import org.siani.goros.box.ui.displays.rows.TasksTableRow;
import org.siani.goros.util.DisplayHelper;
import org.siani.goros.util.TaskHelper;

public class TasksTableCatalog extends AbstractTasksTableCatalog<GorosBox> {
    private TaskListDatasource.Inbox inbox;
    private boolean readonly = true;

    public TasksTableCatalog(GorosBox box) {
        super(box);
    }

    public TasksTableCatalog inbox(TaskListDatasource.Inbox inbox) {
        this.inbox = inbox;
        return this;
    }

    public TasksTableCatalog readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public void select(Task task) {
        DisplayHelper.executeDelayed(b -> tasksTable.select(tasksTable.findItem(t -> ((Task)t).getId().equals(task.getId()))), 800);
    }

    public void refresh(Task task) {
        tasksTable.refresh(tasksTable.findItem(t -> ((Task)t).getId().equals(task.getId())), task);
    }

    @Override
    public void init() {
        super.init();
        tasksTable.onAddItem(e -> {
            Task task = e.item();
            TasksTableRow row = e.component();
            row.tasksTableLabelItem.label.value(task.getLabel());
            row.tasksTableLabelItem.state.value(translate(TaskHelper.state(task)));
            row.tasksTableLabelItem.state.backgroundColor(TaskHelper.stateColor(task));
            row.tasksTableDescriptionItem.description.value(task.getDescription());
            row.tasksTableOwnerItem.owner.value(task.getOwner() != null ? task.getOwner().getInfo().getFullname() : null);
            row.tasksTableCountMessagesItem.countMessages.value(task.getNewMessagesCount());
            row.tasksTableCreateDateItem.createDate.value(task.getInternalCreateDate().toInstant());
            row.tasksTableUpdateDateItem.updateDate.value(task.getInternalUpdateDate().toInstant());
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        tasksTable.source(new TaskListDatasource(box(), session(), inbox));
        tasksTable.reload();
    }

}