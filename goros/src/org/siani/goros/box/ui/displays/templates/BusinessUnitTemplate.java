package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.exceptions.*;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.FederationUnit;
import org.siani.goros.box.*;

import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.displays.templates.AbstractBusinessUnitTemplate;

public class BusinessUnitTemplate extends AbstractBusinessUnitTemplate<GorosBox> {
    private FederationUnit unit;

    public BusinessUnitTemplate(GorosBox box) {
        super(box);
    }

    public BusinessUnitTemplate unit(FederationUnit unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public void refresh() {
        super.refresh();
        boolean current = BusinessUnit.getInstance().getName().equals(unit.getName());
        label.site(unit.getUrl());
        label.title(unit.getLabel());
        label.visible(!current);
        labelText.value(unit.getLabel());
        labelText.visible(current);
        active.visible(current);
        unitFrame.url(unit.getUrl() + "/banner.jsp?view=minimal");
    }

}