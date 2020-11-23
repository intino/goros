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

public class TrashTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public TrashTableTypeItem trashTableTypeItem;
	public TrashTableLabelItem trashTableLabelItem;
	public TrashTableDeleteDateItem trashTableDeleteDateItem;
	public TrashTableOperationsItem trashTableOperationsItem;

    public TrashTableRow(UnitBox box) {
        super(box);
        id("a_1925750229");
    }

    @Override
	public void init() {
		super.init();
		if (trashTableTypeItem == null) trashTableTypeItem = register(new TrashTableTypeItem((UnitBox)box()).<TrashTableTypeItem>id("a_1929334648").<TrashTableTypeItem>item(TrashTableRow.this.item()).owner(TrashTableRow.this));
		if (trashTableLabelItem == null) trashTableLabelItem = register(new TrashTableLabelItem((UnitBox)box()).<TrashTableLabelItem>id("a_1347607505").<TrashTableLabelItem>item(TrashTableRow.this.item()).owner(TrashTableRow.this));
		if (trashTableDeleteDateItem == null) trashTableDeleteDateItem = register(new TrashTableDeleteDateItem((UnitBox)box()).<TrashTableDeleteDateItem>id("a993587649").<TrashTableDeleteDateItem>item(TrashTableRow.this.item()).owner(TrashTableRow.this));
		if (trashTableOperationsItem == null) trashTableOperationsItem = register(new TrashTableOperationsItem((UnitBox)box()).<TrashTableOperationsItem>id("a_1980355300").<TrashTableOperationsItem>item(TrashTableRow.this.item()).owner(TrashTableRow.this));
	}
}