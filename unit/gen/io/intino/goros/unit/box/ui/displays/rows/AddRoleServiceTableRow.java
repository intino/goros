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

public class AddRoleServiceTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.FederationUnitService, UnitBox> {
	public AddRoleServiceTableLabelItem addRoleServiceTableLabelItem;
	public AddRoleServiceTablePartnerItem addRoleServiceTablePartnerItem;

    public AddRoleServiceTableRow(UnitBox box) {
        super(box);
        id("a_12860541");
    }

    @Override
	public void init() {
		super.init();
		if (addRoleServiceTableLabelItem == null) addRoleServiceTableLabelItem = register(new AddRoleServiceTableLabelItem((UnitBox)box()).<AddRoleServiceTableLabelItem>id("a_737144416").<AddRoleServiceTableLabelItem>item(AddRoleServiceTableRow.this.item()).owner(AddRoleServiceTableRow.this));
		if (addRoleServiceTablePartnerItem == null) addRoleServiceTablePartnerItem = register(new AddRoleServiceTablePartnerItem((UnitBox)box()).<AddRoleServiceTablePartnerItem>id("a254293905").<AddRoleServiceTablePartnerItem>item(AddRoleServiceTableRow.this.item()).owner(AddRoleServiceTableRow.this));
	}
}