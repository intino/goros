package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import org.monet.space.kernel.model.BusinessUnit;
import org.monet.space.kernel.model.FederationUnit;

public class BusinessUnitTemplate extends AbstractBusinessUnitTemplate<UnitBox> {
    private FederationUnit unit;

    public BusinessUnitTemplate(UnitBox box) {
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