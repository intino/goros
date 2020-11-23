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

public class NodeNotesTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, io.intino.goros.unit.box.ui.datasources.model.Note, UnitBox> {
	public NodeNotesTableNameItem nodeNotesTableNameItem;
	public NodeNotesTableValueItem nodeNotesTableValueItem;
	public NodeNotesTableOperationsItem nodeNotesTableOperationsItem;

    public NodeNotesTableRow(UnitBox box) {
        super(box);
        id("a1457901138");
    }

    @Override
	public void init() {
		super.init();
		if (nodeNotesTableNameItem == null) nodeNotesTableNameItem = register(new NodeNotesTableNameItem((UnitBox)box()).<NodeNotesTableNameItem>id("a749380548").<NodeNotesTableNameItem>item(NodeNotesTableRow.this.item()).owner(NodeNotesTableRow.this));
		if (nodeNotesTableValueItem == null) nodeNotesTableValueItem = register(new NodeNotesTableValueItem((UnitBox)box()).<NodeNotesTableValueItem>id("a_1633743967").<NodeNotesTableValueItem>item(NodeNotesTableRow.this.item()).owner(NodeNotesTableRow.this));
		if (nodeNotesTableOperationsItem == null) nodeNotesTableOperationsItem = register(new NodeNotesTableOperationsItem((UnitBox)box()).<NodeNotesTableOperationsItem>id("a_633608022").<NodeNotesTableOperationsItem>item(NodeNotesTableRow.this.item()).owner(NodeNotesTableRow.this));
	}
}