package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.goros.unit.box.UnitBox;

import static java.util.Collections.singletonList;

public class SearchFilterTemplate extends AbstractSearchFilterTemplate<UnitBox> {
    private String _label;
    private String attribute;
    private Collection collection;
    private boolean applyFilters = true;

    public SearchFilterTemplate(UnitBox box) {
        super(box);
    }

    public SearchFilterTemplate label(String label) {
        this._label = label;
        return this;
    }

    public SearchFilterTemplate attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public SearchFilterTemplate bindTo(Collection collection) {
        this.collection = collection;
        return this;
    }

    public void clearSelection() {
        applyFilters = false;
        search.value(null);
        applyFilters = true;
    }

    @Override
    public void init() {
        super.init();
        search.onEnterPress(e -> filter());
    }

    @Override
    public void refresh() {
        super.refresh();
        this.label.value(_label + ":");
    }

    private void filter() {
        if (!applyFilters) return;
        String value = search.value();
        if (value == null || value.isEmpty()) collection.removeFilter(attribute);
        else collection.filter(attribute, singletonList(value));
    }

}