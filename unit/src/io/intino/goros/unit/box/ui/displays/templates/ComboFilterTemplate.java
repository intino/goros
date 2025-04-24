package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.components.Collection;
import io.intino.alexandria.ui.displays.components.SelectorCollectionBox;
import io.intino.alexandria.ui.displays.events.AddCollectionItemEvent;
import io.intino.alexandria.ui.displays.events.AddItemEvent;
import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.ComboFilterDatasource;
import io.intino.goros.unit.box.ui.datasources.model.task.TaskFolderGrouping;
import io.intino.goros.unit.box.ui.displays.items.ComboFilterTemplateMold;

public class ComboFilterTemplate extends AbstractComboFilterTemplate<UnitBox> {
    private String _label;
    private String attribute;
    private Collection collection;
    private boolean applyFilters = true;

    public ComboFilterTemplate(UnitBox box) {
        super(box);
    }

    public ComboFilterTemplate label(String label) {
        this._label = label;
        return this;
    }

    public ComboFilterTemplate attribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    public ComboFilterTemplate bindTo(Collection collection) {
        this.collection = collection;
        updateOptions();
        return this;
    }

    public void multipleSelection(boolean value) {
        options.multipleSelection(value);
    }

    public void clearSelection() {
        applyFilters = false;
        options.select();
        applyFilters = true;
    }

    public void select(TaskFolderGrouping folder) {
        applyFilters = false;
        options.select(folder.title());
        applyFilters = true;
    }

    @Override
    public void init() {
        super.init();
        comboFilterTemplateList.onAddItem(this::refresh);
        options.valueProvider(element -> (String) element);
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
        comboFilterTemplateList.source(new ComboFilterDatasource(box(), session(), collection, attribute));
    }

    private void refresh(AddCollectionItemEvent event) {
        String value = event.item();
        ComboFilterTemplateMold mold = event.component();
        mold.option.value(value);
    }

}