package io.intino.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.goros.box.GorosBox;

public class TrashTableFilters extends AbstractTrashTableFilters<GorosBox> {
    private Collection collection;

    public TrashTableFilters(GorosBox box) {
        super(box);
    }

    public TrashTableFilters bindTo(Collection collection) {
        this.collection = collection;
        updateFilters();
        return this;
    }

    @Override
    public void init() {
        super.init();
        reset.onExecute(e -> resetFilters());
    }

    private void updateFilters() {
        updateType();
        updateDeleteDate();
    }

    private void resetFilters() {
        type.clearSelection();
        deleteDate.clearSelection();
        collection.clearFilters();
    }

    private void updateType() {
        type.label(translate("Type"));
        type.attribute("type");
        type.bindTo(collection);
        type.refresh();
    }

    private void updateDeleteDate() {
        deleteDate.label(translate("Delete date"));
        deleteDate.attribute("deleteDate");
        deleteDate.bindTo(collection);
        deleteDate.refresh();
    }

}