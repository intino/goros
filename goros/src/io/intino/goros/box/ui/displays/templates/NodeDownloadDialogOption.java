package io.intino.goros.box.ui.displays.templates;

import io.intino.goros.box.GorosBox;
import io.intino.goros.box.ui.datasources.model.Column;

import java.util.List;
import java.util.function.Consumer;

public class NodeDownloadDialogOption extends AbstractNodeDownloadDialogOption<GorosBox> {
    private int index;
    private List<Column> columns;
    private Consumer<Column> selectListener;

    public NodeDownloadDialogOption(GorosBox box) {
        super(box);
    }

    public NodeDownloadDialogOption index(int index) {
        this.index = index;
        return this;
    }

    public NodeDownloadDialogOption columns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    public NodeDownloadDialogOption onSelect(Consumer<Column> listener) {
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
        options.add(translate("None"));
        columns.forEach(o -> options.add(o.label()));
    }

    private void notifySelect() {
        selectListener.accept(selectedColumn());
    }

}