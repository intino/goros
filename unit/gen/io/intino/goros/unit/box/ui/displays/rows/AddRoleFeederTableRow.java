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

public class AddRoleFeederTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.FederationUnitFeeder, UnitBox> {
	public AddRoleFeederTableLabelItem addRoleFeederTableLabelItem;
	public AddRoleFeederTablePartnerItem addRoleFeederTablePartnerItem;

    public AddRoleFeederTableRow(UnitBox box) {
        super(box);
        id("a1450478677");
    }

    @Override
	public void init() {
		super.init();
		if (addRoleFeederTableLabelItem == null) addRoleFeederTableLabelItem = register(new AddRoleFeederTableLabelItem((UnitBox)box()).<AddRoleFeederTableLabelItem>id("a_1532510734").<AddRoleFeederTableLabelItem>item(AddRoleFeederTableRow.this.item()).owner(AddRoleFeederTableRow.this));
		if (addRoleFeederTablePartnerItem == null) addRoleFeederTablePartnerItem = register(new AddRoleFeederTablePartnerItem((UnitBox)box()).<AddRoleFeederTablePartnerItem>id("a853170261").<AddRoleFeederTablePartnerItem>item(AddRoleFeederTableRow.this.item()).owner(AddRoleFeederTableRow.this));
	}
}