package org.siani.goros.box.ui.displays.templates;

import org.monet.space.kernel.model.FederationUnit;
import org.monet.space.kernel.model.FederationUnitList;
import org.siani.goros.box.GorosBox;
import org.siani.goros.util.AccountHelper;
import org.siani.goros.util.LayerHelper;

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