package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.goros.unit.box.UnitBox;

import static java.util.Collections.singletonList;

public class CheckFilterTemplate extends AbstractCheckFilterTemplate<UnitBox> {
    private String _label;
    private String attribute;
    private Collection collection;
    private boolean applyFilters = true;

    public CheckFilterTemplate(UnitBox box) {
        super(box);
    }

    public CheckFilterTemplate label(String label) {
        this._label = label;
        return this;
    }

    public CheckFilterTemplate attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public CheckFilterTemplate bindTo(Collection collection) {
        this.collection = collection;
        return this;
    }

    public void checked(boolean value) {
        if (value) selector.select(_label);
        else selector.select();
    }

    public void clearSelection() {
        applyFilters = false;
        selector.select();
        applyFilters = true;
    }

    @Override
    public void init() {
        super.init();
        selector.onSelect(e -> {
            if (!applyFilters) return;
            if (e.selection().size() > 0) collection.filter(attribute, singletonList(attribute));
            else collection.removeFilter(attribute);
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        selector.add(_label);
    }

}