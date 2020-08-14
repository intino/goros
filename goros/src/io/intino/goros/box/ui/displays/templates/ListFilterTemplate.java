package io.intino.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.alexandria.ui.model.datasource.Group;
import io.intino.goros.box.GorosBox;

import java.util.List;

public class ListFilterTemplate extends AbstractListFilterTemplate<GorosBox> {
    private String _label;
    private String attribute;
    private Collection collection;
    private boolean applyFilters = true;

    public ListFilterTemplate(GorosBox box) {
        super(box);
    }

    public ListFilterTemplate label(String label) {
        this._label = label;
        return this;
    }

    public ListFilterTemplate attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public ListFilterTemplate bindTo(Collection collection) {
        this.collection = collection;
        updateOptions();
        return this;
    }

    public void clearSelection() {
        applyFilters = false;
        options.select();
        applyFilters = true;
    }

    @Override
    public void init() {
        super.init();
        options.onSelect(e -> {
            if (!applyFilters) return;
            collection.filter(attribute, e.selection());
        });
    }

    @Override
    public void refresh() {
        super.refresh();
        this.label.value(_label + ":");
    }

    private void updateOptions() {
        options.clear();
        List<Group> groups = collection.source().groups(attribute);
        groups.forEach(g -> options.add(g.label()));
    }

}