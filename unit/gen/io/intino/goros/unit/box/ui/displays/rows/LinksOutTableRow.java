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

public class LinksOutTableRow extends io.intino.alexandria.ui.displays.components.Row<RowNotifier, org.monet.space.kernel.model.Node, UnitBox> {
	public LinksOutTableLabelItem linksOutTableLabelItem;
	public LinksOutTableDescriptionItem linksOutTableDescriptionItem;

    public LinksOutTableRow(UnitBox box) {
        super(box);
        id("a_938688998");
    }

    @Override
	public void init() {
		super.init();
		if (linksOutTableLabelItem == null) linksOutTableLabelItem = register(new LinksOutTableLabelItem((UnitBox)box()).<LinksOutTableLabelItem>id("a95169672").<LinksOutTableLabelItem>item(LinksOutTableRow.this.item()).owner(LinksOutTableRow.this));
		if (linksOutTableDescriptionItem == null) linksOutTableDescriptionItem = register(new LinksOutTableDescriptionItem((UnitBox)box()).<LinksOutTableDescriptionItem>id("a_1789681555").<LinksOutTableDescriptionItem>item(LinksOutTableRow.this.item()).owner(LinksOutTableRow.this));
	}
}