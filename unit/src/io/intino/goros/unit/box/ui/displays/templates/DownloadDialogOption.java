package io.intino.goros.unit.box.ui.displays.templates;

import io.intino.goros.unit.box.UnitBox;
import io.intino.goros.unit.box.ui.datasources.model.Column;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class DownloadDialogOption extends AbstractDownloadDialogOption<UnitBox> {
    private int index;
    private List<Column> columns;
    private Consumer<Column> selectListener;

    public DownloadDialogOption(UnitBox box) {
        super(box);
    }

    public DownloadDialogOption index(int index) {
        this.index = index;
        return this;
    }

    public DownloadDialogOption columns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    public DownloadDialogOption onSelect(Consumer<Column> listener) {
        this.selectListener = listener;
        return this;
    }

    public Column selectedColumn() {
        String option = options.selection().size() > 0 ? options.selection().get(0) : null;
        option = option != null && option.equals(translate("None")) ? null : option;
        return findColumn(option);
    }

    private Column findColumn(String option) {
        if (option == null) return null;
        return columns.stream().filter(c -> c.label().equals(option)).findFirst().orElse(null);
    }

    @Override
    public void init() {
        super.init();
        options.onSelect(e -> notifySelect());
    }

    @Override
    public void refresh() {
        super.refresh();
        name.value(translate("Column") + " " + (index+1));
        Column selected = selectedColumn();
        options.clear();
        options.add(translate("None"));
        options.addAll(columns.stream().map(Column::label).collect(Collectors.toList()));
        if (selected != null) options.selection(selected.label());
    }

    private void notifySelect() {
        selectListener.accept(selectedColumn());
    }

}