package io.intino.goros.unit.box.ui.displays.rows;

import io.intino.alexandria.core.Box;
import io.intino.alexandria.exceptions.*;
import io.intino.alexandria.ui.displays.components.*;
import io.intino.goros.unit.box.ui.*;

import io.intino.goros.unit.box.UnitBox;

import io.intino.goros.unit.box.ui.displays.templates.*;






import io.intino.goros.unit.box.ui.displays.items.*;
import io.intino.goros.unit.box.ui.displays.rows.*;
import io.intino.alexandria.ui.displays.notifiers.RowNotifier;

public class RolesTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.Role, UnitBox> {
	public RolesTableUserItem rolesTableUserItem;
	public RolesTableDefinitionItem rolesTableDefinitionItem;
	public RolesTableTypeItem rolesTableTypeItem;
	public RolesTableNatureItem rolesTableNatureItem;
	public RolesTableStartDateItem rolesTableStartDateItem;
	public RolesTableEndDateItem rolesTableEndDateItem;
	public RolesTableOperationsItem rolesTableOperationsItem;

    public RolesTableRow(UnitBox box) {
        super(box);
        id("a31238320");
    }

    @Override
	public void init() {
		super.init();
		if (rolesTableUserItem == null) rolesTableUserItem = register(new RolesTableUserItem((UnitBox)box()).<RolesTableUserItem>id("a_1732349193").<RolesTableUserItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
		if (rolesTableDefinitionItem == null) rolesTableDefinitionItem = register(new RolesTableDefinitionItem((UnitBox)box()).<RolesTableDefinitionItem>id("a1064485060").<RolesTableDefinitionItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
		if (rolesTableTypeItem == null) rolesTableTypeItem = register(new RolesTableTypeItem((UnitBox)box()).<RolesTableTypeItem>id("a1140630920").<RolesTableTypeItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
		if (rolesTableNatureItem == null) rolesTableNatureItem = register(new RolesTableNatureItem((UnitBox)box()).<RolesTableNatureItem>id("a_1102436782").<RolesTableNatureItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
		if (rolesTableStartDateItem == null) rolesTableStartDateItem = register(new RolesTableStartDateItem((UnitBox)box()).<RolesTableStartDateItem>id("a_1586706557").<RolesTableStartDateItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
		if (rolesTableEndDateItem == null) rolesTableEndDateItem = register(new RolesTableEndDateItem((UnitBox)box()).<RolesTableEndDateItem>id("a_1725386241").<RolesTableEndDateItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
		if (rolesTableOperationsItem == null) rolesTableOperationsItem = register(new RolesTableOperationsItem((UnitBox)box()).<RolesTableOperationsItem>id("a31029305").<RolesTableOperationsItem>item(RolesTableRow.this.item()).owner(RolesTableRow.this));
	}
}