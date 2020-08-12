package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.alexandria.ui.displays.events.SelectionEvent;
import io.intino.alexandria.ui.displays.events.actionable.ToggleEvent;
import io.intino.alexandria.ui.displays.events.collection.RefreshCountEvent;
import org.monet.space.kernel.model.Role;
import org.siani.goros.box.GorosBox;
import org.siani.goros.util.Formatters;
import org.siani.goros.util.LayerHelper;

import java.util.List;

public class RolesTemplate extends AbstractRolesTemplate<GorosBox> {
    private Role selectedRole;

    public RolesTemplate(GorosBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        initToolbars();
        initViews();
    }

    private void initToolbars() {
        filters.onToggle(e -> toggleFiltersViewVisibility(e.state()));
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshToolbars();
        refreshView();
        if (!tableView.isVisible()) tableView.show();
        if (!roleView.isVisible() && filters.state() != ToggleEvent.State.On) filters.toggle();
    }

    private void initViews() {
        tableView.onInit(e -> {
            tableView.tableViewStamp.rolesTable.onRefreshItemCount(this::refreshCount);
            tableView.tableViewStamp.rolesTable.onSelect(this::open);
        });
        tableView.onShow(e -> {
            bindCurrentViewTo(tableView.tableViewStamp.rolesTable);
            search.bindTo(tableView.tableViewStamp.rolesTable);
            tableView.tableViewStamp.refresh();
        });
        filtersView.onInit(e -> initFilters());
        roleView.onInit(e -> bindCurrentViewTo(currentCollection()));
        roleView.onShow(e -> {
            roleView.roleStamp.role(reloadSelected());
            roleView.roleStamp.onChange(this::refresh);
            roleView.roleStamp.refresh();
        });
    }

    private void initFilters() {
        filtersView.rolesFiltersStamp.bindTo(currentCollection());
        filtersView.rolesFiltersStamp.refresh();
    }

    private void refreshToolbars() {
        toolbar.onAdd(role -> {
            refresh();
            select(role);
        });
        toolbar.refresh();
    }

    private void refreshCount(RefreshCountEvent event) {
        count.value(Formatters.countMessage(event.count(), translate("role"), translate("roles")));
    }

    private void refreshView() {
        if (tableView.isVisible()) tableView.tableViewStamp.refresh();
    }

    private void refreshFilters() {
        filtersView.rolesFiltersStamp.refresh();
    }

    private void bindCurrentViewTo(Collection collection) {
        if (roleView.isVisible()) roleView.roleStamp.bindTo(collection);
    }

    private Collection currentCollection() {
        return tableView.tableViewStamp.rolesTable;
    }

    private Role reloadSelected() {
        if (selectedRole == null) return null;
        return LayerHelper.roleLayer().loadRole(selectedRole.getId());
    }

    private void toggleFiltersViewVisibility(ToggleEvent.State state) {
        roleView.hide();
        if (state == ToggleEvent.State.On) filtersView.show();
        else filtersView.hide();
    }

    private void updateRolePageVisibility(boolean visible) {
        if (visible) {
            if (filtersView.isVisible()) filters.toggle(ToggleEvent.State.Off);
            roleView.show();
        }
        else roleView.hide();
    }

    private void refresh(Role role) {
        if (tableView.isVisible()) tableView.tableViewStamp.refresh(role);
    }

    private void select(Role role) {
        if (tableView.isVisible()) tableView.tableViewStamp.select(role);
    }

    private void open(SelectionEvent event) {
        List<Role> selection = event.selection();
        open(selection.size() > 0 ? selection.get(0) : null);
    }

    private void open(Role role) {
        selectedRole = roleView.isVisible() && role == null ? null : role;
        updateRolePageVisibility(selectedRole != null);
    }

    private void close() {
        selectedRole = null;
        updateRolePageVisibility(false);
    }

}