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

public class AssignTaskDialogTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.User, UnitBox> {
	public AssignTaskDialogTableFullnameItem assignTaskDialogTableFullnameItem;
	public AssignTaskDialogTableEmailItem assignTaskDialogTableEmailItem;

    public AssignTaskDialogTableRow(UnitBox box) {
        super(box);
        id("a1101718209");
    }

    @Override
	public void init() {
		super.init();
		if (assignTaskDialogTableFullnameItem == null) assignTaskDialogTableFullnameItem = register(new AssignTaskDialogTableFullnameItem((UnitBox)box()).<AssignTaskDialogTableFullnameItem>id("a_997855662").<AssignTaskDialogTableFullnameItem>item(AssignTaskDialogTableRow.this.item()).owner(AssignTaskDialogTableRow.this));
		if (assignTaskDialogTableEmailItem == null) assignTaskDialogTableEmailItem = register(new AssignTaskDialogTableEmailItem((UnitBox)box()).<AssignTaskDialogTableEmailItem>id("a_1462841145").<AssignTaskDialogTableEmailItem>item(AssignTaskDialogTableRow.this.item()).owner(AssignTaskDialogTableRow.this));
	}
}