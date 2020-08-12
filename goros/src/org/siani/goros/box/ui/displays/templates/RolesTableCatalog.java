package org.siani.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.Role;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.RoleListDatasource;
import org.siani.goros.box.ui.datasources.model.role.RoleTypeGrouping;
import org.siani.goros.box.ui.displays.rows.RolesTableRow;
import org.siani.goros.util.DisplayHelper;
import org.siani.goros.util.RoleHelper;

public class RolesTableCatalog extends AbstractRolesTableCatalog<GorosBox> {

    public RolesTableCatalog(GorosBox box) {
        super(box);
    }

    public void select(Role role) {
        DisplayHelper.executeDelayed(b -> rolesTable.select(rolesTable.findItem(n -> ((Role)n).getId().equals(role.getId()))), 800);
    }

    public void refresh(Role role) {
        rolesTable.refresh(rolesTable.findItem(n -> ((Role)n).getId().equals(role.getId())), role);
    }

    @Override
    public void init() {
        super.init();
        rolesTable.onAddItem(e -> {
            Role role = e.item();
            RolesTableRow row = e.component();
            row.rolesTableUserItem.user.value(RoleHelper.userOf(role));
            row.rolesTableUserItem.state.value(translate(RoleHelper.stateLabel(role)));
            row.rolesTableUserItem.state.backgroundColor(RoleHelper.stateColor(role));
            row.rolesTableDefinitionItem.definition.value(RoleHelper.definitionLabelOf(role));
            row.rolesTableTypeItem.type.value(RoleTypeGrouping.from(role.getType().name()).title());
            row.rolesTableNatureItem.nature.value(RoleHelper.natureOf(role));
            row.rolesTableStartDateItem.startDate.value(role.getInternalBeginDate().toInstant());
            row.rolesTableEndDateItem.endDate.value(role.getInternalExpireDate() != null ? role.getInternalExpireDate().toInstant() : null);
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        if (rolesTable.source() == null) rolesTable.source(new RoleListDatasource(box(), session()));
        rolesTable.reload();
    }

}