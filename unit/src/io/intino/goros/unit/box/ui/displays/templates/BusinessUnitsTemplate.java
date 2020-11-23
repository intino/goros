package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.util.AccountHelper;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitList;

public class BusinessUnitsTemplate extends AbstractBusinessUnitsTemplate<UnitBox> {

    public BusinessUnitsTemplate(UnitBox box) {
        super(box);
    }

    @Override
    public void refresh() {
        super.refresh();
        FederationUnitList unitList = LayerHelper.federationLayer(session()).loadMembers(AccountHelper.account(session()));
        units.clear();
        unitList.forEach(f -> fill(f, units.add()));
    }

    private void fill(FederationUnit unit, BusinessUnitTemplate display) {
        display.unit(unit);
        display.refresh();
    }

}