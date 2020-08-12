package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import org.siani.goros.box.GorosBox;
import org.siani.goros.box.ui.datasources.RoleListDatasource;

public class RolesFiltersTemplate extends AbstractRolesFiltersTemplate<GorosBox> {
    private Collection collection;

    public RolesFiltersTemplate(GorosBox box) {
        super(box);
    }

    public RolesFiltersTemplate bindTo(Collection collection) {
        this.collection = collection;
        updateFilters();
        expired.checked(true);
        return this;
    }

    @Override
    public void init() {
        super.init();
        reset.onExecute(e -> resetFilters());
    }

    private void resetFilters() {
        definition.clearSelection();
        type.clearSelection();
        nature.clearSelection();
        expired.clearSelection();
        collection.clearFilters();
    }

    private void updateFilters() {
        updateDefinition();
        udpateType();
        udpateNature();
        udpateExpired();
    }

    private void updateDefinition() {
        definition.label(translate("Class"));
        definition.attribute(RoleListDatasource.DefinitionGrouping);
        definition.bindTo(collection);
        definition.multipleSelection(false);
        definition.refresh();
    }

    private void udpateType() {
        type.label(translate("Type"));
        type.attribute(RoleListDatasource.TypeGrouping);
        type.bindTo(collection);
        type.multipleSelection(false);
        type.refresh();
    }

    private void udpateNature() {
        nature.label(translate("Nature"));
        nature.attribute(RoleListDatasource.NatureGrouping);
        nature.bindTo(collection);
        nature.multipleSelection(false);
        nature.refresh();
    }

    private void udpateExpired() {
        expired.label(translate("Non expired"));
        expired.attribute(RoleListDatasource.ExpiredGrouping);
        expired.bindTo(collection);
        expired.refresh();
    }

}