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

public class AddRoleUserTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.User, UnitBox> {
	public AddRoleUserTableFullnameItem addRoleUserTableFullnameItem;
	public AddRoleUserTableEmailItem addRoleUserTableEmailItem;

    public AddRoleUserTableRow(UnitBox box) {
        super(box);
        id("a659926229");
    }

    @Override
	public void init() {
		super.init();
		if (addRoleUserTableFullnameItem == null) addRoleUserTableFullnameItem = register(new AddRoleUserTableFullnameItem((UnitBox)box()).<AddRoleUserTableFullnameItem>id("a1079009762").<AddRoleUserTableFullnameItem>item(AddRoleUserTableRow.this.item()).owner(AddRoleUserTableRow.this));
		if (addRoleUserTableEmailItem == null) addRoleUserTableEmailItem = register(new AddRoleUserTableEmailItem((UnitBox)box()).<AddRoleUserTableEmailItem>id("a1375987805").<AddRoleUserTableEmailItem>item(AddRoleUserTableRow.this.item()).owner(AddRoleUserTableRow.this));
	}
}