package org.siani.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import org.siani.goros.box.GorosBox;

public class DateRangeFilterTemplate extends AbstractDateRangeFilterTemplate<GorosBox> {
    private String _label;
    private String attribute;
    private Collection collection;
    private boolean applyFilters = true;

    public DateRangeFilterTemplate(GorosBox box) {
        super(box);
    }

    public DateRangeFilterTemplate label(String label) {
        this._label = label;
        return this;
    }

    public DateRangeFilterTemplate attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public DateRangeFilterTemplate bindTo(Collection collection) {
        this.collection = collection;
        return this;
    }

    public void clearSelection() {
        applyFilters = false;
        from.value(null);
        to.value(null);
        applyFilters = true;
    }

    @Override
    public void init() {
        super.init();
        from.value(null);
        to.value(null);
        from.onChange(e -> filter());
        to.onChange(e -> filter());
    }

    @Override
    public void refresh() {
        super.refresh();
        this.label.value(_label + ":");
    }

    private void filter() {
        collection.filter(attribute, from.value(), to.value());
    }

}