package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.Display;
import io.intino.alexandria.ui.displays.UserMessage;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.*;
import org.monet.metamodel.*;
import org.monet.space.kernel.machines.ttm.behavior.ProviderBehavior;
import org.monet.space.kernel.model.*;
import io.intino.goros.unit.box.ui.DisplayProvider;
import org.monet.space.kernel.model.Dictionary;

import java.util.Date;

public class TaskPlaceDelegationTemplate extends AbstractTaskPlaceDelegationTemplate<UnitBox> {
    private Task task;
    private DelegationActionProperty property;
    private DisplayProvider displayProvider;

    public TaskPlaceDelegationTemplate(UnitBox box) {
        super(box);
    }

    public TaskPlaceDelegationTemplate task(Task task) {
        this.task = task;
        return this;
    }

    public TaskPlaceDelegationTemplate property(DelegationActionProperty property) {
        this.property = property;
        return this;
    }

    public TaskPlaceDelegationTemplate displayProvider(DisplayProvider provider) {
        this.displayProvider = provider;
        return this;
    }

    @Override
    public void init() {
        super.init();
        waitingView.onShow(e -> refreshWaitingView());
        pendingView.onShow(e -> {
            pendingView.setupBlock.setupToolbar.solveSetup.onExecute(e1 -> setup());
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
        if (property.getMode() != null && property.getMode() == DelegationActionProperty.ModeEnumeration.AUTOMATIC) return;
        Role.Nature nature = nature();
        TaskOrder order = order();
        refreshSelectRoleStep(order, nature);
        refreshSetupStep(order);
    }

    private void refreshSelectRoleStep(TaskOrder order, Role.Nature nature) {
        if (order != null && order.getRole() != null) return;

        if (nature == null) {
            pendingView.pendingMessage.value(translate("No external/internal provider defined. Contact with administrator"));
            return;
        }

        RoleList roleList = roles(nature);
        pendingView.openRoles.visible(roleList.getTotalCount() <= 0);
        pendingView.openRoles.readonly(!RoleHelper.canAccessRoles(session()));
        pendingView.setupBlock.setupToolbar.solveSetup.readonly(roleList.getTotalCount() <= 0);

        if (roleList.getTotalCount() <= 0) {
            RoleDefinition roleDefinition = roleDefinition(providerDefinition());
            String label = Language.getInstance().getModelResource(roleDefinition.getLabel());
            pendingView.pendingMessage.value(translate("No roles of type ::role:: defined for delegation").replace("::role::", label));
            return;
        }

        pendingView.pendingMessage.value(translate("Select client to whom send order:"));
        pendingView.roles.clear();
        roleList.get().values().forEach(role -> fill(role, pendingView.roles.add()));
    }

    private void refreshFailureView() {
        if (!task.isFailure()) return;
        Date date = this.task.getProcess().getCurrentProvider().getModel().getFailureDate();
        failureDate.value(date.toInstant());
    }

    private void refreshSetupStep(TaskOrder order) {
        if (order == null || order.getRole() == null || order.getSetupNodeId() == null) return;
        Node setupNode = setupNode(order);
        Role role = order.getRole();

        pendingView.openRoles.visible(false);
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

    private void fill(Role role, TaskPlaceRoleTemplate view) {
        view.role(role);
        view.confirmText(translate(DisplayHelper.requireConfirmationMessage(property)));
        view.onSelect(e -> select(role));
        view.refresh();
    }

    private void select(Role role) {
        task.getProcess().selectDelegationActionRole(role);
    }

    private void setup() {
        notifyUser(translate("Setting up delegation..."), UserMessage.Type.Loading);
        task.getProcess().setupDelegationAction();
        notifyUser(translate("Delegation setup"), UserMessage.Type.Success);
    }

    private TaskOrder order() {
        ProviderBehavior currentProvider = task.getProcess().getCurrentProvider();
        String orderId = currentProvider != null ? currentProvider.getModel().getOrderId() : null;
        return orderId != null ? LayerHelper.taskLayer().loadTaskOrder(orderId) : null;
    }

    private Node setupNode(TaskOrder order) {
        return order.getSetupNodeId() != null ? LayerHelper.nodeLayer().loadNode(order.getSetupNodeId()) : null;
    }

    private Role.Nature nature() {
        TaskProviderProperty providerDefinition = providerDefinition();
        if (providerDefinition.getExternal() != null && providerDefinition.getInternal() != null) return Role.Nature.Both;
        else if (providerDefinition.getExternal() != null) return Role.Nature.External;
        else if (providerDefinition.getInternal() != null) return Role.Nature.Internal;
        return null;
    }

    private RoleList roles(Role.Nature nature) {
        TaskProviderProperty providerDefinition = providerDefinition();
        RoleDefinition roleDefinition = roleDefinition(providerDefinition);
        return AccountHelper.loadNonExpiredRoleList(roleDefinition.getCode(), nature);
    }

    private TaskProviderProperty providerDefinition() {
        ProcessDefinition definition = (ProcessDefinition) task.getDefinition();
        String providerKey = property.getProvider().getValue();
        return definition.getTaskProviderPropertyMap().get(providerKey);
    }

    private RoleDefinition roleDefinition(TaskProviderProperty providerDefinition) {
        String roleKey = providerDefinition.getRole().getValue();
        return Dictionary.getInstance().getRoleDefinition(roleKey);
    }

}