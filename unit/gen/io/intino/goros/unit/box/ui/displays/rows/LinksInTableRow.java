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

public class LinksInTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public LinksInTableLabelItem linksInTableLabelItem;
	public LinksInTableDescriptionItem linksInTableDescriptionItem;

    public LinksInTableRow(UnitBox box) {
        super(box);
        id("a_1298822671");
    }

    @Override
	public void init() {
		super.init();
		if (linksInTableLabelItem == null) linksInTableLabelItem = register(new LinksInTableLabelItem((UnitBox)box()).<LinksInTableLabelItem>id("a1456117662").<LinksInTableLabelItem>item(LinksInTableRow.this.item()).owner(LinksInTableRow.this));
		if (linksInTableDescriptionItem == null) linksInTableDescriptionItem = register(new LinksInTableDescriptionItem((UnitBox)box()).<LinksInTableDescriptionItem>id("a_2069332951").<LinksInTableDescriptionItem>item(LinksInTableRow.this.item()).owner(LinksInTableRow.this));
	}
}