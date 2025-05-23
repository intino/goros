package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.Display;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.*;
import org.monet.bpi.java.FieldBooleanImpl;
import org.monet.bpi.java.FieldDateImpl;
import org.monet.bpi.java.FieldTextImpl;
import org.monet.bpi.types.Date;
import org.monet.metamodel.Distribution;
import org.monet.metamodel.NodeViewProperty;
import org.monet.metamodel.RoleDefinition;
import org.monet.metamodel.SendJobActionProperty;
import org.monet.metamodel.internal.TaskOrderDefinition;
import org.monet.space.kernel.model.*;
import io.intino.goros.unit.box.ui.DisplayProvider;

public class TaskPlaceSendJobTemplate extends AbstractTaskPlaceSendJobTemplate<UnitBox> {
    private Task task;
    private SendJobActionProperty property;
    private DisplayProvider displayProvider;

    public TaskPlaceSendJobTemplate(UnitBox box) {
        super(box);
    }

    public TaskPlaceSendJobTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceSendJobTemplate property(SendJobActionProperty property) {
        this.property = property;
        return this;
    }

    public TaskPlaceSendJobTemplate displayProvider(DisplayProvider provider) {
        this.displayProvider = provider;
        return this;
    }

    @Override
    public void init() {
        super.init();
        waitingView.onShow(e -> refreshWaitingView());
        pendingView.onShow(e -> {
            pendingView.setupBlock.setupToolbar.solveSetupBlock.solveSetup.onExecute(e1 -> setup());
            pendingView.rolesSetupBlock.unAssignedRole.onExecute(e1 -> selectNone());
            refreshPendingView();
        });
        failureView.onShow(e -> refreshFailureView());
    }

    @Override
    public void refresh() {
        super.refresh();
        label.value(Language.getInstance().getModelResource(property.getLabel()));
        waitingView.visible(task.isWaiting());
        pendingView.visible(task.isPending());
        failureView.visible(task.isFailure());
        refreshView();
    }

    private void refreshView() {
        if (pendingView.isVisible()) refreshPendingView();
        else if (waitingView.isVisible()) refreshWaitingView();
        else if (failureView.isVisible()) refreshFailureView();
    }

    private void refreshWaitingView() {
        if (!task.isWaiting()) return;
    }

    private void refreshPendingView() {
        if (!task.isPending()) return;
        if (property.getMode() != null && property.getMode() == SendJobActionProperty.ModeEnumeration.AUTOMATIC) return;
        TaskOrder order = order();
        refreshSelectRoleStep(order);
        refreshSetupStep(order);
    }

    private void refreshSelectRoleStep(TaskOrder order) {
        boolean roleSelected = order != null && order.getRole() != null;
        pendingView.rolesSetupBlock.visible(!roleSelected);
        if (roleSelected) return;

        RoleList roleList = roles();
        pendingView.rolesSetupBlock.openRoles.visible(roleList.getTotalCount() <= 0);
        pendingView.rolesSetupBlock.openRoles.address(path -> "/permisos");
        pendingView.rolesSetupBlock.openRoles.readonly(!RoleHelper.canAccessRoles(session()));
        pendingView.rolesSetupBlock.unAssignedRole.affirmed(translate(DisplayHelper.requireConfirmationMessage(property)));
        pendingView.setupBlock.setupToolbar.solveSetupBlock.solveSetup.readonly(roleList.getTotalCount() <= 0);

        if (roleList.getTotalCount() <= 0) {
            String label = Language.getInstance().getModelResource(roleDefinition().getLabel());
            pendingView.pendingMessage.value(translate("No roles of type ::role:: defined for job").replace("::role::", label));
            return;
        }

        pendingView.pendingMessage.value(translate("Select user to whom send order:"));
        pendingView.rolesSetupBlock.roles.clear();
        roleList.get().values().forEach(role -> fill(role, pendingView.rolesSetupBlock.roles.add()));
    }

    private void refreshSetupStep(TaskOrder order) {
        boolean roleNotSelected = order == null || order.getRole() == null || order.getSetupNodeId() == null;
        pendingView.setupBlock.visible(!roleNotSelected);
        if (roleNotSelected) return;
        Node setupNode = setupNode(order);
        Role role = order.getRole();

        pendingView.rolesSetupBlock.openRoles.visible(false);
        pendingView.rolesSetupBlock.unAssignedRole.visible(false);

        if (setupNode == null)
            pendingView.pendingMessage.value(translate("Sending order..."));
        else {
            pendingView.pendingMessage.value(translate("Setup order for ::role::").replace("::role::", role.getLabel()));
            refreshSetupForm(setupNode);
        }
    }

    private void refreshSetupForm(Node form) {
        pendingView.setupBlock.setupFrame.clear();
        if (form == null) return;
        NodeViewProperty viewProperty = DisplayHelper.defaultEmbeddedView(form);
        Display display = displayProvider.displayFor(form, viewProperty != null ? viewProperty.getCode() : null);
        if (display == null) return;
        pendingView.setupBlock.setupFrame.display(display);
        display.refresh();
    }

    private void refreshFailureView() {
    }

    private void fill(Role role, TaskPlaceRoleTemplate view) {
        view.role(role);
        view.confirmText(translate(DisplayHelper.requireConfirmationMessage(property)));
        view.onSelect(e -> {
            view.readonly(true);
            select(role);
        });
        view.refresh();
    }

    private void select(Role role) {
        task.getProcess().selectSendJobActionRole(role);
        refresh();
    }

    private void selectNone() {
        unAssignedRole.readonly(true);
        select(null);
    }

    private void setup() {
        notifyUser(translate("Setting up job..."), UserMessage.Type.Loading);
        pendingView.setupBlock.setupToolbar.solveSetupBlock.solveSetup.readonly(true);
        pendingView.setupBlock.setupToolbar.loading.visible(true);
        fillOrder();
        task.getProcess().setupSendJobAction();
        pendingView.setupBlock.setupToolbar.loading.visible(false);
        pendingView.setupBlock.setupToolbar.solveSetupBlock.solveSetup.readonly(false);
        notifyUser(translate("Job setup"), UserMessage.Type.Success);
    }

    private void fillOrder() {
        TaskOrder order = order();
        if (order == null) return;
        Node<?> setupNode = setupNode(order);
        if (setupNode == null) return;
        Date startDate = FieldDateImpl.get(setupNode.getAttribute(TaskOrderDefinition.SuggestedStartDateProperty.CODE));
        Date endDate = FieldDateImpl.get(setupNode.getAttribute(TaskOrderDefinition.SuggestedEndDateProperty.CODE));
        order.setSuggestedStartDate(startDate != null ? startDate.getValue() : null);
        order.setSuggestedEndDate(endDate != null ? endDate.getValue() : null);
        order.setComments(FieldTextImpl.get(setupNode.getAttribute(TaskOrderDefinition.CommentsProperty.CODE)));
        order.setUrgent(FieldBooleanImpl.get(setupNode.getAttribute(TaskOrderDefinition.UrgentProperty.CODE)));
        LayerHelper.taskLayer().saveTaskOrder(order);
    }

    private TaskOrder order() {
        String orderId = task.getProcess().getCurrentJobOrderId();
        return orderId != null ? LayerHelper.taskLayer().loadTaskOrder(orderId) : null;
    }

    private Node setupNode(TaskOrder order) {
        return order.getSetupNodeId() != null ? LayerHelper.nodeLayer().loadNode(order.getSetupNodeId()) : null;
    }

    private RoleList roles() {
        RoleDefinition roleDefinition = roleDefinition();
        return AccountHelper.loadNonExpiredRoleList(roleDefinition.getCode(), Role.Nature.Internal);
    }

    private RoleDefinition roleDefinition() {
        return Dictionary.getInstance().getRoleDefinition(property.getRole().getValue());
    }

}