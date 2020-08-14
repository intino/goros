package io.intino.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitList;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.AccountHelper;
import io.intino.goros.util.LayerHelper;

public class BusinessUnitsTemplate extends AbstractBusinessUnitsTemplate<GorosBox> {

    public BusinessUnitsTemplate(GorosBox box) {
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