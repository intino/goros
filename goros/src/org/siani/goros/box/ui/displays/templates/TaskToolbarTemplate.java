package org.siani.goros.box.ui.displays.templates;

import org.monet.space.kernel.components.layers.TaskLayer;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.User;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.UserListDatasource;
import org.siani.goros.box.ui.displays.rows.AssignTaskDialogTableRow;
import org.siani.goros.util.LayerHelper;
import org.siani.goros.util.TaskHelper;

import java.util.function.Consumer;

public class TaskToolbarTemplate extends AbstractTaskToolbarTemplate<GorosBox> {
    private Task task;
    private boolean readonly = true;
    private Consumer<Task> updateListener;
    private Consumer<Task> changeListener;
    private Consumer<Task> abortListener;
    private User selectedUser;

    public TaskToolbarTemplate(GorosBox box) {
        super(box);
    }

    public TaskToolbarTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskToolbarTemplate readonly(boolean readonly) {
        this.readonly = readonly;
        return this;
    }

    public TaskToolbarTemplate onUpdate(Consumer<Task> listener) {
        this.updateListener = listener;
        return this;
    }

    public TaskToolbarTemplate onChange(Consumer<Task> listener) {
        this.changeListener = listener;
        return this;
    }

    public TaskToolbarTemplate onAbort(Consumer<Task> listener) {
        this.abortListener = listener;
        return this;
    }

    @Override
    public void init() {
        super.init();
        update.onExecute(e -> updateTask());
        abort.onExecute(e -> abort());
        unAssign.onExecute(e -> unAssign());
        initAssignDialog();
    }

    @Override
    public void refresh() {
        super.refresh();
        assign.visible(!readonly && TaskHelper.isAlive(task) && task.getOwner() == null);
        unAssign.visible(!readonly && TaskHelper.isAlive(task) && task.getOwner() != null);
        abort.visible(!readonly && TaskHelper.isAlive(task));
    }

    private void initAssignDialog() {
        accept.onExecute(e -> assign(selectedUser, reason.value()));
        initUsersTable();
        assignTaskOwnerDialogBox.onOpen(e -> {
            selectedUser = null;
            assignTaskOwnerDialogBox.title(translate("Assign task ::title:: to user...").replace("::title::", task.getLabel()));
            refreshAssignDialog();
        });
    }

    private void updateTask() {
        updateListener.accept(LayerHelper.taskLayer().loadTask(task.getId()));
    }

    private void abort() {
        TaskLayer taskLayer = LayerHelper.taskLayer();
        taskLayer.abortTask(task.getId());
        task(taskLayer.loadTask(this.task.getId()));
        abortListener.accept(task);
    }

    private void assign(User user, String reason) {
        assignTaskOwnerDialogBox.close();
        saveTaskOwner(user, reason);
        refresh();
        changeListener.accept(task);
    }

    private void unAssign() {
        saveTaskOwner(null, "");
        refresh();
        changeListener.accept(task);
    }

    private void saveTaskOwner(User user, String reason) {
        LayerHelper.taskLayer().saveTaskOwner(task, user, reason);
    }

    private void initUsersTable() {
        assignTaskDialogTable.onSelect(e -> {
            selectedUser = e.selection().size() > 0 ? (User) e.selection().get(0) : null;
            refreshAssignDialogToolbar();
        });
        assignTaskDialogTable.onAddItem(e -> {
            User user = e.item();
            AssignTaskDialogTableRow row = e.component();
            row.assignTaskDialogTableFullnameItem.fullName.value(user.getInfo().getFullname());
            row.assignTaskDialogTableEmailItem.email.value(user.getInfo().getEmail());
        });
    }

    private void refreshAssignDialog() {
        refreshUsersTable();
        refreshAssignDialogToolbar();
    }

    private void refreshUsersTable() {
        assignTaskDialogTable.source(new UserListDatasource(box(), session()));
        assignTaskDialogTable.reload();
    }

    private void refreshAssignDialogToolbar() {
        accept.readonly(selectedUser == null);
    }

}