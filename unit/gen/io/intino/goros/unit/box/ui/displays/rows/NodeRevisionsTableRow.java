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

public class NodeRevisionsTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.Revision, UnitBox> {
	public NodeRevisionsTableLabelItem nodeRevisionsTableLabelItem;
	public NodeRevisionsTableOperationsItem nodeRevisionsTableOperationsItem;

    public NodeRevisionsTableRow(UnitBox box) {
        super(box);
        id("a_901221879");
    }

    @Override
	public void init() {
		super.init();
		if (nodeRevisionsTableLabelItem == null) nodeRevisionsTableLabelItem = register(new NodeRevisionsTableLabelItem((UnitBox)box()).<NodeRevisionsTableLabelItem>id("a1423086964").<NodeRevisionsTableLabelItem>item(NodeRevisionsTableRow.this.item()).owner(NodeRevisionsTableRow.this));
		if (nodeRevisionsTableOperationsItem == null) nodeRevisionsTableOperationsItem = register(new NodeRevisionsTableOperationsItem((UnitBox)box()).<NodeRevisionsTableOperationsItem>id("a_1811963633").<NodeRevisionsTableOperationsItem>item(NodeRevisionsTableRow.this.item()).owner(NodeRevisionsTableRow.this));
	}
}