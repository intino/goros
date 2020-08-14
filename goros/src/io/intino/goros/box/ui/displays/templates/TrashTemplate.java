package io.intino.goros.box.ui.displays.templates;

import io.intino.alexandria.ui.displays.events.actionable.ToggleEvent;
import io.intino.alexandria.ui.displays.events.collection.RefreshCountEvent;
import io.intino.goros.box.GorosBox;
import io.intino.goros.util.Formatters;
import io.intino.goros.util.LayerHelper;

public class TrashTemplate extends AbstractTrashTemplate<GorosBox> {

    public TrashTemplate(GorosBox box) {
        super(box);
    }

    @Override
    public void init() {
        super.init();
        initToolbars();
        initViews();
    }

    @Override
    public void refresh() {
        super.refresh();
        refreshView();
        refreshFilters();
    }

    private void initToolbars() {
        //filters.onToggle(e -> toggleFiltersViewVisibility(e.state()));
        toolbar.onEmptyTrash(e -> emptyTrash());
        search.bindTo(tableView.tableViewStamp.trashTable);
    }

    private void initViews() {
        filtersView.onInit(e -> filtersView.tableFilters.tableFiltersStamp.bindTo(tableView.tableViewStamp.trashTable));
        tableView.tableViewStamp.trashTable.onRefreshItemCount(this::refreshCount);
        tableView.onShow(e -> {
            search.bindTo(tableView.tableViewStamp.trashTable);
            tableView.tableViewStamp.refresh();
            showFilters();
        });
    }

    private void refreshView() {
        tableView.tableViewStamp.refresh();
    }

    private void refreshFilters() {
        //if (!filtersView.isVisible()) filtersView.show();
        //filtersView.tableFilters.tableFiltersStamp.refresh();
    }

    private void toggleFiltersViewVisibility(ToggleEvent.State state) {
        if (state == ToggleEvent.State.On) filtersView.show();
        else filtersView.hide();
    }

    private void showFilters() {
        if (!filtersView.isVisible()) return;
        filtersView.tableFilters.hide();
    }

    private void refreshCount(RefreshCountEvent event) {
        String label = translate("Element").toLowerCase();
        count.value(Formatters.countMessage(event.count(), label, label + " " + translate("deleted")));
    }

    private void emptyTrash() {
        LayerHelper.nodeLayer().emptyTrash();
        tableView.tableViewStamp.refresh();
    }

}