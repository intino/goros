package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.UserListDatasource;
import io.intino.goros.unit.box.ui.displays.rows.AssignTaskDialogTableRow;
import io.intino.goros.unit.util.LayerHelper;
import io.intino.goros.unit.util.TaskHelper;
import org.monet.space.kernel.components.layers.TaskLayer;
import org.monet.space.kernel.model.Task;
import org.monet.space.kernel.model.User;

import java.util.function.Consumer;

public class TaskToolbarTemplate extends AbstractTaskToolbarTemplate<UnitBox> {
    private Task task;
    private boolean readonly = true;
    private Consumer<Task> updateListener;
    private Consumer<Task> changeListener;
    private Consumer<Task> abortListener;
    private User selectedUser;

    public TaskToolbarTemplate(UnitBox box) {
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
        if (task == null) return;
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
        unAssign.readonly(true);
        notifyUser(translate("Unassigning task..."), UserMessage.Type.Loading);
        TaskLayer taskLayer = LayerHelper.taskLayer();
        taskLayer.abortTask(task.getId());
        task(taskLayer.loadTask(this.task.getId()));
        abortListener.accept(task);
        notifyUser(translate("Task unassigned"), UserMessage.Type.Success);
        unAssign.readonly(false);
    }

    private void assign(User user, String reason) {
        assign.readonly(true);
        assignTaskOwnerDialogBox.close();
        notifyUser(translate("Assigning task..."), UserMessage.Type.Loading);
        saveTaskOwner(user, reason);
        refresh();
        changeListener.accept(task);
        notifyUser(translate("Task assigned"), UserMessage.Type.Success);
        assign.readonly(false);
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
        assignTaskDialogTable.source(new UserListDatasource(box(), session(), false));
        assignTaskDialogTable.reload();
    }

    private void refreshAssignDialogToolbar() {
        accept.readonly(selectedUser == null);
    }

}