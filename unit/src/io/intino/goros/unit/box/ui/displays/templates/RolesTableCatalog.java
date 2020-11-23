package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.RoleListDatasource;
import io.intino.goros.unit.box.ui.datasources.model.role.RoleTypeGrouping;
import io.intino.goros.unit.box.ui.displays.rows.RolesTableRow;
import io.intino.goros.unit.util.DisplayHelper;
import io.intino.goros.unit.util.RoleHelper;
import org.monet.space.kernel.model.Role;

public class RolesTableCatalog extends AbstractRolesTableCatalog<UnitBox> {

    public RolesTableCatalog(UnitBox box) {
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